package com.example.jember_technical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ChargingStation {
    @Id
    private String dcsCsId;
    @OneToMany(
            mappedBy = "chargingStation"
    )
    private List<ChargePoint> chargePoints;
    private String incomingCsId;
    @ElementCollection(targetClass = AuthMethod.class)
    @CollectionTable(name = "charging_station_auth_methods", joinColumns = @JoinColumn(name = "charging_station_dcs_cs_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "auth_method")
    private List<AuthMethod> chargingStationAuthMethods;
    @ManyToOne
    @JoinColumn(name="pool_dcs_pool_id")
    @JsonIgnore
    private Pool pool;
}