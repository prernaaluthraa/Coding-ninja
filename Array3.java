
# Establish the database connection
cnxn = pyodbc.connect(con_string)
cursor = cnxn.cursor()

# Execute the query
cursor.execute(query)

# Get the column names
column_names = [column[0] for column in cursor.description]

# Fetch all the results
results = cursor.fetchall()

# Create a DataFrame from the results and column names
df = pd.DataFrame(results, columns=column_names)

# Save the DataFrame to an Excel file
output_file_path = '/application/Output.xlsx'
df.to_excel(output_file_path, index=False)

# Close the cursor and connection
cursor.close()
cnxn.close()

print(f"Results saved to '{output_file_path}'")
