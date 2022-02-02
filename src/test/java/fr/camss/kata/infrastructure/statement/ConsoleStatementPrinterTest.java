package fr.camss.kata.infrastructure.statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static fr.camss.kata.business.helper.StatementDatasetHelper.DEPOSIT_WITHDRAW_TEN_AMOUNT_STATEMENT;
import static org.assertj.core.api.Assertions.assertThat;

class ConsoleStatementPrinterTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream standardOut;

    @BeforeEach
    void setup() {
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void should_console_statement_printer_print_statement_lines_in_console_when_print_statement() {
        final ConsoleStatementPrinter consoleStatementPrinter = new ConsoleStatementPrinter();

        consoleStatementPrinter.print(DEPOSIT_WITHDRAW_TEN_AMOUNT_STATEMENT);

        final String expectedPrint = """
                | Operation | Amount | Date | Balance |
                | DEPOSIT | 10 | 30/01/2022 00:00:00 | 10 |
                | WITHDRAWAL | 10 | 31/01/2022 00:00:00 | 0 |
                """;
        assertThat(outputStream.toString()).hasToString(expectedPrint);
    }
}
