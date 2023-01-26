package com.cardealer.services;

import com.cardealer.models.dtos.CarAddDto;
import com.cardealer.models.dtos.CarsByMake;
import com.cardealer.models.entities.Car;

import java.util.List;
import java.util.Set;

public interface CarService {
    void addCard(CarAddDto carAddDto);

    Car getRandomCar();

    List<CarsByMake> getAllCarsByMake(String make);
}
