package com.senpai.bank;

import com.senpai.bankkata.Console;
import com.senpai.bankkata.StatementPrinter;
import com.senpai.bankkata.TransactionRepository;

public class Account {

    public static final String STATEMENTS_HEADER = "DATE | AMOUNT | BALANCE";
    private TransactionRepository transactionRepository;
    private Console console;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, Console console, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.console = console;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.save(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.save(-amount);
    }

    public void printStatements() {
        statementPrinter.printStatements(transactionRepository.allTransactions());
    }
}
