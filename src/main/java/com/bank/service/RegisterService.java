package com.bank.service;


import com.bank.model.CreditAccount;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    CustomerService customerService;

    @Autowired
    CreditAccountService creditAccountService;

    @Autowired
    TransactionService transactionService;

    public CreditAccount register(Customer customer, Integer initialBalance) {
        Customer savedCustomer = customerService.save(customer);
        CreditAccount creditAccount = CreditAccount.create(
            savedCustomer
        );
        creditAccountService.save(creditAccount);

        if(initialBalance != 0) {
            Transaction tx = doInitialBalanceTransaction(creditAccount, initialBalance);
            creditAccount = tx.getDestinationAccount();
        }
        return creditAccount;
    }

    private CreditAccount getCapgeminiBankAccount() {
        return creditAccountService.findById(1L);
    }

    private Transaction doInitialBalanceTransaction(CreditAccount account, Integer initialBalance) {
       return transactionService.transaction(getCapgeminiBankAccount(), account, initialBalance);
    }
}