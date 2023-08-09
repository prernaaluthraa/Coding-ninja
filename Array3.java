file inputsql
def readDataInputSQL(obj):
    query_file_path = obj.config['REQUIRED']+'Query.txt'
    # filename = 'data.xlsx'
    today = date.today()
    weekday = today.weekday()

    if weekday == 0:
        last_working_day = today - timedelta(days=3)
    else:
        last_working_day = today - timedelta(days=1)

    formatted_date = last_working_day.strftime("%m/%d/%Y")
    print("Last working day:", formatted_date)
    query = obj.read_query(query_file_path)
    query = query.replace('date', formatted_date)
    print(query)

inputsql.readDataInputSQL(obj)
