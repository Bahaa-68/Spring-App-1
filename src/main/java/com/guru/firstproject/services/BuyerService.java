package com.guru.firstproject.services;

import com.guru.firstproject.model.BuyerDTO;

import java.util.List;
import java.util.UUID;

public interface BuyerService {
    List<BuyerDTO> listTheBuyers();
    BuyerDTO getBuyerById(UUID id);

    BuyerDTO addBuyer(BuyerDTO buyerDTO);

    void updateBuyer(UUID id, BuyerDTO buyerDTO);

    void deleteBuyer(UUID buyerId);
}
