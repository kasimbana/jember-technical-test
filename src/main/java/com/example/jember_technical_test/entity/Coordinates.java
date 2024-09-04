package com.example.jember_technical_test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Coordinates {
    private double latitude;
    private double longitude;
}
