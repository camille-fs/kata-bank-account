package fr.camss.kata.business;

import java.math.BigDecimal;

public record Balance(BigDecimal value) {

    public Balance() {
        this(BigDecimal.ZERO);
    }

    public Balance add(final Amount amount) {
        return new Balance(value.add(amount.value()));
    }

    public Balance subtract(final Amount amount) {
        return new Balance(value.subtract(amount.value()));
    }
}
