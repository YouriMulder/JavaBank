package com.bank.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_account", referencedColumnName = "credit_account_id")
    private CreditAccount originAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_account", referencedColumnName = "credit_account_id")
    private CreditAccount destinationAccount;

    @Column(name = "amount")
    private Integer amount;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public CreditAccount getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(CreditAccount originAccount) {
        this.originAccount = originAccount;
    }

    public CreditAccount getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(CreditAccount destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public static Transaction create(
            CreditAccount originAccount,
            CreditAccount destinationAccount,
            Integer amount
    ) {
        Transaction transaction = new Transaction();
        transaction.setOriginAccount(originAccount);
        transaction.setDestinationAccount(destinationAccount);
        transaction.setAmount(amount);
        return transaction;
    }
}
