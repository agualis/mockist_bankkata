package com.senpai.bankkata;

import com.senpai.bank.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    private TransactionRepository transactionRepository;
    @Mock Clock clock;

    @Before
    public void init(){
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    public void
    save_transactions() {

        when(clock.today()).thenReturn("10/04/2014", "11/04/2014");

        transactionRepository.save(500);
        transactionRepository.save(-100);

        assertThat(transactionRepository.allTransactions(), hasItem(transaction("10/04/2014", 500)));
        assertThat(transactionRepository.allTransactions(),hasItem(transaction("11/04/2014", -100)));
    }

    private Transaction transaction(String date, int amount) {
        return new Transaction(date, amount);
    }
}