package com.cardealer.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
    private String make;

    private String model;

    @Column(name = "travelled_distance")
    private int travelledDistance;
}
