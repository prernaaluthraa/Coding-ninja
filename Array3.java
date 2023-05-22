import pyodbc
import pandas as pd
import openpyxl

# def IncomeCalculatordb(loanNum):
def read_query(file_path):
    with open(file_path, 'r') as file:
        query = file.read()
    return query

query_file_path = 'D:/RPA/Prerna/catalyst reporting/Query.txt'
# filename = 'data.xlsx'   
query = read_query(query_file_path)
print(query)

drivers = [item for item in pyodbc.drivers()]
print("Establishing connection")
print("############### DRIVERS",drivers)
driver = drivers[0]
server = '10.72.8.53'
database = 'InvestorRulesMSP'
uid = 'svcs_rpa_prod_bot1'
pwd = 'OcwenBOAT@123'
SSO = 'Trusted_Connection=yes'
timeout = '30'
con_string = f'driver={driver};server={server};database={database};uid={uid};pwd={pwd};'
cnxn = pyodbc.connect(con_string)
print("connection established")
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
df = pd.DataFrame(results, columns = column_names)
#data = df[['INVESTOR_ID','INVESTOR_DEAL_NAME','INVESTOR_CATEGORY','MOD_ALLOWED','STREAMLINE_ALLOWED','INVESTOR_APPROVAL_REQUIRED','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED','NON_INTERST_BEARING_BALLOON_ALLOWED','INTEREST_RATE_REDUCTION_ALLOWED','INTEREST_BEARING_BALLOON_ALLOWED','MATURITY_EXTEMSION_ALLOWED','DEFERMENT_ALLOWED','FORGIVENESS_ALLOWED','ADDINTERIMMONTH','SHORT_SALE_ALLOWED','SHORT_SALE_DELEGATED','DEED_IN_LIEU_ALLOWED','DIL_DELEGATED','FORBEARANCE_ALLOWED','MESSAGE','INTEREST_RATE_REDUCTION_INCREMENTS','FLOOR_RATE','MARKET_RATE_TYPE','NUMBER_OF_MODS_ALLOWED','NUMBER_CAPITALIZATIONS_ALLOWED','MAX_TERM','MINIMUM_CREDIT_SCORE','TRIAL_DURATION','FORGIVENESS_UPB_LIMIT_PERCENTAGE','FORGIVENESS_LOWER_LTV_LIMIT','SYSDATE','MATURITY_DATE_RESTRICTION','MIN_DAYS_DELINQUENT','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT','MIN_PRE_MOD_DTI','MIN_POST_MOD_DTI','MAXIMUM_POST_MOD_DTI','MINIMUM_PRE_MOD_LTV','FORBEARANCE_LTV_LOWER_LIMIT','FORBEARANCE_UPB_LIMIT_PERCENTAGE','PAYMENT_REDUCTION_PERCENTAGE','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS','MAX_EVAL_DAY_OF_THE_MONTH','STREAMLINE_MIN_DAYS_DELINQUENT','MATURITY_DATE_EXTENTIONS_BY_MONTH','CREDIT_BUREAU_EXPIRATION_DAYS','CREDIT_BUREAU_MIN_DAYS_DELINQUENT','MODLASTUPDATE','FBLASTUPDATE','DILLASTUPDATE','SSLASTUPDATE']]
data=df
data1['INVESTOR_ID']=data['INVESTOR_ID']
data1['INVESTOR_DEAL_NAME']=data['INVESTOR_DEAL_NAME']
data1['INVESTOR_CATEGORY']=data['INVESTOR_CATEGORY']
data1['MOD_ALLOWED']=data['MOD_ALLOWED']
data1['STREAMLINE_ALLOWED']=data['STREAMLINE_ALLOWED']
data1['INVESTOR_APPROVAL_REQUIRED']=data['INVESTOR_APPROVAL_REQUIRED']
data1['PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED']=data['PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED']
data1['NON_INTERST_BEARING_BALLOON_ALLOWED']=data['NON_INTERST_BEARING_BALLOON_ALLOWED']
data1['INTEREST_RATE_REDUCTION_ALLOWED']=data['INTEREST_RATE_REDUCTION_ALLOWED']
data1['INTEREST_BEARING_BALLOON_ALLOWED']=data['INTEREST_BEARING_BALLOON_ALLOWED']
data1['MATURITY_EXTEMSION_ALLOWED']=data['MATURITY_EXTEMSION_ALLOWED']
data1['DEFERMENT_ALLOWED']=data['DEFERMENT_ALLOWED']
data1['FORGIVENESS_ALLOWED']=data['FORGIVENESS_ALLOWED']
data1['ADDINTERIMMONTH']=data['ADDINTERIMMONTH']
data1['SHORT_SALE_ALLOWED']=data['SHORT_SALE_ALLOWED']
data1['SHORT_SALE_DELEGATED']=data['SHORT_SALE_DELEGATED']
data1['DEED_IN_LIEU_ALLOWED']=data['DEED_IN_LIEU_ALLOWED']
data1['DIL_DELEGATED']=data['DIL_DELEGATED']
data1['FORBEARANCE_ALLOWED']=data['FORBEARANCE_ALLOWED']
data1['MESSAGE']=data['MESSAGE']
data1['INTEREST_RATE_REDUCTION_INCREMENTS']=data['INTEREST_RATE_REDUCTION_INCREMENTS']
data1['FLOOR_RATE']=data['FLOOR_RATE']
data1['MARKET_RATE_TYPE']=data['MARKET_RATE_TYPE']
data1['NUMBER_OF_MODS_ALLOWED']=data['NUMBER_OF_MODS_ALLOWED']
data1['NUMBER_CAPITALIZATIONS_ALLOWED']=data['NUMBER_CAPITALIZATIONS_ALLOWED']
data1['MAX_TERM']=data['MAX_TERM']
data1['MINIMUM_CREDIT_SCORE']=data['MINIMUM_CREDIT_SCORE']
data1['TRIAL_DURATION']=data['TRIAL_DURATION']
data1['FORGIVENESS_UPB_LIMIT_PERCENTAGE']=data['FORGIVENESS_UPB_LIMIT_PERCENTAGE']
data1['FORGIVENESS_LOWER_LTV_LIMIT']=data['FORGIVENESS_LOWER_LTV_LIMIT']
data1['SYSDATE']=data['SYSDATE']
data1['MATURITY_DATE_RESTRICTION']=data['MATURITY_DATE_RESTRICTION']
data1['MIN_DAYS_DELINQUENT']=data['MIN_DAYS_DELINQUENT']
data1['IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT']=data['IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT']
data1['MIN_PRE_MOD_DTI']=data['MIN_PRE_MOD_DTI']
data1['MIN_POST_MOD_DTI']=data['MIN_POST_MOD_DTI']
data1['MAXIMUM_POST_MOD_DTI']=data['MAXIMUM_POST_MOD_DTI']
data1['MINIMUM_PRE_MOD_LTV']=data['MINIMUM_PRE_MOD_LTV']
data1['FORBEARANCE_LTV_LOWER_LIMIT']=data['FORBEARANCE_LTV_LOWER_LIMIT']
data1['FORBEARANCE_UPB_LIMIT_PERCENTAGE']=data['FORBEARANCE_UPB_LIMIT_PERCENTAGE']
data1['PAYMENT_REDUCTION_PERCENTAGE']=data['PAYMENT_REDUCTION_PERCENTAGE']
data1['DECREMENTS_FOR_FORBEARANCE_FORGIVENESS']=data['DECREMENTS_FOR_FORBEARANCE_FORGIVENESS']
data1['MAX_EVAL_DAY_OF_THE_MONTH']=data['MAX_EVAL_DAY_OF_THE_MONTH']
data1['STREAMLINE_MIN_DAYS_DELINQUENT']=data['STREAMLINE_MIN_DAYS_DELINQUENT']
data1['MATURITY_DATE_EXTENTIONS_BY_MONTH']=data['MATURITY_DATE_EXTENTIONS_BY_MONTH']
data1['CREDIT_BUREAU_EXPIRATION_DAYS']=data['CREDIT_BUREAU_EXPIRATION_DAYS']
data1['CREDIT_BUREAU_MIN_DAYS_DELINQUENT']=data['CREDIT_BUREAU_MIN_DAYS_DELINQUENT']
data1['MODLASTUPDATE']=data['MODLASTUPDATE']
data1['FBLASTUPDATE']=data['FBLASTUPDATE']
data1['DILLASTUPDATE']=data['DILLASTUPDATE']
data1['SSLASTUPDATE']=data['SSLASTUPDATE']
data = pd.concat([data,data1], axis=1)
# Save the DataFrame to an Excel file
output_file_path = 'D:/RPA/Prerna/Investor Rules/DBinput.xlsx'
data.to_excel(output_file_path, index=False)

# Close the cursor and connection
cursor.close()
cnxn.close()

print(f"Results saved to '{output_file_path}'")


Traceback (most recent call last):
  File "D:\RPA\Prerna\Investor Rules\InvestorRulesdevDB.py", line 45, in <module>
    df = pd.DataFrame(results, columns = column_names)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\frame.py", line 798, in __init__
    mgr = ndarray_to_mgr(
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 337, in ndarray_to_mgr
    _check_values_indices_shape_match(values, index, columns)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 408, in _check_values_indices_shape_match
    raise ValueError(f"Shape of passed values is {passed}, indices imply {implied}")
ValueError: Shape of passed values is (17, 1), indices imply (17, 51)
