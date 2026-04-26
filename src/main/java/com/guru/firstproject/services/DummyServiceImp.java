package com.guru.firstproject.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile({"dummyServ", "default"})
@Service
public class DummyServiceImp implements DummyService{
    public String greeting(){
        return "Greeting from Service";
    }
}
