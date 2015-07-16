package com.senpai.bankkata;

import com.senpai.bank.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock TransactionRepository transactionRepository;
    @Mock Console console;
    @Mock StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void init(){
        account = new Account(transactionRepository, console, statementPrinter);
    }

    @Test
    public void
    store_a_deposit_transaction() {
        account.deposit(1000);

        verify(transactionRepository).save(1000);
    }

    @Test
    public void
    store_a_withdraw_transaction() {
        account.withdraw(1000);

        verify(transactionRepository).save(-1000);
    }

    @Test public void
    print_all_statements() {
        List<Transaction> transactions = new ArrayList<>();
        when(transactionRepository.allTransactions()).thenReturn(transactions);

        account.printStatements();

        verify(statementPrinter).printStatements(transactions);
    }
}