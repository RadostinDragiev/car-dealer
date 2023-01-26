package com.cardealer.models.dtos;

import com.cardealer.models.entities.Supplier;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartAddDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private int quantity;

    @Expose
    private Supplier supplier;
}
