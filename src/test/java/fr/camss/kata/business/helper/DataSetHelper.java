package fr.camss.kata.business.helper;

import fr.camss.kata.business.Amount;
import fr.camss.kata.business.Balance;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataSetHelper {

    public static final Balance BALANCE_ZERO = new Balance(BigDecimal.ZERO);
    public static final Balance BALANCE_TEN = new Balance(BigDecimal.TEN);
    public static final Amount AMOUNT_TEN = new Amount(BigDecimal.TEN);
}
