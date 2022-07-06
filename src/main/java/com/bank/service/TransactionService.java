package com.bank.service;

import com.bank.model.CreditAccount;
import com.bank.model.Transaction;
import com.bank.repository.CreditAccountRepository;
import com.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    CreditAccountService creditAccountService;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction transaction(CreditAccount originAccount, CreditAccount destinationAccount, Integer amount) {
        Transaction tx = Transaction.create(originAccount, destinationAccount, amount);
        return transaction(tx);
    }

    public Transaction transaction(Transaction tx) {
        CreditAccount updatedOriginAccount = creditAccountService.withdraw(tx.getOriginAccount(), tx.getAmount());
        CreditAccount updatedDestinationAccount = creditAccountService.deposit(tx.getDestinationAccount(), tx.getAmount());
        Transaction updatedTx = Transaction.create(updatedOriginAccount, updatedDestinationAccount, tx.getAmount());
        save(updatedTx);
        return updatedTx;
    }
}
