package fr.camss.kata.business.helper;

import fr.camss.kata.business.Amount;
import fr.camss.kata.business.Balance;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountDatasetHelper {

    public static final LocalDateTime DATE_2022_01_30 = LocalDateTime.of(2022, 1, 30, 0, 0);
    public static final LocalDateTime DATE_2022_01_31 = LocalDateTime.of(2022, 1, 31, 0, 0);
    public static final Balance BALANCE_ZERO = new Balance(BigDecimal.ZERO);
    public static final Balance BALANCE_TEN = new Balance(BigDecimal.TEN);
    public static final Amount TEN_AMOUNT = new Amount(BigDecimal.TEN);
    public static final Amount NEGATIVE_AMOUNT = new Amount(BigDecimal.TEN.negate());
}
