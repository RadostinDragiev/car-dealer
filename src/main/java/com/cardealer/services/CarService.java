package com.cardealer.services;

import com.cardealer.models.dtos.CarAddDto;
import com.cardealer.models.dtos.CarsByMakeJsonDto;
import com.cardealer.models.entities.Car;

import java.util.List;

public interface CarService {
    void addCard(CarAddDto carAddDto);

    Car getRandomCar();

    List<CarsByMakeJsonDto> getAllCarsByMake(String make);
}
