package com.bank.controller;

import com.bank.model.Customer;
import com.bank.service.CustomerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value="/post")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value="/{id}")
    public Customer findById(@PathVariable @NotNull Long id) {
        return customerService.findById(id);
    }
}