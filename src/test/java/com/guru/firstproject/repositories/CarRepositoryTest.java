package com.guru.firstproject.repositories;

import com.guru.firstproject.entities.CarJPA;
import com.guru.firstproject.model.CarBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;

    @Test
    void testNewCar(){
        CarJPA car = carRepository.save(CarJPA.builder()
                        .brand(CarBrand.BMW)
                .build());

        assertThat(car).isNotNull();
        assertThat(car.getId()).isNotNull();
    }
}