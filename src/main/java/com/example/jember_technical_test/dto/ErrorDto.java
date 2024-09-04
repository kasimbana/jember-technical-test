package com.example.jember_technical_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorDto {
    @JsonProperty("status")
    private int status;
    @JsonProperty("detail")
    private String detail;
}
