Traceback (most recent call last):
  File "D:\RPA\Prerna\Investor Rules\InvestorRulesdevDB.py", line 39, in <module>
    df = pd.DataFrame(results_transposed, columns=column_names)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\frame.py", line 782, in __init__
    arrays, columns, index = nested_data_to_arrays(
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 498, in nested_data_to_arrays
    arrays, columns = to_arrays(data, columns, dtype=dtype)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 840, in to_arrays
    content, columns = _finalize_columns_and_data(arr, columns, dtype)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 937, in _finalize_columns_and_data
    raise ValueError(err) from err
ValueError: 51 columns passed, passed data had 17 columns
