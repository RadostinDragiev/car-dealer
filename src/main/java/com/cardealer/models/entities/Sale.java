package com.cardealer.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity {
    private int discount;

    @OneToOne
    private Car car;

    @OneToOne
    private Customer customer;
}
