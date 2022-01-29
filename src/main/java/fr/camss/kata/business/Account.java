package fr.camss.kata.business;

import lombok.Getter;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;

@Getter
public class Account {
    private Balance balance;

    public Account() {
        this.balance = new Balance();
    }

    private static void checkAmountIsNotNegative(final Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
        }
    }

    public void deposit(final Amount amount) {
        checkAmountIsNotNegative(amount);
        balance = balance.add(amount);
    }

    public void withdraw(final Amount amount) {
        checkAmountIsNotNegative(amount);
        checkAmountIsNotGreaterThanBalance(amount);
        balance = balance.subtract(amount);
    }

    private void checkAmountIsNotGreaterThanBalance(final Amount amount) {
        if (amount.value().compareTo(balance.value()) > 0) {
            throw new IllegalArgumentException(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
        }
    }
}
