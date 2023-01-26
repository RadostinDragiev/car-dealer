package com.cardealer.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "parts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part extends BaseEntity {
    private String name;

    private BigDecimal price;

    private int quantity;

    @OneToOne
    private Supplier supplier;

    @ManyToMany
    Set<Car> cars;
}
