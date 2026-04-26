package com.guru.firstproject.controllers;

import com.guru.firstproject.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DummyController {
    private DummyService dummyService;
    @Autowired
    public DummyController(DummyService dummyService){
        this.dummyService = dummyService;
    }
    public String sayHi(){
        return dummyService.greeting();
    }
}
