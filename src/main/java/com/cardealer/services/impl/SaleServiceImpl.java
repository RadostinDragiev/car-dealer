package com.cardealer.services.impl;

import com.cardealer.models.entities.Sale;
import com.cardealer.repositories.SaleRepository;
import com.cardealer.services.CarService;
import com.cardealer.services.CustomerService;
import com.cardealer.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private static final List<Integer> DISCOUNT_LIST = Arrays.asList(0, 5, 10, 15, 20, 30, 40, 50);

    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final CarService carService;
    private final CustomerService customerService;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, CarService carService, CustomerService customerService) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    @Transactional
    public void addSale() {
        Sale sale = new Sale();
        sale.setCar(this.carService.getRandomCar());
        sale.setCustomer(this.customerService.getRandomCustomer());
        sale.setDiscount(DISCOUNT_LIST.get(new Random().nextInt(DISCOUNT_LIST.size())));
       this.saleRepository.saveAndFlush(sale);
    }
}
