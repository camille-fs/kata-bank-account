package fr.camss.kata.business.statement;

import fr.camss.kata.business.Balance;
import fr.camss.kata.business.operation.Operation;

public record StatementLine(Operation operation, Balance balance) {
}
