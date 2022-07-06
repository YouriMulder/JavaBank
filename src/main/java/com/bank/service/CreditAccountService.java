package com.bank.service;

import com.bank.model.CreditAccount;
import com.bank.model.Customer;
import com.bank.repository.CreditAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CreditAccountService {

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    public CreditAccount save(CreditAccount creditAccount) {
        return creditAccountRepository.save(creditAccount);
    }

    public CreditAccount findById(Long id) {
        return creditAccountRepository.findById(id).orElseThrow(
                EntityNotFoundException::new
        );
    }

    public Boolean hasEnoughBalance(CreditAccount account, Integer amount) {
        return account.getBalance() >= amount;
    }

    public CreditAccount withdraw(CreditAccount account, Integer amount) {
        CreditAccount updatedAccount = findById(account.getCreditAccountId());
        if(amount <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid amount in withdraw %d", amount)
            );
        }
        if(!hasEnoughBalance(updatedAccount, amount)) {
            throw new IllegalArgumentException(
                    String.format("CreditAccount %s. Does not have enough balance %d", updatedAccount, amount)
            );
        }
        account.setBalance(updatedAccount.getBalance() - amount);
        save(updatedAccount);
        return updatedAccount;
    }

    public CreditAccount deposit(CreditAccount account, Integer amount) {
        CreditAccount updatedAccount = findById(account.getCreditAccountId());
        updatedAccount.setBalance(account.getBalance() + amount);
        save(updatedAccount);
        return updatedAccount;
    }
}
