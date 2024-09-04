package com.example.jember_technical_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PoolLocation {
    @Id
    @JsonIgnore
    private Long id;
    private String city;
    private String countryCode;
    private String houseNumber;
    private String state;
    private String street;
    private String type;
    private String zipCode;
    @Embedded
    private Coordinates coordinates;
    @ManyToOne
    @JoinColumn(name = "pool_dcs_pool_id")
    @JsonIgnore
    private Pool pool;
}
