package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.camss.kata.business.common.exception.ExceptionMessages.ACCOUNT_DEPOSIT_AMOUNT_NOT_NEGATIVE;
import static fr.camss.kata.business.helper.DataSetHelper.AMOUNT_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
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
        account.deposit(AMOUNT_TEN);
        assertThat(account.getBalance()).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_deposit_on_account_be_rejected_when_deposit_amount_is_negative() {
        final Account account = new Account();
        final Amount negativeAmount = new Amount(BigDecimal.TEN.negate());

        assertThatIllegalArgumentException().isThrownBy(() -> account.deposit(negativeAmount))
                .withMessage(ACCOUNT_DEPOSIT_AMOUNT_NOT_NEGATIVE);
    }

    @Test
    void should_account_have_balance_to_ten_when_deposit_then_withdraw_amount_of_ten() {
        final Account account = new Account();
        account.deposit(AMOUNT_TEN);
        account.withdraw(AMOUNT_TEN);
        assertThat(account.getBalance()).isEqualTo(BALANCE_ZERO);
    }
}
