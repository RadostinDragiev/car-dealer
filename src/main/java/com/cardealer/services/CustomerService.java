package com.cardealer.services;

import com.cardealer.models.dtos.CustomerAddDto;
import com.cardealer.models.entities.Customer;

public interface CustomerService {
    void addCustomer(CustomerAddDto customerAddDto);

    Customer getRandomCustomer();
}
