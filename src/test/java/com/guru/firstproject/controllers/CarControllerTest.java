package com.guru.firstproject.controllers;

import com.guru.firstproject.model.Car;
import com.guru.firstproject.services.CarService;
import com.guru.firstproject.services.CarServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;


//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.core.Is.is;

import java.util.UUID;

//@SpringBootTest
@WebMvcTest(CarController.class)
class CarControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CarService carServiceTest;

    CarServiceImp carServiceImpTest = new CarServiceImp();

    @Test
    void testList() throws Exception {
        given(carServiceTest.listTheCars()).willReturn(carServiceImpTest.listTheCars());
        mockMvc.perform(get("/api/v1/cars")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(4)))
                .andExpect(status().isOk())
        ;
    }







    @Test
    void getCarByIdd() throws Exception {
        IO.println("TESTING MOCKITO");
        Car testCar = carServiceImpTest.listTheCars().get(3);
        given(carServiceTest.getCarById(testCar.getId())).willReturn(testCar);

        mockMvc.perform(get("/api/v1/cars/" + testCar.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(testCar.getId().toString())))
                .andExpect(jsonPath("$.brand" ,is(testCar.getBrand().toString())));
    }
}