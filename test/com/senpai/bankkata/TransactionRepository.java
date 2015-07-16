package com.senpai.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private List<Transaction> transactions = new ArrayList<>();
    Clock clock;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void save(int amount) {
        transactions.add(new Transaction(clock.today(), amount));
    }

    public List<Transaction> allTransactions() {
        return transactions;
    }
}
