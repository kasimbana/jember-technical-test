package com.example.jember_technical_test;

import com.example.jember_technical_test.dto.ErrorDto;
import com.example.jember_technical_test.dto.PoolFindRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc

class JemberTechnicalTestIT {
	@Autowired
	private MockMvc mvc;
	private final ObjectMapper mapper = new ObjectMapper();
	private String expectedJson;
	private final String poolFindUrl = "/pool-find";
	private static final String AUTH_TOKEN_HEADER_NAME = "Subscription-Key";
	private static final String AUTH_TOKEN = "test-token";

	@BeforeEach
	public void setup() throws IOException {
		expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/poolFindResponse.json")));
	}

	@Test
	public void givenRequestWhenPostPoolFindShouldReturnResponse() throws Exception {
		//given
		String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/poolFindRequest.json")));

		//when
		mvc.perform(
				post(poolFindUrl)
						.header(AUTH_TOKEN_HEADER_NAME, AUTH_TOKEN)
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody)
				)
		//then
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJson));
	}

	@Test
	public void givenNoPoolIdsWhenPostPoolFindShouldReturnBadRequest() throws Exception {
		//given
		PoolFindRequestBody request = new PoolFindRequestBody();
		ErrorDto expectedBody = new ErrorDto(HttpStatus.BAD_REQUEST.value(), "Bad request");

		//when
		mvc.perform(
				post(poolFindUrl)
						.header(AUTH_TOKEN_HEADER_NAME, AUTH_TOKEN)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(request))
				)
		//then
				.andExpect(status().isBadRequest())
				.andExpect(content().json(mapper.writeValueAsString(expectedBody)));
	}

	@Test
	public void givenNonExistingPoolIdWhenPostPoolFindShouldReturnEmptyArray() throws Exception {
		//given
		PoolFindRequestBody request = new PoolFindRequestBody();
		request.setDcsPoolIds(List.of("POOL:00000000"));

		//when
		mvc.perform(
				post(poolFindUrl)
						.header(AUTH_TOKEN_HEADER_NAME, AUTH_TOKEN)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(request))
				)
		//then
				.andExpect(content().json("[]"));
	}

	@Test
	public void givenRequestWithNoSubscriptionKeyShouldReturnUnauthorized() throws Exception {
		//given
		String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/poolFindRequest.json")));

		//when
		mvc.perform(
						post(poolFindUrl)
								.contentType(MediaType.APPLICATION_JSON)
								.content(requestBody)
				)
		//then
				.andExpect(status().isUnauthorized());
	}
}
