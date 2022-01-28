package fr.camss.kata.business;

import java.math.BigDecimal;

public record Balance(BigDecimal value) {

    public Balance() {
        this(BigDecimal.ZERO);
    }
}
