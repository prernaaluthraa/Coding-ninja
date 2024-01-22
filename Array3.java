Open Terminal Session:

Use the "Attach Terminal" activity:
Set the ConnectionType property to the appropriate terminal type.
Configure the ConnectionString property to provide connection details or indicate the terminal window.
Navigate to Summary of Plans in Last 24 Months Header:

Use activities like "Send Control Key" or "Type Into":
Send appropriate keys or commands to navigate to the "Summary of Plans in Last 24 Months" section.
Check if KEPT is Reflecting:

Use the "Get Text" activity:
Set the Selector property to indicate the third column below the header.
Assign the extracted text to a variable (ExtractedText).
Use a condition or string manipulation to check if "KEPT" is present in ExtractedText.
Extract Dates for KEPT and Other Statuses:

Use multiple "Get Text" activities:
Set selectors to extract dates for "Broken," "Deleted," "Changes," "Expired," and "KEPT" from the third column below the header.
Assign each extracted date to a corresponding variable (e.g., BrokenDate, DeletedDate, etc.).
Compare Dates:

Use programming constructs (e.g., If statements):
Compare the dates using conditions. You might need to convert the date strings to DateTime objects for accurate comparison.
Decide whether the date associated with "KEPT" is more recent than the other statuses.
Handle Exception if KEPT Date is Older:

Use the "Log Message" activity or "Throw" activity:
If the date associated with "KEPT" is older than the other statuses, log an exception or use the "Throw" activity to stop the execution.
Here's
