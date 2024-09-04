package com.example.jember_technical_test.repository;

import com.example.jember_technical_test.entity.AuthMethod;
import com.example.jember_technical_test.entity.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoolRepository extends JpaRepository<Pool, String> {
    @Query("SELECT p FROM Pool p JOIN p.chargingStations cs JOIN cs.chargingStationAuthMethods auth " +
            "WHERE p.dcsPoolId IN :dcsPoolIds AND auth IN :chargingStationAuthMethods")
    List<Pool> findByPoolIdsAndAuthMethods(
            @Param("dcsPoolIds") List<String> dcsPoolIds,
            @Param("chargingStationAuthMethods") List<AuthMethod> chargingStationAuthMethods
    );

    List<Pool> findByDcsPoolIdIn(List<String> dcsPoolIds);
}
