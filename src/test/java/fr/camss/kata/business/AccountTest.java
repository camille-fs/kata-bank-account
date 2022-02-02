package fr.camss.kata.business;

import fr.camss.kata.business.statement.Statement;
import fr.camss.kata.business.statement.StatementLine;
import fr.camss.kata.business.statement.StatementPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_ZERO;
import static fr.camss.kata.business.helper.AccountDatasetHelper.DATE_2022_01_30;
import static fr.camss.kata.business.helper.AccountDatasetHelper.DATE_2022_01_31;
import static fr.camss.kata.business.helper.AccountDatasetHelper.NEGATIVE_AMOUNT;
import static fr.camss.kata.business.helper.AccountDatasetHelper.TEN_AMOUNT;
import static fr.camss.kata.business.helper.StatementDatasetHelper.DEPOSIT_TEN_AMOUNT_STATEMENT_LINE;
import static fr.camss.kata.business.helper.StatementDatasetHelper.WITHDRAW_TEN_AMOUNT_STATEMENT_LINE;
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
        account.deposit(TEN_AMOUNT, DATE_2022_01_30);
        assertThat(account.getBalance()).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_deposit_on_account_be_rejected_when_amount_is_negative() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.deposit(NEGATIVE_AMOUNT, DATE_2022_01_30))
                .withMessage(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_account_have_balance_to_ten_when_deposit_then_withdraw_amount_of_ten() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_30);

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
        account.deposit(TEN_AMOUNT, DATE_2022_01_30);

        assertThat(account.getStatement().statementLines()).hasSize(1)
                .contains(DEPOSIT_TEN_AMOUNT_STATEMENT_LINE);
    }

    @Test
    void should_account_have_statement_line_with_withdrawal_and_deposit_operation_when_deposit_then_withdraw_from_account() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_30);
        account.withdraw(TEN_AMOUNT, DATE_2022_01_31);

        assertThat(account.getStatement().statementLines()).hasSize(2)
                .contains(DEPOSIT_TEN_AMOUNT_STATEMENT_LINE)
                .contains(WITHDRAW_TEN_AMOUNT_STATEMENT_LINE);
    }

    @Test
    void should_print_statement_with_balance_ten_when_print_from_account_after_ten_deposit() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT, DATE_2022_01_30);
        final FakeStatementPrinter fakeStatementPrinter = new FakeStatementPrinter();

        account.printStatement(fakeStatementPrinter);

        assertThat(fakeStatementPrinter.statementLines).containsExactly(DEPOSIT_TEN_AMOUNT_STATEMENT_LINE);
    }

    private static class FakeStatementPrinter implements StatementPrinter {

        private List<StatementLine> statementLines;

        @Override
        public void print(final Statement statement) {
            statementLines = new ArrayList<>(statement.statementLines());
        }
    }
}
