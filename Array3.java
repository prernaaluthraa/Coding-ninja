/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
file found
in catch of gtFile is not a zip file
Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 267, in main
    GT.loadData(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py", line 31, in loadData
    all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1', engine ='openpyxl'))
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/util/_decorators.py", line 211, in wrapper
    return func(*args, **kwargs)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/util/_decorators.py", line 331, in wrapper
    return func(*args, **kwargs)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_base.py", line 482, in read_excel
    io = ExcelFile(io, storage_options=storage_options, engine=engine)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_base.py", line 1695, in __init__
    self._reader = self._engines[engine](self._io, storage_options=storage_options)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_openpyxl.py", line 557, in __init__
    super().__init__(filepath_or_buffer, storage_options=storage_options)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_base.py", line 545, in __init__
    self.book = self.load_workbook(self.handles.handle)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_openpyxl.py", line 568, in load_workbook
    return load_workbook(
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/openpyxl/reader/excel.py", line 315, in load_workbook
    reader = ExcelReader(filename, read_only, keep_vba,
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/openpyxl/reader/excel.py", line 124, in __init__
    self.archive = _validate_archive(fn)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/openpyxl/reader/excel.py", line 96, in _validate_archive
    archive = ZipFile(filename, 'r')
  File "/usr/local/lib/python3.9/zipfile.py", line 1266, in __init__
    self._RealGetContents()
  File "/usr/local/lib/python3.9/zipfile.py", line 1333, in _RealGetContents
    raise BadZipFile("File is not a zip file")
zipfile.BadZipFile: File is not a zip file
