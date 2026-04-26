package com.guru.firstproject.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//import static org.junit.jupiter.api.Assertions.*;
//@ActiveProfiles("dummyServ")
@SpringBootTest
class DummyControllerTest {
    @Autowired
    DummyController dummyController;

    @Test
    void test(){
        IO.println(dummyController.sayHi() + "WWW");}
}