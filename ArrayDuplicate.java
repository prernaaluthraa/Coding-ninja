BOT to change the date daily while running the attached SQL query for below highlighted field . ( BOT to change the date as per last run date  )
For Example : 
i. BOT run the SQL query on Friday i.e. 04/14/2023 than date on below query needs to be change to 04/13/2023 ( as last SQL run date )
ii. BOT run the SQL query on Monday i.e. 04/17/2023 than date on below query need to be change to 04/14/2023 ( as last SQL run date )

Date need to be change to below as per provided SQL query
WHERE
	M.[ReviewedByDateTime] >= '04/01/23'
	OR F.[ReviewedByDateTime] >= '04/01/23'
	OR DIL.[ReviewedByDateTime] >= '04/01/23'
	OR S.[ReviewedByDateTime] >= '04/01/23'
Copy and paste the Attached SQL > Click on F5
