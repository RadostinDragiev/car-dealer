package com.cardealer;

import com.cardealer.models.dtos.CarAddDto;
import com.cardealer.models.dtos.CustomerAddDto;
import com.cardealer.models.dtos.PartAddDto;
import com.cardealer.models.dtos.SupplierAddDto;
import com.cardealer.services.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;

import static com.cardealer.constants.GlobalConstants.*;

@Controller
public class ApplicationRunner implements CommandLineRunner {
    private final Gson gson;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public ApplicationRunner(Gson gson, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.gson = gson;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();

        for (int i = 0; i < new Random().nextInt(30); i++) {
            this.saleService.addSale();
        }
    }

    private void seedData() throws FileNotFoundException {
        SupplierAddDto[] supplierAddDtos = this.gson.fromJson(new FileReader(SUPPLIERS_FILE_PATH), SupplierAddDto[].class);
        Arrays.stream(supplierAddDtos).forEach(this.supplierService::addSupplier);

        PartAddDto[] partAddDtos = this.gson.fromJson(new FileReader(PARTS_FILE_PATH), PartAddDto[].class);
        Arrays.stream(partAddDtos).forEach(this.partService::addPart);

        CarAddDto[] carAddDto = this.gson.fromJson(new FileReader(CARS_FILE_PATH), CarAddDto[].class);
        Arrays.stream(carAddDto).forEach(this.carService::addCard);

        CustomerAddDto[] customerAddDtos = this.gson.fromJson(new FileReader(CUSTOMERS_FILE_PATH), CustomerAddDto[].class);
        Arrays.stream(customerAddDtos).forEach(this.customerService::addCustomer);
    }
}
