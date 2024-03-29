package com.cardealer.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
    private String make;

    private String model;

    @Column(name = "travelled_distance")
    private long travelledDistance;

    @ManyToMany(targetEntity = Part.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Part> parts;
}
