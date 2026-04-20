package com.guru.firstproject.services;

import com.guru.firstproject.entities.Customer;
import com.guru.firstproject.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService{

    private final CustomerRepository customerRepository;
    public CustomerServiceImp(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
}
