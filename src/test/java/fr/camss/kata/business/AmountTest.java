package fr.camss.kata.business;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static fr.camss.kata.business.common.exception.ExceptionMessages.AMOUNT_NOT_NEGATIVE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AmountTest {

    @Test
    void should_be_rejected_when_amount_is_negative() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Amount(BigDecimal.TEN.negate()))
                .withMessage(AMOUNT_NOT_NEGATIVE);
    }
}
