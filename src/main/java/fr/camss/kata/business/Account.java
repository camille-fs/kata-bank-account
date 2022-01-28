package fr.camss.kata.business;

import lombok.Getter;

@Getter
public class Account {
    private final Balance balance;

    public Account() {
        this.balance = new Balance();
    }
}
