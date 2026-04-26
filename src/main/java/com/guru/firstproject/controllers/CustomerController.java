package com.guru.firstproject.controllers;

import com.guru.firstproject.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    String getCustomers1(Model model){
        model.addAttribute("customers_", customerService.findAll());
        return "customers1";
    }
}
