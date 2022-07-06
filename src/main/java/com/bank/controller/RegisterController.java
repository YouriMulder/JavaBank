package com.bank.controller;

import com.bank.model.CreditAccount;
import com.bank.model.Customer;
import com.bank.service.RegisterService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreditAccount save(
            @RequestBody ObjectNode jsonBody
    ) {
        Customer customer = Customer.create(
                jsonBody.get("firstName").asText(),
                jsonBody.get("lastName").asText()
        );

        Integer initialBalance = jsonBody.get("initialBalance").asInt();
        return registerService.register(customer, initialBalance);
    }
}
