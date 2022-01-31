package fr.camss.kata.business;

import fr.camss.kata.business.statement.Statement;
import fr.camss.kata.business.statement.StatementLine;
import fr.camss.kata.business.statement.StatementPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
import static fr.camss.kata.business.helper.DataSetHelper.DATE_2022_01_31;
import static fr.camss.kata.business.helper.DataSetHelper.NEGATIVE_AMOUNT;
import static fr.camss.kata.business.helper.DataSetHelper.STATEMENT_LINE_DEPOSIT_TEN_AMOUNT;
import static fr.camss.kata.business.helper.DataSetHelper.TEN_AMOUNT;
import static fr.camss.kata.business.helper.DataSetHelper.WITHDRAW_TEN_AMOUNT_OPERATION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AccountTest {

    @Test
    void should_account_have_balance_to_zero_when_created() {
        final Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(BALANCE_ZERO);
    }

    @Test
    void should_account_have_balance_to_ten_when_deposit_amount_of_ten() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_31);
        assertThat(account.getBalance()).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_deposit_on_account_be_rejected_when_amount_is_negative() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.deposit(NEGATIVE_AMOUNT, DATE_2022_01_31))
                .withMessage(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_account_have_balance_to_ten_when_deposit_then_withdraw_amount_of_ten() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_31);

        account.withdraw(TEN_AMOUNT, DATE_2022_01_31);

        assertThat(account.getBalance()).isEqualTo(BALANCE_ZERO);
    }

    @Test
    void should_withdraw_from_account_be_rejected_when_amount_is_negative() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.withdraw(NEGATIVE_AMOUNT, DATE_2022_01_31))
                .withMessage(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_withdraw_from_account_be_rejected_when_amount_is_greater_than_balance() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.withdraw(TEN_AMOUNT, DATE_2022_01_31))
                .withMessage(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
    }

    @Test
    void should_account_have_statement_line_with_deposit_operation_when_deposit_on_account() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_31);

        assertThat(account.getStatement().getStatementLines()).hasSize(1)
                .contains(STATEMENT_LINE_DEPOSIT_TEN_AMOUNT);
    }

    @Test
    void should_account_have_statement_line_with_withdrawal_and_deposit_operation_when_deposit_then_withdraw_from_account() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_31);
        account.withdraw(TEN_AMOUNT, DATE_2022_01_31);

        assertThat(account.getStatement().getStatementLines()).hasSize(2)
                .contains(STATEMENT_LINE_DEPOSIT_TEN_AMOUNT)
                .contains(new StatementLine(WITHDRAW_TEN_AMOUNT_OPERATION, BALANCE_ZERO));
    }

    @Test
    void should_print_statement_with_balance_ten_when_print_from_account_after_ten_deposit() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_31);
        final FakeStatementPrinter fakeStatementPrinter = new FakeStatementPrinter();

        account.printStatement(fakeStatementPrinter);

        assertThat(fakeStatementPrinter.statementLines).containsExactly(STATEMENT_LINE_DEPOSIT_TEN_AMOUNT);
    }

    private static class FakeStatementPrinter implements StatementPrinter {

        private List<StatementLine> statementLines;

        @Override
        public void print(final Statement statement) {
            statementLines = new ArrayList<>(statement.statementLines());
        }
    }
}
