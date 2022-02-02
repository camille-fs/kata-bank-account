package fr.camss.kata.infrastructure.statement;

import fr.camss.kata.business.statement.Statement;
import fr.camss.kata.business.statement.StatementLine;
import fr.camss.kata.business.statement.StatementPrinter;

import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.String.format;

public class ConsoleStatementPrinter implements StatementPrinter {

    private static final String HEADER = "| Operation | Amount | Date | Balance |";
    private static final String ROW = "| %s | %s | %s | %s |";
    private static final String LINE_BREAK = "\n";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void print(final Statement statement) {
        final Supplier<StringBuilder> stringBuilderHeaderSupplier = buildStringBuilderHeaderSupplier();

        final StringBuilder statementStringBuilder = statement.statementLines().stream()
                .map(formatStatementLine())
                .collect(stringBuilderHeaderSupplier, StringBuilder::append, StringBuilder::append);

        System.out.print(statementStringBuilder);
    }

    private Function<StatementLine, String> formatStatementLine() {
        return sl -> format(ROW + LINE_BREAK,
                sl.operation().operationType(),
                sl.operation().amount().value(),
                sl.operation().date().format(DATE_TIME_FORMATTER),
                sl.balance().value());
    }

    private Supplier<StringBuilder> buildStringBuilderHeaderSupplier() {
        return () -> new StringBuilder(HEADER).append(LINE_BREAK);
    }
}
