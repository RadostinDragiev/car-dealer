package com.cardealer.models.dtos;

import com.cardealer.models.entities.Car;
import com.cardealer.models.entities.Customer;
import com.google.gson.annotations.Expose;

public class SaleAddDto {
    @Expose
    private int discount;

    @Expose
    private Car car;

    @Expose
    private Customer customer;
}
