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
public class SuppliersLocalJsonDto {
    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private int partsCount;
}
