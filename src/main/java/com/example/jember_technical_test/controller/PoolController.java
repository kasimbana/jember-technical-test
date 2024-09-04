package com.example.jember_technical_test.controller;

import com.example.jember_technical_test.dto.ErrorDto;
import com.example.jember_technical_test.dto.PoolFindRequestBody;
import com.example.jember_technical_test.entity.AuthMethod;
import com.example.jember_technical_test.service.PoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class PoolController {
    private final PoolService poolService;

    public PoolController(PoolService poolService) {
        this.poolService = poolService;
    }

    @PostMapping("/pool-find")
    public ResponseEntity<?> postPoolFind(@RequestBody PoolFindRequestBody body) {
        if(body.getDcsPoolIds() == null || body.getDcsPoolIds().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), "Bad request"));
        }
        List<AuthMethod> authMethods = body.getFilterCriteria() == null
                ? new ArrayList<>()
                : body.getFilterCriteria().getAuthenticationMethods();
        return ResponseEntity
                .ok()
                .body(poolService.getPoolsByPoolIdsAndAuthMethods(body.getDcsPoolIds(), authMethods));
    }
}
