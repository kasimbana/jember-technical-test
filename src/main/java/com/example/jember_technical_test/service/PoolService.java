package com.example.jember_technical_test.service;

import com.example.jember_technical_test.entity.AuthMethod;
import com.example.jember_technical_test.entity.Pool;

import java.util.List;

public interface PoolService {
    List<Pool> getPoolsByPoolIdsAndAuthMethods(List<String> poolIds, List<AuthMethod> authMethods);
}
