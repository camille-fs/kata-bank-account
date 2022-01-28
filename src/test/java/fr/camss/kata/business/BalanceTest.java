package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.camss.kata.business.helper.DataSetHelper.BALANCE_ZERO;
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
        assertThat(balance).isEqualTo(new Balance(BigDecimal.TEN));
    }
}
