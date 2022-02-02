package fr.camss.kata.business.helper;

import fr.camss.kata.business.operation.Operation;
import fr.camss.kata.business.statement.Statement;
import fr.camss.kata.business.statement.StatementLine;

import java.util.List;

import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_ZERO;
import static fr.camss.kata.business.helper.AccountDatasetHelper.DATE_2022_01_30;
import static fr.camss.kata.business.helper.AccountDatasetHelper.DATE_2022_01_31;
import static fr.camss.kata.business.helper.AccountDatasetHelper.TEN_AMOUNT;
import static fr.camss.kata.business.operation.OperationType.DEPOSIT;
import static fr.camss.kata.business.operation.OperationType.WITHDRAWAL;

public final class StatementDatasetHelper {

    public static final Operation DEPOSIT_TEN_AMOUNT_OPERATION = new Operation(DEPOSIT, TEN_AMOUNT, DATE_2022_01_30);
    public static final Operation WITHDRAW_TEN_AMOUNT_OPERATION = new Operation(WITHDRAWAL, TEN_AMOUNT, DATE_2022_01_31);
    public static final StatementLine DEPOSIT_TEN_AMOUNT_STATEMENT_LINE = new StatementLine(DEPOSIT_TEN_AMOUNT_OPERATION, BALANCE_TEN);
    public static final StatementLine WITHDRAW_TEN_AMOUNT_STATEMENT_LINE = new StatementLine(WITHDRAW_TEN_AMOUNT_OPERATION, BALANCE_ZERO);
    public static final List<StatementLine> DEPOSIT_WITHDRAW_TEN_AMOUNT_STATEMENT_LINES =
            List.of(DEPOSIT_TEN_AMOUNT_STATEMENT_LINE, WITHDRAW_TEN_AMOUNT_STATEMENT_LINE);
    public static final Statement DEPOSIT_WITHDRAW_TEN_AMOUNT_STATEMENT = new Statement(DEPOSIT_WITHDRAW_TEN_AMOUNT_STATEMENT_LINES);

    private StatementDatasetHelper() {
    }
}
