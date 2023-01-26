package com.cardealer.models.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "parts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Part extends BaseEntity {
    private String name;

    private BigDecimal price;

    private int quantity;

    @ManyToOne(targetEntity = Supplier.class, fetch = FetchType.EAGER)
    private Supplier supplier;

    @ManyToMany(mappedBy = "parts", cascade = CascadeType.ALL)
    private Set<Car> cars;
}
