package fr.camss.kata.business.helper;

import fr.camss.kata.business.Amount;
import fr.camss.kata.business.Balance;
import fr.camss.kata.business.StatementLine;
import fr.camss.kata.business.operation.Operation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static fr.camss.kata.business.operation.OperationType.DEPOSIT;
import static fr.camss.kata.business.operation.OperationType.WITHDRAWAL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataSetHelper {

    public static final LocalDateTime DATE_2022_01_31 = LocalDateTime.of(2022, 1, 31, 0, 0);
    public static final Balance BALANCE_ZERO = new Balance(BigDecimal.ZERO);
    public static final Balance BALANCE_TEN = new Balance(BigDecimal.TEN);
    public static final Amount TEN_AMOUNT = new Amount(BigDecimal.TEN);
    public static final Amount NEGATIVE_AMOUNT = new Amount(BigDecimal.TEN.negate());
    public static final Operation DEPOSIT_TEN_AMOUNT_OPERATION = new Operation(DEPOSIT, TEN_AMOUNT, DATE_2022_01_31);
    public static final StatementLine STATEMENT_LINE_DEPOSIT_TEN_AMOUNT = new StatementLine(DEPOSIT_TEN_AMOUNT_OPERATION, BALANCE_TEN);
    public static final Operation WITHDRAW_TEN_AMOUNT_OPERATION = new Operation(WITHDRAWAL, TEN_AMOUNT, DATE_2022_01_31);
}
