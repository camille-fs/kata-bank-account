package fr.camss.kata.business;

import fr.camss.kata.business.operation.Operation;
import fr.camss.kata.business.statement.Statement;
import fr.camss.kata.business.statement.StatementPrinter;

import java.time.LocalDateTime;

import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.operation.OperationType.DEPOSIT;
import static fr.camss.kata.business.operation.OperationType.WITHDRAWAL;

public class Account {
    private Statement statement;
    private Balance balance;

    public Account() {
        this.balance = new Balance();
        this.statement = new Statement();
    }

    public void deposit(final Amount amount, final LocalDateTime date) {
        balance = balance.add(amount);
        statement = statement.add(new Operation(DEPOSIT, amount, date), balance);
    }

    public void withdraw(final Amount amount, final LocalDateTime date) {
        checkAmountIsNotGreaterThanBalance(amount);
        balance = balance.subtract(amount);
        statement = statement.add(new Operation(WITHDRAWAL, amount, date), balance);
    }

    public void printStatement(final StatementPrinter statementPrinter) {
        statementPrinter.print(statement);
    }

    private void checkAmountIsNotGreaterThanBalance(final Amount amount) {
        if (!balance.has(amount)) {
            throw new IllegalArgumentException(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
        }
    }

    public Balance getBalance() {
        return balance;
    }

    public Statement getStatement() {
        return statement;
    }
}
