package com.guru.firstproject.controllers;

import com.guru.firstproject.model.CarDTO;
import com.guru.firstproject.services.CarService;
import com.guru.firstproject.services.CarServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.mockito.BDDMockito.*;


//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.core.Is.is;

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
        CarDTO testCarDTO = carServiceImpTest.listTheCars().get(3);
        given(carServiceTest.getCarById(testCarDTO.getId())).willReturn(Optional.of(testCarDTO));

        mockMvc.perform(get("/api/v1/cars/" + testCarDTO.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(testCarDTO.getId().toString())))
                .andExpect(jsonPath("$.brand" ,is(testCarDTO.getBrand().toString())));
    }
}