package com.senpai.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.senpai.bankkata.StatementPrinter.STATEMENT_HEADER;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    @Mock Console console;

    private static final List<Transaction> NO_TRANSACTIONS = EMPTY_LIST;
    private StatementPrinter statetementPrinter;

    @Before
    public void init(){
        statetementPrinter = new StatementPrinter(console);
    }

    @Test
    public void
    allways_print_the_header() {
        //List<Transaction> transactions = asList(new Transaction());
        //transactions
        statetementPrinter.print(NO_TRANSACTIONS);

        verify(console).printLine(STATEMENT_HEADER);
    }

    @Test public void
    print_transactions_in_reverse_chronological_order() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("01/04/2014", 1000));
        transactions.add(new Transaction("02/04/2014", -100));
        transactions.add(new Transaction("10/04/2014", 500));

        statetementPrinter.print(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine(STATEMENT_HEADER);
        inOrder.verify(console).printLine("01/04/2014 | 1000 | 1000");
        inOrder.verify(console).printLine("02/04/2014 | -100 | 900");
        inOrder.verify(console).printLine("10/04/2014 | 500 | 1400");
    }

}