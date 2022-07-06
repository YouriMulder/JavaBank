package com.bank.service;

import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer user) {
        return customerRepository.save(user);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                EntityNotFoundException::new
        );
    }
}
