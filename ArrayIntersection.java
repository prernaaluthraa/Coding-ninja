import pyodbc

# def IncomeCalculatordb(loanNum):
def read_query(file_path):
    with open(file_path, 'r') as file:
        query = file.read()
    return query

query_file_path = '/application/Query.txt'
# filename = 'data.xlsx'   
query = read_query(query_file_path)
print(query)

drivers = [item for item in pyodbc.drivers()]
print("Establishing connection")
print("############### DRIVERS",drivers)
driver = drivers[0]
server = '10.222.22.22'
database = 'InvestorRulesMSP'
uid = 'xxxx'
pwd = 'xxxx'
SSO = 'Trusted_Connection=yes'
timeout = '30'
con_string = f'driver={driver};server={server};database={database};uid={uid};pwd={pwd};'
cnxn = pyodbc.connect(con_string)
cursor = cnxn.cursor()
print("connection established")
