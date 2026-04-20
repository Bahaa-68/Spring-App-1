package com.guru.firstproject.services;

import com.guru.firstproject.entities.Product;
import com.guru.firstproject.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;
    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

}
