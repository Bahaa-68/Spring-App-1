package com.guru.firstproject.services;

import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.model.CarBrand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarService {
    List<CarDTO> listTheCars();

    Optional<CarDTO> getCarById(UUID id);

    CarDTO addCar(CarDTO carDTO);

    void updateCarById(UUID id, CarDTO carDTO);

    CarDTO getCarByBrand(CarBrand carBrand);

    void deleteCarById(UUID carId);
}
