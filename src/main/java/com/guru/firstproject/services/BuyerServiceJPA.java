package com.guru.firstproject.services;

import com.guru.firstproject.Mappers.BuyerMapper;
import com.guru.firstproject.model.BuyerDTO;
import com.guru.firstproject.repositories.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Primary
@Service
@RequiredArgsConstructor

public class BuyerServiceJPA implements BuyerService {

    BuyerRepository buyerRepository;
    BuyerMapper buyerMapper;

    @Override
    public List<BuyerDTO> listTheBuyers() {
        return List.of();
    }

    @Override
    public BuyerDTO getBuyerById(UUID id) {
        return null;
    }

    @Override
    public BuyerDTO addBuyer(BuyerDTO buyerDTO) {
        return null;
    }

    @Override
    public void updateBuyer(UUID id, BuyerDTO buyerDTO) {

    }

    @Override
    public void deleteBuyer(UUID buyerId) {

    }
}
