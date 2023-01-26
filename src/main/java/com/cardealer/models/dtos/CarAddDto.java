package com.cardealer.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarAddDto {
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;
}
