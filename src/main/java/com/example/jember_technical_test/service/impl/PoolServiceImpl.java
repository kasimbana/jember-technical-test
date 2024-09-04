package com.example.jember_technical_test.service.impl;

import com.example.jember_technical_test.entity.AuthMethod;
import com.example.jember_technical_test.entity.Pool;
import com.example.jember_technical_test.repository.PoolRepository;
import com.example.jember_technical_test.service.PoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoolServiceImpl implements PoolService {
    private final PoolRepository poolRepository;

    public PoolServiceImpl(PoolRepository poolRepository) {
        this.poolRepository = poolRepository;
    }

    @Override
    public List<Pool> getPoolsByPoolIdsAndAuthMethods(List<String> poolIds, List<AuthMethod> authMethods) {
        if(authMethods == null || authMethods.isEmpty()) {
            return poolRepository.findByDcsPoolIdIn(poolIds);
        }

        return poolRepository.findByPoolIdsAndAuthMethods(poolIds, authMethods);
    }
}
