package com.guru.firstproject.controllers;

import com.guru.firstproject.Mappers.CarMapper;
import com.guru.firstproject.entities.CarJPA;
import com.guru.firstproject.model.CarBrand;
import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.repositories.CarRepository;
import org.hibernate.annotations.NotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;



@SpringBootTest
class CarControllerIntegrationTest {

    @Autowired
    CarController controller;

    @Autowired
    CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;



    @Transactional
    @Rollback
    @Test
    void testUpdate() throws ChangeSetPersister.NotFoundException {
        CarJPA carJPA = carRepository.findAll().get(0);
        CarDTO carDTO = carMapper.carToCarDto(carJPA);
        carDTO.setId(null);
        String model = "GG5";
        carDTO.setModel(model);

        ResponseEntity responseEntity = controller.handleUpdate(carJPA.getId(),carDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.valueOf(204));
        assertThat(carJPA.getId()).isNotNull();
        IO.println(carRepository.findById(carJPA.getId()).get().getBrand());
    }
    @Test
    void updateError(){
        assertThrows(ChangeSetPersister.NotFoundException.class, ()->{
            controller.handleUpdate(UUID.randomUUID(), CarDTO.builder().build());
        });
    }

    @Transactional
    @Rollback
    @Test
    void addCar(){
        CarDTO carDTO = CarDTO.builder()
                .brand(CarBrand.BMW)
                .model("M5")
                .price(BigDecimal.valueOf(5555.00))
                .build();

        ResponseEntity responseEntity = controller.handlePost(carDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] IdURI = responseEntity.getHeaders().getLocation().getPath().split("/");
        String header = responseEntity.getHeaders().toString();
        String loc = responseEntity.getHeaders().getLocation().toString();
        UUID saveId = UUID.fromString(IdURI[4]);

        Optional<CarJPA> carJPA = carRepository.findById(saveId);
        assertThat(carJPA).isNotNull();
    }

    @Test
    void testGetById(){
        CarJPA carJPA = carRepository.findAll().get(0);
        CarDTO carDTO = controller.getCarById(carJPA.getId());

        assertThat(carDTO.getType()).isEqualTo(carJPA.getType());
        IO.println(carDTO.getId().toString());
        assertThat(carDTO).isNotNull();

    }

    @Test
    void testListTheCars(){
        List<CarDTO> carDTOList = controller.carsList();
        assertThat(carDTOList.size()).isEqualTo(4);
    }
    @Test
    void printall(){
        IO.println(controller.carsList().toString());
    }
    @Rollback
    @Transactional
    @Test
    void testCarListEmpty(){
        carRepository.deleteAll();
        List<CarDTO> carDTOList = controller.carsList();
        assertThat(carDTOList.size()).isEqualTo(0);
    }
}