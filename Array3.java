import pyodbc
import pandas as pd
import openpyxl
from datetime import datetime, timedelta

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

query_file_path = 'D:/RPA/Prerna/catalyst reporting/Query.txt'
# filename = 'data.xlsx'   
query = read_query(query_file_path)
query = query.replace('date',formatted_date)
print(query)
