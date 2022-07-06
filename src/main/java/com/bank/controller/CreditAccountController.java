package com.bank.controller;

import com.bank.model.CreditAccount;
import com.bank.service.CreditAccountService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit-account")
public class CreditAccountController {

    @Autowired
    CreditAccountService creditAccountService;

    @GetMapping(value="/{id}")
    public CreditAccount findById(@PathVariable @NotNull Long id) {
        return creditAccountService.findById(id);
    }
}
