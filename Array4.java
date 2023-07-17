import pyodbc
import pandas as pd
import openpyxl
from datetime import date, datetime, timedelta
import openpyxl.styles as styles


def last_working_date():
    today = date.today()
    weekday = today.weekday()

    if weekday == 0:
        last_working_day = today - timedelta(days=3)
    else:
        last_working_day = today - timedelta(days=1)

    formatted_date = last_working_day.strftime("%m/%d/%Y")
    print("Last working day:", formatted_date)
    return formatted_date


formatted_date = last_working_date()

def read_query(file_path):
    with open(file_path, 'r') as file:
        query = file.read()
    return query

query_file_path = '/application/RPA/LRPU/PLSInvestorRulesAutomation/REQUIRED/Query.txt'
# filename = 'data.xlsx'   
query = read_query(query_file_path)
query = query.replace('date',formatted_date)
print(query)

drivers = [item for item in pyodbc.drivers()]
print("Establishing connection")
print("############### DRIVERS",drivers)
driver = drivers[0]
server = '10.72.8.53,50011'
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

column_names = [description[0] for description in cursor.description]

# Fetch all the results
results = cursor.fetchall()
print("Number od rows in results", len(results))
print("Number od columns in results",len(results[0]))
print("Number of column names",column_names)
# Create a DataFrame from the results and column names
df = pd.DataFrame.from_records(results, columns = column_names)
print("dataframeshape",df.shape)
# df = pd.DataFrame(results, columns = ['INVESTOR_ID','INVESTOR_DEAL_NAME','INVESTOR_CATEGORY','MOD_ALLOWED','STREAMLINE_ALLOWED','INVESTOR_APPROVAL_REQUIRED','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED','NON_INTERST_BEARING_BALLOON_ALLOWED','INTEREST_RATE_REDUCTION_ALLOWED','INTEREST_BEARING_BALLOON_ALLOWED','MATURITY_EXTEMSION_ALLOWED','DEFERMENT_ALLOWED','FORGIVENESS_ALLOWED','ADDINTERIMMONTH','SHORT_SALE_ALLOWED','SHORT_SALE_DELEGATED','DEED_IN_LIEU_ALLOWED','DIL_DELEGATED','FORBEARANCE_ALLOWED','MESSAGE','INTEREST_RATE_REDUCTION_INCREMENTS','FLOOR_RATE','MARKET_RATE_TYPE','NUMBER_OF_MODS_ALLOWED','NUMBER_CAPITALIZATIONS_ALLOWED','MAX_TERM','MINIMUM_CREDIT_SCORE','TRIAL_DURATION','FORGIVENESS_UPB_LIMIT_PERCENTAGE','FORGIVENESS_LOWER_LTV_LIMIT','SYSDATE','MATURITY_DATE_RESTRICTION','MIN_DAYS_DELINQUENT','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT','MIN_PRE_MOD_DTI','MIN_POST_MOD_DTI','MAXIMUM_POST_MOD_DTI','MINIMUM_PRE_MOD_LTV','FORBEARANCE_LTV_LOWER_LIMIT','FORBEARANCE_UPB_LIMIT_PERCENTAGE','PAYMENT_REDUCTION_PERCENTAGE','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS','MAX_EVAL_DAY_OF_THE_MONTH','STREAMLINE_MIN_DAYS_DELINQUENT','MATURITY_DATE_EXTENTIONS_BY_MONTH','CREDIT_BUREAU_EXPIRATION_DAYS','CREDIT_BUREAU_MIN_DAYS_DELINQUENT','MODLASTUPDATE','FBLASTUPDATE','DILLASTUPDATE','SSLASTUPDATE'])

# InputFile='InputFile_'+datetime.now().strftime('%m-%d-%Y')+'.csv'
# df.to_csv('D:/RPA/Prerna/Investor Rules/'+InputFile, index=False)
InputFile = 'BKFS PLS Investor Rules Input Data_' + datetime.now().strftime('%m.%d.%Y') + '.xlsx'
df.to_excel('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile, index=False)

# Load the Excel file using openpyxl
wb = openpyxl.load_workbook('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile)

# Select the active sheet
sheet = wb.active

# Apply formatting to column headers
header_font = styles.Font(color="000000", bold=True)
header_fill = styles.PatternFill(fill_type="solid", fgColor="FFCC99")

for col_idx, column_name in enumerate(column_names, start=1):
    cell = sheet.cell(row=1, column=col_idx)
    cell.font = header_font
    cell.fill = header_fill

# Save the modified Excel file
wb.save('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile)

# Close the cursor and connection
cursor.close()
cnxn.close()

print("Results saved to input file")
