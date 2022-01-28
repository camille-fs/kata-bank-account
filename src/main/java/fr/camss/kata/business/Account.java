package fr.camss.kata.business;

import lombok.Getter;

@Getter
public class Account {
    private Balance balance;

    public Account() {
        this.balance = new Balance();
    }

    public void deposit(final Amount amountTen) {
        balance = balance.add(amountTen);
    }
}
