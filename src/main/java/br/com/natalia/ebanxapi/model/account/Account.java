package br.com.natalia.ebanxapi.model.account;

import br.com.natalia.ebanxapi.model.event.EventRegistry;

public class Account {
    private String id;
    private Double balance;

    public Account(EventRegistry deposit){
        this.id = deposit.destination();
        this.balance = deposit.amount();
    }

    public Double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public void deposit(Double amount){
        this.balance = this.balance + amount;
    }

    public void withdraw(Double amount){
        this.balance = this.balance - amount;
    }
}
