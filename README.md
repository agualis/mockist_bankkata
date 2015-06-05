Given a client makes a deposit of 1000.00 on 01/04/2014
And a withdrawal of 100.00 on 02/04/2014
And a deposit of 500.00 on 10/04/2014
When she prints her bank statement
Then she would see

DATE | AMOUNT | BALANCE
10/04/2014 | 500.00 | 1400.00
02/04/2014 | -100.00 | 900.00
01/04/2014 | 1000.00 | 1000.00