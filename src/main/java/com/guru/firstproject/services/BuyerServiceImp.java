package com.guru.firstproject.services;

import com.guru.firstproject.model.Buyer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
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
        log.debug(buyer1.getId().toString());
    }


    @Override
    public List<Buyer> listTheBuyers(){
        return new ArrayList<>(buyerMap.values());
    }
    @Override
    public Buyer getBuyerById(UUID id){
        return buyerMap.get(id);
    }

    @Override
    public Buyer addBuyer(Buyer buyer){
        Buyer newBuyer = Buyer.builder()
                .id(UUID.randomUUID())
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .age(buyer.getAge())
                .budget(buyer.getBudget())
                .build() ;
        buyerMap.put(newBuyer.getId(),newBuyer);
        return newBuyer;
    }

    public void updateBuyer(UUID id, Buyer buyer){
        Buyer current = buyerMap.get(id);
        current.setFirstName(buyer.getFirstName());
        current.setLastName(buyer.getLastName());
        current.setAge(buyer.getAge());
        current.setBudget(buyer.getBudget());

        buyerMap.put(current.getId(), current);

    }

    public void deleteBuyer(UUID buyerId){
        buyerMap.remove(buyerId);
    }
}
