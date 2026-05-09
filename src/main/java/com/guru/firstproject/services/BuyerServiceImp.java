package com.guru.firstproject.services;

import com.guru.firstproject.model.BuyerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class BuyerServiceImp implements BuyerService{
    Map<UUID, BuyerDTO> buyerMap;
    public BuyerServiceImp(){
        this.buyerMap = new HashMap<>();

        BuyerDTO buyerDTO1 = BuyerDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Ralf")
                .lastName("Schuhmacher")
                .age(47)
                .budget(7500)
                .build();
        BuyerDTO buyerDTO2 = BuyerDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Arnold")
                .lastName("Schwarz")
                .age(58)
                .budget(15000)
                .build();
        BuyerDTO buyerDTO3 = BuyerDTO.builder()
                .id(UUID.randomUUID())
                .firstName("Osama")
                .lastName("Alqasem")
                .age(35)
                .budget(250000)
                .build();

        buyerMap.put(buyerDTO1.getId(), buyerDTO1);
        buyerMap.put(buyerDTO2.getId(), buyerDTO2);
        buyerMap.put(buyerDTO3.getId(), buyerDTO3);
        log.debug(buyerDTO1.getId().toString());
    }


    @Override
    public List<BuyerDTO> listTheBuyers(){
        return new ArrayList<>(buyerMap.values());
    }
    @Override
    public BuyerDTO getBuyerById(UUID id){
        return buyerMap.get(id);
    }

    @Override
    public BuyerDTO addBuyer(BuyerDTO buyerDTO){
        BuyerDTO newBuyerDTO = BuyerDTO.builder()
                .id(UUID.randomUUID())
                .firstName(buyerDTO.getFirstName())
                .lastName(buyerDTO.getLastName())
                .age(buyerDTO.getAge())
                .budget(buyerDTO.getBudget())
                .build() ;
        buyerMap.put(newBuyerDTO.getId(), newBuyerDTO);
        return newBuyerDTO;
    }

    public void updateBuyer(UUID id, BuyerDTO buyerDTO){
        BuyerDTO current = buyerMap.get(id);
        current.setFirstName(buyerDTO.getFirstName());
        current.setLastName(buyerDTO.getLastName());
        current.setAge(buyerDTO.getAge());
        current.setBudget(buyerDTO.getBudget());

        buyerMap.put(current.getId(), current);

    }

    public void deleteBuyer(UUID buyerId){
        buyerMap.remove(buyerId);
    }
}
