package fr.camss.kata.business;

import fr.camss.kata.business.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public record Statement(List<StatementLine> statementLines) {

    public Statement() {
        this(new ArrayList<>());
    }

    List<StatementLine> getStatementLines() {
        return statementLines;
    }

    public Statement add(final Operation operation, final Balance balance) {
        final List<StatementLine> newStatementLines = new ArrayList<>(statementLines);
        newStatementLines.add(new StatementLine(operation, balance));
        return new Statement(newStatementLines);
    }
}
