package com.senpai.bankkata;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class TransactionRepository {

    private Clock clock;
    List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(clock.todayAsString(), amount));
    }


    public void addWithdrawal(int amount) {
        transactions.add(new Transaction(clock.todayAsString(), -amount));

    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }
}
