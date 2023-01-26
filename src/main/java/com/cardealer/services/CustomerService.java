package com.cardealer.services;

import com.cardealer.models.dtos.CustomerAddDto;
import com.cardealer.models.dtos.CustomersByBirthdateJsonDto;
import com.cardealer.models.entities.Customer;

import java.util.Set;

public interface CustomerService {
    void addCustomer(CustomerAddDto customerAddDto);

    Customer getRandomCustomer();

    Set<CustomersByBirthdateJsonDto> getAllCustomersOrderByBirthdate();
}
