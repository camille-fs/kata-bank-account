package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_TEN;
import static fr.camss.kata.business.helper.AccountDatasetHelper.BALANCE_ZERO;
import static fr.camss.kata.business.helper.AccountDatasetHelper.TEN_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

class BalanceTest {

    @Test
    void should_balance_have_value_zero_when_created() {
        final Balance balance = new Balance();
        assertThat(balance).isEqualTo(BALANCE_ZERO);
    }

    @Test
    void should_balance_have_value_ten_when_created_with_ten() {
        final Balance balance = new Balance(BigDecimal.TEN);
        assertThat(balance).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_balance_have_value_ten_when_add_ten_amount() {
        Balance balance = new Balance();
        balance = balance.add(TEN_AMOUNT);
        assertThat(balance).isEqualTo(BALANCE_TEN);
    }

    @Test
    void should_balance_have_value_zero_when_created_with_ten_then_subtract_ten_amount() {
        Balance balance = BALANCE_TEN;
        balance = balance.subtract(TEN_AMOUNT);
        assertThat(balance).isEqualTo(BALANCE_ZERO);
    }
}
