package com.cardealer.models.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddDto {
    @Expose
    private String name;

    @Expose
    private LocalDateTime birthDate;

    @Expose
    private boolean isYoungDriver;
}
