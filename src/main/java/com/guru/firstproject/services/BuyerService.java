package com.guru.firstproject.services;

import com.guru.firstproject.model.Buyer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface BuyerService {
    List<Buyer> listTheBuyers();
    Buyer getBuyerById(UUID id);
}
