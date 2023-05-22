Traceback (most recent call last):
  File "D:\RPA\Prerna\Investor Rules\InvestorRulesdevDB.py", line 37, in <module>
    df = pd.DataFrame(results, columns=column_names)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\frame.py", line 798, in __init__
    mgr = ndarray_to_mgr(
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 337, in ndarray_to_mgr
    _check_values_indices_shape_match(values, index, columns)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\pandas\core\internals\construction.py", line 408, in _check_values_indices_shape_match
    raise ValueError(f"Shape of passed values is {passed}, indices imply {implied}")
ValueError: Shape of passed values is (17, 1), indices imply (17, 51)
