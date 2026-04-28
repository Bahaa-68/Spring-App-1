package com.guru.firstproject.controllers;

import com.guru.firstproject.model.Buyer;
import com.guru.firstproject.services.BuyerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/buyers")
public class BuyerController {
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> buyersList(){
        return buyerService.listTheBuyers();
    }
    @RequestMapping(value = "{carId}", method = RequestMethod.GET)
    public Buyer getBuyerById(@PathVariable UUID carId){
        return buyerService.getBuyerById(carId);
    }

}
