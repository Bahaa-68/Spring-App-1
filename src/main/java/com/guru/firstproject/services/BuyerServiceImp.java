package com.guru.firstproject.services;

import com.guru.firstproject.model.Buyer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.random.RandomGenerator;

@Slf4j
@Service
public class BuyerServiceImp implements BuyerService{
    Map<UUID, Buyer> buyerMap;
    public BuyerServiceImp(){
        this.buyerMap = new HashMap<>();

        Buyer buyer1 = Buyer.builder()
                .id(UUID.randomUUID())
                .firstName("Ralf")
                .lastName("Schuhmacher")
                .age(47)
                .budget(7500)
                .build();
        Buyer buyer2 = Buyer.builder()
                .id(UUID.randomUUID())
                .firstName("Arnold")
                .lastName("Schwarz")
                .age(58)
                .budget(15000)
                .build();
        Buyer buyer3 = Buyer.builder()
                .id(UUID.randomUUID())
                .firstName("Osama")
                .lastName("Alqasem")
                .age(35)
                .budget(250000)
                .build();

        buyerMap.put(buyer1.getId(),buyer1);
        buyerMap.put(buyer2.getId(),buyer2);
        buyerMap.put(buyer3.getId(),buyer3);
    }
    @Override
    public List<Buyer> listTheBuyers(){
        return new ArrayList<>(buyerMap.values());
    }
    @Override
    public Buyer getBuyerById(UUID id){
        return buyerMap.get(id);
    }
}
