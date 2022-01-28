package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import static fr.camss.kata.business.helper.DataSetHelper.AMOUNT_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
import static org.assertj.core.api.Assertions.assertThat;

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
}
