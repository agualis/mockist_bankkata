package com.senpai.bankkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TransactionShould {

    @Test
    public void
    compare_to_other_transaction() {
        Transaction olderTransaction = new Transaction("02/03/2015", 100);
        Transaction newerTransaction = new Transaction("03/03/2015", 100);
        assertThat(olderTransaction.compareTo(newerTransaction), is(-1));
        assertThat(newerTransaction.compareTo(olderTransaction), is(1));
    }



}