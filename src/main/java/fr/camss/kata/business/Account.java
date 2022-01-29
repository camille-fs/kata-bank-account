package fr.camss.kata.business;

import fr.camss.kata.business.operation.Operation;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.operation.OperationType.DEPOSIT;
import static fr.camss.kata.business.operation.OperationType.WITHDRAWAL;

@Getter
public class Account {
    private Balance balance;
    private final List<Operation> operations = new ArrayList<>();

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
        operations.add(new Operation(DEPOSIT, amount));
    }

    public void withdraw(final Amount amount) {
        checkAmountIsNotNegative(amount);
        checkAmountIsNotGreaterThanBalance(amount);
        balance = balance.subtract(amount);
        operations.add(new Operation(WITHDRAWAL, amount));
    }

    private void checkAmountIsNotGreaterThanBalance(final Amount amount) {
        if (amount.value().compareTo(balance.value()) > 0) {
            throw new IllegalArgumentException(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
        }
    }
}
