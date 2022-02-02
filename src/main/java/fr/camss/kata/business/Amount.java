package fr.camss.kata.business;

import java.math.BigDecimal;

import static fr.camss.kata.business.common.exception.ExceptionMessages.AMOUNT_NOT_NEGATIVE;

public record Amount(BigDecimal value) {

    public Amount {
        checkValueIsNotNegative(value);
    }

    private static void checkValueIsNotNegative(final BigDecimal value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException(AMOUNT_NOT_NEGATIVE);
        }
    }

    private static boolean isNegative(final BigDecimal value) {
        return value.signum() == -1;
    }
}
