package com.example.jember_technical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Connector {
    @Id
    @JsonIgnore
    private Long id;
    private String plugType;
    private int powerLevel;
    @ManyToOne
    @JoinColumn(name = "charge_point_dcs_cp_id")
    @JsonIgnore
    private ChargePoint chargePoint;
}
