  # Create a DataFrame from the results and column names
    converters = {col_name: lambda x: 'NULL' if x == 'NULL' else x for col_name in column_names}
    df = pd.DataFrame.from_records(results, columns=column_names, converters=converters)
