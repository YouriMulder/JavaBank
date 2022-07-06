package com.bank.model;

import javax.persistence.*;

@Entity
@Table(name = "credit_account")
public class CreditAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_account_id_generator")
    @SequenceGenerator(name="credit_account_id_generator", sequenceName = "credit_account_id_sequence")
    @Column(name = "credit_account_id")
    private Long creditAccountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "balance")
    private Integer balance;

    public Long getCreditAccountId() {
        return creditAccountId;
    }

    public void setCreditAccountId(Long creditAccountId) {
        this.creditAccountId = creditAccountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public static CreditAccount create(
        Customer customer
    ) {
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setCustomer(customer);
        creditAccount.setBalance(0);
        return creditAccount;
    }
}
