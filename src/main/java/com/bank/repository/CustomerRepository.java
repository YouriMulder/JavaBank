package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
