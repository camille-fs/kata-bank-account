package fr.camss.kata.business;

import lombok.Getter;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_AMOUNT_NOT_NEGATIVE;

@Getter
public class Account {
    private Balance balance;

    public Account() {
        this.balance = new Balance();
    }

    private static void checkAmountNotNegative(final Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException(ACCOUNT_DEPOSIT_AMOUNT_NOT_NEGATIVE);
        }
    }

    public void deposit(final Amount amount) {
        checkAmountNotNegative(amount);
        balance = balance.add(amount);
    }

    public void withdraw(final Amount amount) {
        balance = balance.subtract(amount);
    }
}
