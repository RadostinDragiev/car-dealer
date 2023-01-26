package com.cardealer;

import com.cardealer.models.dtos.*;
import com.cardealer.services.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

        //orderedCustomersEx1();

        //carsFromMakeToyota();
    }

    // Query 2 – Cars from Make Toyota
    private void carsFromMakeToyota() {
        try {
            FileWriter fileWriter = new FileWriter(TOYOTA_CARS_FILE_PATH);
            this.gson.toJson(this.carService.getAllCarsByMake("Toyota"), fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to create file " + e.getMessage());
        }
    }

    // Query 1 – Ordered Customers
    private void orderedCustomersEx1() {
        try {
            FileWriter fileWriter = new FileWriter(ORDERED_CUSTOMERS_FILE_PATH);
            this.gson.toJson(this.customerService.getAllCustomersOrderByBirthdate(), fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to create file " + e.getMessage());
        }
    }

    private void seedData() throws FileNotFoundException {
        // Import data for Suppliers from suppliers.json
        SupplierAddDto[] supplierAddDtos = this.gson.fromJson(new FileReader(SUPPLIERS_FILE_PATH), SupplierAddDto[].class);
        Arrays.stream(supplierAddDtos).forEach(this.supplierService::addSupplier);

        // Import data for Parts from parts.json
        PartAddDto[] partAddDtos = this.gson.fromJson(new FileReader(PARTS_FILE_PATH), PartAddDto[].class);
        Arrays.stream(partAddDtos).forEach(this.partService::addPart);

        // Import data for Car from cars.json
        CarAddDto[] carAddDto = this.gson.fromJson(new FileReader(CARS_FILE_PATH), CarAddDto[].class);
        Arrays.stream(carAddDto).forEach(this.carService::addCard);

        // Import data for Customer from customer.json
        CustomerAddDto[] customerAddDtos = this.gson.fromJson(new FileReader(CUSTOMERS_FILE_PATH), CustomerAddDto[].class);
        Arrays.stream(customerAddDtos).forEach(this.customerService::addCustomer);

        // Create random sale records
        for (int i = 0; i < new Random().nextInt(30); i++) {
            this.saleService.addSale();
        }
    }
}
