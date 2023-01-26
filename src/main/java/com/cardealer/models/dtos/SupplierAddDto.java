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
public class SupplierAddDto {
    @Expose
    private String name;

    @Expose
    private boolean isImporter;
}
