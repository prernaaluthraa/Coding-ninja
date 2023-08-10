/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
file found
/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py:31: FutureWarning: The frame.append method is deprecated and will be removed from pandas in a future version. Use pandas.concat instead.
  all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
file found
in catch of gtExcel file format cannot be determined, you must specify an engine manually.
Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 267, in main
    GT.loadData(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/getTransaction.py", line 31, in loadData
    all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/util/_decorators.py", line 211, in wrapper
    return func(*args, **kwargs)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/util/_decorators.py", line 331, in wrapper
    return func(*args, **kwargs)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_base.py", line 482, in read_excel
    io = ExcelFile(io, storage_options=storage_options, engine=engine)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/io/excel/_base.py", line 1656, in __init__
    raise ValueError(
ValueError: Excel file format cannot be determined, you must specify an engine manually.


import os
import time
import datetime
import traceback
import pandas as pd
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import numpy as np
import fnmatch
import shutil
import openpyxl
import cx_Oracle
import Framework.sendEmail as mail


def loadData(obj):

    if obj.TransactionData is None:
        try:
            all_data=None
            for file in os.listdir(obj.config['M_IN']):
                if file.lower().endswith('.xlsx'):
                    print("file found")
                    if all_data is None:
                        print("Data reading")
                        all_data=pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1')
                        obj.filename_in_email=file
                    else:
                        all_data=all_data.append(pd.read_excel(obj.config['M_IN']+file,sheet_name='Sheet1'))

            if all_data is None:
                raise Exception("BRE : File is not Present")
           
           
            # try:
            #     mail.sendInputloansEmail(obj,obj.config['M_IN']+obj.filename_in_email)
            #     print('Input File mail sent successfully!')
            #     obj.printlog.info('Input File mail sent successfully!')
            # except Exception as ex:
            #     traceback.print_exc()
            #     print('Error while sending Input File mail: {}'.format(str(ex)))
            #     obj.printlog.error('Error while sending Input File mail: {}'.format(str(ex)))

            # print("After sending a mail")
          
            # #filtering loans  only with tasks LMINFL and LMLDCL
            # taskList = ['LMINFL', 'LMLDCL']
            # taskcodeList = [x.upper() for x in taskList]
            # obj.TransactionData=all_data[all_data['OPEN_TASK_CODE'].isin(taskcodeList)]

            # # protfoliolist=['FNMA']
            # obj.TransactionData=all_data[all_data['PORTFOLIO'].isin(protfoliolist)]

            obj.InputData=obj.TransactionData
            # obj.TransactionData.columns=['LOAN_NUMBER']
        

            # obj.TransactionData=obj.TransactionData.dropna()
            print("TransactionData is ",obj.TransactionData)
            # obj.TransactionData['LOAN_NUMBER']=obj.TransactionData['LOAN_NUMBER'].apply(lambda x: str(x).zfill(10))
            # obj.TransactionData['LOAN_NUMBER']=obj.TransactionData['LOAN_NUMBER'].apply(lambda x: x.replace('.0',''))
        


            obj.printlog.info('All Investor ID unique ? : {}'.format(str(obj.TransactionData['INVESTOR_IDNumber'].is_unique)))
            # obj.TransactionData=obj.TransactionData.drop_duplicates(subset=['Loan_Number'] , keep='first', inplace=False, ignore_index=False)

            obj.TransactionData=obj.TransactionData.values.tolist()
            # print("Set of loans in input is ",obj.TransactionData)
        
            print('Total Investor ID count : {}'.format(str(len(obj.TransactionData))))
            obj.printlog.info('Total Investor ID count : {}'.format(str(len(obj.TransactionData))))
        except Exception as ex:
            if 'No such' in str(ex):
                raise Exception("BRE : No Data")
            else:
                raise
        
    if obj.TransactionNumber<=len(obj.TransactionData):
    
        obj.TransactionItem=obj.TransactionData[obj.TransactionNumber-1]
        obj.TransactionData1=obj.TransactionItem[0]   
        print("obj.TransactionItem is ",obj.TransactionItem)
        obj.outputfile=obj.metrics.createOutputFile(obj)
    else:
        print("Else case is obj.TransactionItem is ",obj.TransactionItem)
        obj.TransactionItem=None
