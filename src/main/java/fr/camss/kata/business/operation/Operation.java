package fr.camss.kata.business.operation;

import fr.camss.kata.business.Amount;

import java.time.LocalDateTime;

public record Operation(OperationType operationType, Amount amount, LocalDateTime date) {
}
