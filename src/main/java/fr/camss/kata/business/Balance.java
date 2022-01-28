package fr.camss.kata.business;

import java.math.BigDecimal;

public record Balance(BigDecimal value) {

    public Balance() {
        this(BigDecimal.ZERO);
    }

    public Balance add(final Amount amountTen) {
        return new Balance(value.add(amountTen.value()));
    }
}
