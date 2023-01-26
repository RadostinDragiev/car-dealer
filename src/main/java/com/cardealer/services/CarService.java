package com.cardealer.services;

import com.cardealer.models.dtos.CarAddDto;
import com.cardealer.models.entities.Car;

public interface CarService {
    void addCard(CarAddDto carAddDto);

    Car getRandomCar();
}
