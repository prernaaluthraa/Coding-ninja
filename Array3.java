"MED date from input is :"+in_TransactionItem("MED").ToString

MED date from input is :05/01/2024 00:00:00

Datetime.ParseExact(in_TransactionItem("MED").ToString, “MMddyy” ,System.Globalization.CultureInfo.InvariantCulture)
