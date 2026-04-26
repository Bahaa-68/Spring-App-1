package com.guru.firstproject.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CarControllerTest {
    @Autowired
    CarController controller;

    @Test
    void getCarById() {
        IO.println(controller.getCarById(UUID.randomUUID()));
    }
}