package com.example.jember_technical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ChargePoint {
    @Id
    private String dcsCpId;
    @OneToMany(mappedBy = "chargePoint")
    private List<Connector> connectors;
    private String incomingCpId;
    private boolean dynamicInfoAvailable;
    private boolean isonormedId;
    @ManyToOne
    @JoinColumn(name="charging_station_dcs_cs_id")
    @JsonIgnore
    private ChargingStation chargingStation;
}
