package fr.camss.kata.business;

import java.math.BigDecimal;

public record Amount(BigDecimal value) {

    public boolean isNegative() {
        return value.signum() == -1;
    }
}
