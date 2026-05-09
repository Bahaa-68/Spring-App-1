package com.guru.firstproject.controllers;

import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarControllerIntegrationTest {

    @Autowired
    CarController controller;

    @Autowired
    CarRepository carRepository;

    @Test
    void testListTheCars(){
        List<CarDTO> carDTOList = controller.carsList();
        assertThat(carDTOList.size()).isEqualTo(4);
    }

//    @Rollback
//    @Transactional
//    @Test
//    void testCarListEmpty(){
//        carRepository.deleteAll();
//        List<CarDTO> carDTOList = controller.carsList();
//        assertThat(carDTOList.size()).isEqualTo(0);
//    }
}