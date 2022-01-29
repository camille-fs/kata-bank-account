package fr.camss.kata.business.common.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionMessages {
    public static final String ACCOUNT_DEPOSIT_WITHDRAW_AMOUNT_NOT_NEGATIVE = "Account deposit or withdraw amount " +
            "must not be negative.";
}
