results = cursor.fetchall()
print("Number of rows in results:", len(results))

# Preprocess the results to handle 'NULL' values
processed_results = []
for row in results:
    processed_row = [value if value != 'NULL' else 'NULL' for value in row]
    processed_results.append(processed_row)

# Create a DataFrame from the processed results and column names if there are rows
if len(processed_results) > 0:
    print("Number of columns in results:", len(processed_results[0]))
    print("Number of column names:", column_names)

    # Create a DataFrame from the processed results and column names
    df = pd.DataFrame(processed_results, columns=column_names)

    InputFile = 'BKFS PLS Investor Rules Input Data_' + datetime.now().strftime('%m.%d.%Y') + '.xlsx'
    df.to_excel('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile, index=False)
    print("Results saved to input file")
