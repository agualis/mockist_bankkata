#Bank kata

##This is the mockist style Bank Kata performed by Sandro Mancuso in his videos Outside In TDD:
##https://www.youtube.com/watch?v=XHnuMjah6ps

###Note there are 7 branches (Step0, ...Step7) so you can check the code in different phases
###You can follow the steps using this presentation:
###https://docs.google.com/presentation/d/1lLWPA6KkxSeu-tixN6nuZYGNJnv3vvnTX-4JZNfZ15E/edit#slide=id.p
###We performed this code in a SenpaiDevs Dojo (July 2015)

Given a client makes a deposit of 1000.00 on 01/04/2014  
And a withdrawal of 100.00 on 02/04/2014  
And a deposit of 500.00 on 10/04/2014  
When she prints her bank statement  
Then she would see:  

DATE | AMOUNT | BALANCE  
10/04/2014 | 500.00 | 1400.00  
02/04/2014 | -100.00 | 900.00  
01/04/2014 | 1000.00 | 1000.00  
