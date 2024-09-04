package com.example.jember_technical_test.dto;

import com.example.jember_technical_test.dto.payload.FilterCriteria;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PoolFindRequestBody {
    private List<String> dcsPoolIds;
    private FilterCriteria filterCriteria;
}
