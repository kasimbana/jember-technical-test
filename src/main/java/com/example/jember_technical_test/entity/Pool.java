package com.example.jember_technical_test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Pool {
    @Id
    private String dcsPoolId;
    private String incomingPoolId;
    private boolean open24h;
    private String access;
    private String poolLocationType;
    @OneToMany(mappedBy = "pool")
    private List<PoolLocation> poolLocations;
    @OneToMany(mappedBy = "pool")
    private List<ChargingStation> chargingStations;
}