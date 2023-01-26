package com.cardealer.models.dtos;

import com.cardealer.models.entities.Sale;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersByBirthdateJsonDto {
    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private LocalDateTime birthDate;

    @Expose
    private boolean isYoungDriver;

    @Expose
    private Set<Sale> sales;

}
