package com.guru.firstproject.controllers;

import com.guru.firstproject.model.Buyer;
import com.guru.firstproject.services.BuyerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

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
    @RequestMapping("{buyerId}")
    public Buyer getBuyerById(@PathVariable("buyerId") UUID carId){
        IO.println("Buyer with the ID of : "+carId+" has been called");;
        return buyerService.getBuyerById(carId);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Buyer buyer){
        Buyer newBuyer = buyerService.addBuyer(buyer);
         HttpHeaders headers = new HttpHeaders();
         headers.add("Location","api/v1/buyers" + buyer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{buyerId}")
    public ResponseEntity handleUpdate(@PathVariable("buyerId") UUID buyerId, @RequestBody  Buyer buyer){
        buyerService.updateBuyer(buyerId, buyer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{buyerId}")
    public ResponseEntity handleDelete(@PathVariable("buyerId") UUID buyerId){
        buyerService.deleteBuyer(buyerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
