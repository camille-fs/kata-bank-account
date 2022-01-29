package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.common.exception.ExceptionMessages.WITHDRAW_AMOUNT_EXCEEDS_BALANCE;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
import static fr.camss.kata.business.helper.DataSetHelper.NEGATIVE_AMOUNT;
import static fr.camss.kata.business.helper.DataSetHelper.TEN_AMOUNT;
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
        account.deposit(TEN_AMOUNT);
        assertThat(account.getBalance()).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_deposit_on_account_be_rejected_when_amount_is_negative() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.deposit(NEGATIVE_AMOUNT))
                .withMessage(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_account_have_balance_to_ten_when_deposit_then_withdraw_amount_of_ten() {
        final Account account = new Account();
        account.deposit(TEN_AMOUNT);

        account.withdraw(TEN_AMOUNT);

        assertThat(account.getBalance()).isEqualTo(BALANCE_ZERO);
    }

    @Test
    void should_withdraw_from_account_be_rejected_when_amount_is_negative() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.withdraw(NEGATIVE_AMOUNT))
                .withMessage(ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_withdraw_from_account_be_rejected_when_amount_is_greater_than_balance() {
        final Account account = new Account();

        assertThatIllegalArgumentException().isThrownBy(() -> account.withdraw(TEN_AMOUNT))
                .withMessage(WITHDRAW_AMOUNT_EXCEEDS_BALANCE);
    }
}
