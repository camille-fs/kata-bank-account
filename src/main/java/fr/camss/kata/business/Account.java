package fr.camss.kata.business;

import fr.camss.kata.business.operation.Operation;
import lombok.Getter;

import java.time.LocalDateTime;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.operation.OperationType.DEPOSIT;
import static fr.camss.kata.business.operation.OperationType.WITHDRAWAL;

@Getter
public class Account {
    private Statement statement;
    private Balance balance;

    public Account() {
        this.balance = new Balance();
        this.statement = new Statement();
    }

    private static void checkAmountIsNotNegative(final Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
        }
    }

    public void deposit(final Amount amount, final LocalDateTime date) {
        checkAmountIsNotNegative(amount);
        balance = balance.add(amount);
        statement = statement.add(new Operation(DEPOSIT, amount, date), balance);
    }

    public void withdraw(final Amount amount, final LocalDateTime date) {
        checkAmountIsNotNegative(amount);
        checkAmountIsNotGreaterThanBalance(amount);
        balance = balance.subtract(amount);
        statement = statement.add(new Operation(WITHDRAWAL, amount, date), balance);
    }

    private void checkAmountIsNotGreaterThanBalance(final Amount amount) {
        if (amount.value().compareTo(balance.value()) > 0) {
            throw new IllegalArgumentException(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
        }
    }
}
