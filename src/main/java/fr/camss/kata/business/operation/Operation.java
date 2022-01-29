package fr.camss.kata.business.operation;

import fr.camss.kata.business.Amount;

public record Operation(OperationType operationType, Amount amount) {
}
