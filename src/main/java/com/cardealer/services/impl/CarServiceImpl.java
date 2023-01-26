package com.cardealer.services.impl;

import com.cardealer.models.dtos.CarAddDto;
import com.cardealer.models.dtos.CarsByMake;
import com.cardealer.models.entities.Car;
import com.cardealer.models.entities.Part;
import com.cardealer.repositories.CarRepository;
import com.cardealer.services.CarService;
import com.cardealer.services.PartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, PartService partService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.partService = partService;
    }

    @Override
    @Transactional
    public void addCard(CarAddDto carAddDto) {
        Car car = this.modelMapper.map(carAddDto, Car.class);
        Set<Part> parts = new HashSet<>();
        int random = new Random().nextInt(10) + 20;
        for (int i = 10; i < random; i++) {
            Part randomParts = this.partService.getRandomParts();
            parts.add(randomParts);
        }
        car.setParts(parts);
        this.carRepository.saveAndFlush(car);
    }

    @Override
    public Car getRandomCar() {
        long randomId = new Random().nextInt((int) this.carRepository.count()) + 1;
        return this.carRepository.findById(randomId).get();
    }

    @Override
    public List<CarsByMake> getAllCarsByMake(String make) {
        Set<Car> carSet = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make);
        CarsByMake[] carsByMakes = this.modelMapper.map(carSet, CarsByMake[].class);
        return Arrays.stream(carsByMakes).collect(Collectors.toList());
    }
}
