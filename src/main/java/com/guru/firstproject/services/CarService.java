package com.guru.firstproject.services;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.model.CarBrand;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> listTheCars();

    Car getCarById(UUID id);

    Car addCar(Car car);

    void updateCarById(UUID id, Car car);

    Car getCarByBrand(CarBrand carBrand);

    void deleteCarById(UUID carId);
}
