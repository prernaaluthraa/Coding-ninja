# Save DataFrame to Excel
InputFile = 'InputFile_' + datetime.now().strftime('%m-%d-%Y') + '.xlsx'
df.to_excel('D:/RPA/Prerna/Investor Rules/' + InputFile, index=False)

# Load the Excel file using openpyxl
wb = openpyxl.load_workbook('D:/RPA/Prerna/Investor Rules/' + InputFile)

# Select the active sheet
sheet = wb.active

# Apply formatting to column headers
header_font = styles.Font(color="FFFFFF", bold=True)
header_fill = styles.PatternFill(fill_type="solid", fgColor="000000")

for col_idx, column_name in enumerate(column_names, start=1):
    cell = sheet.cell(row=1, column=col_idx)
    cell.font = header_font
    cell.fill = header_fill

# Save the modified Excel file
wb.save('D:/RPA/Prerna/Investor Rules/' + InputFile)

# Close the cursor and connection
cursor.close()
cnxn.close()

print("Results saved to input file")
