package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void should_account_have_balance_to_zero_when_created() {
        final Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(BALANCE_ZERO);
    }
}
