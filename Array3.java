cursor = cnxn.cursor()
print("connection established, yes")

# Execute the query
cursor.execute(query)

# Get the column names
column_names = [column[0] for column in cursor.description]

# Fetch all the results
results = cursor.fetchall()
print("Number od columns in results",len(results[0]))
print("Number of column names",len(column_names))

# data = [tuple(row) for row in results]
# Create a DataFrame from the results and column names
df = pd.DataFrame(results, columns = ['INVESTOR_ID','INVESTOR_DEAL_NAME','INVESTOR_CATEGORY','MOD_ALLOWED','STREAMLINE_ALLOWED','INVESTOR_APPROVAL_REQUIRED','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED','NON_INTERST_BEARING_BALLOON_ALLOWED','INTEREST_RATE_REDUCTION_ALLOWED','INTEREST_BEARING_BALLOON_ALLOWED','MATURITY_EXTEMSION_ALLOWED','DEFERMENT_ALLOWED','FORGIVENESS_ALLOWED','ADDINTERIMMONTH','SHORT_SALE_ALLOWED','SHORT_SALE_DELEGATED','DEED_IN_LIEU_ALLOWED','DIL_DELEGATED','FORBEARANCE_ALLOWED','MESSAGE','INTEREST_RATE_REDUCTION_INCREMENTS','FLOOR_RATE','MARKET_RATE_TYPE','NUMBER_OF_MODS_ALLOWED','NUMBER_CAPITALIZATIONS_ALLOWED','MAX_TERM','MINIMUM_CREDIT_SCORE','TRIAL_DURATION','FORGIVENESS_UPB_LIMIT_PERCENTAGE','FORGIVENESS_LOWER_LTV_LIMIT','SYSDATE','MATURITY_DATE_RESTRICTION','MIN_DAYS_DELINQUENT','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT','MIN_PRE_MOD_DTI','MIN_POST_MOD_DTI','MAXIMUM_POST_MOD_DTI','MINIMUM_PRE_MOD_LTV','FORBEARANCE_LTV_LOWER_LIMIT','FORBEARANCE_UPB_LIMIT_PERCENTAGE','PAYMENT_REDUCTION_PERCENTAGE','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS','MAX_EVAL_DAY_OF_THE_MONTH','STREAMLINE_MIN_DAYS_DELINQUENT','MATURITY_DATE_EXTENTIONS_BY_MONTH','CREDIT_BUREAU_EXPIRATION_DAYS','CREDIT_BUREAU_MIN_DAYS_DELINQUENT','MODLASTUPDATE','FBLASTUPDATE','DILLASTUPDATE','SSLASTUPDATE'])
df = pd.concat([df, data], ignore_index=True)
# Save the DataFrame to an Excel file
output_file_path = 'D:/RPA/Prerna/Investor Rules/DBinput.xlsx'
df.to_excel(output_file_path, index=False)

# Close the cursor and connection
cursor.close()
cnxn.close()

print(f"Results saved to '{output_file_path}'")
