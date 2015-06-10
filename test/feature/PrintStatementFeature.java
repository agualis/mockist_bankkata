package feature;

import com.senpai.bankkata.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock Console console;
    @Mock Clock clock;

    private Account account;
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    @Before
    public void init(){
        transactionRepository = new TransactionRepository(clock);
        statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void
    print_statement_containing_all_transactions() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500 | 1400");
        inOrder.verify(console).printLine("02/04/2014 | -100 | 900");
        inOrder.verify(console).printLine("01/04/2014 | 1000 | 1000");
    }

}
