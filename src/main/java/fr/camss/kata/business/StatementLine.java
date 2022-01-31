package fr.camss.kata.business;

import fr.camss.kata.business.operation.Operation;

public record StatementLine(Operation operation, Balance balance) {
}
