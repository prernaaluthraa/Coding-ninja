
# Fetch all the results
results = cursor.fetchall()
print("Number of rows in results:", len(results))
print("Number of columns in results:", len(results[0]))
print("Number of column names:", column_names)

# Create a DataFrame from the results and column names
df = pd.DataFrame.from_records(results, columns=column_names)

print("DataFrame shape:", df.shape)

# Save DataFrame to CSV file without index column
InputFile = 'InputFile_' + datetime.now().strftime('%m-%d-%Y') + '.csv'
df.to_csv('D:/RPA/Prerna/Investor Rules/' + InputFile, index=False)

# Save DataFrame to Excel file with styled column headers
ExcelFile = 'InputFile_' + datetime.now().strftime('%m-%d-%Y') + '.xlsx'
data1 = df[['INVESTOR_ID', 'INVESTOR_DEAL_NAME', 'INVESTOR_CATEGORY', 'MOD_ALLOWED']]
data1.to_excel('D:/RPA/Prerna/Investor Rules/' + ExcelFile, index=False)

# Open the Excel file with openpyxl
workbook = openpyxl.load_workbook('D:/RPA/Prerna/Investor Rules/' + ExcelFile)
worksheet = workbook.active

# Define the fill color for the column headers
header_fill = PatternFill(start_color="FFFF00", end_color="FFFF00", fill_type="solid")

# Apply the fill color to the column headers
for column in range(1, data1.shape[1] + 1):
    cell = worksheet.cell(row=1, column=column)
    cell.fill = header_fill

# Save the modified Excel file
workbook.save('D:/RPA/Prerna/Investor Rules/' + ExcelFile)

# Close the cursor and connection
cursor.close()
cnxn.close()


