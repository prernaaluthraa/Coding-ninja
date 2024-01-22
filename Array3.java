if(String.IsNullOrEmpty(in_TransactionItem("PTFCAP_AMOUNT").ToString.Trim),"0",in_TransactionItem("PTFCAP_AMOUNT").ToString.Trim)

FHA
"Update Plan Terms > Navigate to Plan Terms Header > Refer Do you want to add an additional month to the Workout Effective Date? field >
Go to  to BIS Input File > Navigate to column name MED and Mod Proccessing Pad > consider the date available below these column and perform below steps to check if Slider needs to move towards "" Yes ""  or "" No ""
-- If the days difference between  MED and Mod Proccessing Pad column is less than 30 days or negative > than move the slider towards "" Yes "" otherwise don't move the slider i.e it should be towards "" No "" and procced to next step
For Example
Med Date - 2/1/2024 (-) Mod Proccessing Pad - 11/09/2023 = Days Difference =  84 ( No need to move slider it should be towards "" No "" )
Med Date - 2/1/2024 (-) Mod Proccessing Pad - 01/03/2024 = Days Difference =  29 ( Move the slider towards "" Yes "" )
Med Date - 2/1/2024 (-) Mod Proccessing Pad - 02/02/2024 = Days Difference =  -1 ( Move the slider towards "" Yes "" )"


FHLMC-FNMA
"If Workout Plan fields reflects Flex Modification (SMDU) - No action required from BOT
If Workout Plan field reflects Flex Modification (Resolve) or FNMA Non-SMDU - than follow below
Update Plan Terms -
Navigate to Plan Terms Header > Refer Do you want to add an additional month to the Workout Effective Date? field > GO to BIS input file > Navigate to column name LAST TRIAL PAYMENT MADE DATE and Column name Trial Due dates end month consider the date available below these column and perform below steps to check if Slider needs to move towards "" Yes ""  or "" No ""
-- Compare the last trial payment made date with Trial due end month if the date below last trial payment made is greater than the trial due date end month than move the slider towards "" Yes "" 
--Compare the last trial payment made date with Trial due end month if the date below last trial payment made is less than Trial due end month  don't move the slider i.e it should be towards "" No "" and  procced to next step"
