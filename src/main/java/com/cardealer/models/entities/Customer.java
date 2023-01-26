package com.cardealer.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthday;

    @Column(name = "is_young_driver")
    private boolean isYoungDriver;
}
