package com.guru.firstproject.services;

import com.guru.firstproject.Mappers.CarMapper;
import com.guru.firstproject.model.CarBrand;
import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@Service
@RequiredArgsConstructor
public class CarServiceJPA implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarDTO> listTheCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarDTO> getCarById(UUID id) {
        return Optional.ofNullable(carMapper.carToCarDto(carRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public CarDTO addCar(CarDTO carDTO) {
        return null;
    }

    @Override
    public void updateCarById(UUID id, CarDTO carDTO) {

    }

    @Override
    public CarDTO getCarByBrand(CarBrand carBrand) {
        return null;
    }

    @Override
    public void deleteCarById(UUID carId) {

    }
}
