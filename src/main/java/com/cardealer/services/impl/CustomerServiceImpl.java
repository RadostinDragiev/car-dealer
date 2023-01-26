package com.cardealer.services.impl;

import com.cardealer.models.dtos.CustomerAddDto;
import com.cardealer.models.entities.Customer;
import com.cardealer.repositories.CustomerRepository;
import com.cardealer.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCustomer(CustomerAddDto customerAddDto) {
        Customer customer = this.modelMapper.map(customerAddDto, Customer.class);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = new Random().nextInt((int) this.customerRepository.count()) + 1;
        return this.customerRepository.findById(randomId).get();
    }
}
