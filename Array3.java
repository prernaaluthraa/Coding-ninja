"Go to Director >P2> Enter Loan No in Loan No field > Hit Enter
Go to DLQ2 screen 
(a) Check if DLQ2 is set up
If yes ; follow below point (b)
If No ; tag an exception - DLQ2 not set up

(b) Refer TYP: field It is reflect Plan Type as "" 22 , 44 , 31 , 46 , 55 , 56 , 3 ""
If yes ; follow below point (c)
If No ; tag an exception - PLAN TYPE not equal to Final Mod

(c) Refer PLAN STATUS = KEPT
If Yes than procced to next step
If No > than Refer Summary of Plans in Last 24 Months Header
Check if KEPT is reflecting below this header Summary > If yes than compare the date it should be the recent one  from all other status ( like Broken , Deleted , Changes , Expired) - Note : BOT to refer the date available in 3rd column below this header
If KEPT date is recent from all other Status than proceed to next step
If KEPT date if older than other status than tag an exception - DQL2 not equal to KEPT"


"Go to Director >P2> Enter Loan No in Loan No field > Hit Enter
Go to DLQ2 screen 
(a) Check if DLQ2 is set up
If yes ; follow below point (b)
If No ; tag an exception - DLQ2 not set up

(b) Refer TYP: field It is reflect Plan Type as "" 22 , 44 , 31 , 46 , 55 , 56 , 3 ""
If yes ; follow below point (c)
If No ; tag an exception - PLAN TYPE not equal to Final Mod

(c) Refer PLAN STATUS = KEPT
If Yes than procced to next step
If No ; tag an exception - DQL2 not equal to KEPT"
