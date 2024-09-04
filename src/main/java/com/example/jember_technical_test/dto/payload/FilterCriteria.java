package com.example.jember_technical_test.dto.payload;

import com.example.jember_technical_test.entity.AuthMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterCriteria {
    private List<AuthMethod> authenticationMethods;
}
