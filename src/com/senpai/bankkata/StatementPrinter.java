package com.senpai.bankkata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    public static final String SEPARATOR = " | ";
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        List<Transaction> copyOfTransactions = new ArrayList(transactions);
        Collections.sort(copyOfTransactions);
        int runningBalance = 0;
        for (Transaction transaction: copyOfTransactions) {
            runningBalance+= transaction.amount();
            console.printLine(statementLine(transaction, runningBalance));
        }
    }

    protected String statementLine(Transaction transaction, int runningBalance) {
        return transaction.date()
                + SEPARATOR
                + transaction.amount()
                + SEPARATOR
                 + runningBalance;
    }
}
