package com.cardealer.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sales")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity {
    private int discount;

    @OneToOne
    private Car car;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private Customer customer;
}
