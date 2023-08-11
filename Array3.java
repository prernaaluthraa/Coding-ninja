Process error ('error', '1')
Traceback (most recent call last):
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/indexes/base.py", line 3803, in get_loc
    return self._engine.get_loc(casted_key)
  File "pandas/_libs/index.pyx", line 138, in pandas._libs.index.IndexEngine.get_loc
  File "pandas/_libs/index.pyx", line 162, in pandas._libs.index.IndexEngine.get_loc
  File "pandas/_libs/index.pyx", line 197, in pandas._libs.index.IndexEngine._get_loc_duplicates
KeyError: 1

The above exception was the direct cause of the following exception:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestorNewRecord.py", line 153, in searchInvestor
    dropdown_field.send_keys(obj.INVESTOR_IDNumber)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 478, in send_keys
    {'text': "".join(keys_to_typing(value)),
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/common/utils.py", line 151, in keys_to_typing
    typing.append(val[i])
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/series.py", line 981, in __getitem__
    return self._get_value(key)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/series.py", line 1089, in _get_value
    loc = self.index.get_loc(label)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/indexes/base.py", line 3805, in get_loc
    raise KeyError(key) from err
KeyError: 1

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 340, in main
    pr.inflightPrcs(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 32, in inflightPrcs
    new.searchInvestor(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestorNewRecord.py", line 168, in searchInvestor
    raise Exception(f"error", str(ex))
Exception: ('error', '1')
Restarting session
'NoneType' object has no attribute 'terminate'
Traceback (most recent call last):
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/indexes/base.py", line 3803, in get_loc
    return self._engine.get_loc(casted_key)
  File "pandas/_libs/index.pyx", line 138, in pandas._libs.index.IndexEngine.get_loc
  File "pandas/_libs/index.pyx", line 162, in pandas._libs.index.IndexEngine.get_loc
  File "pandas/_libs/index.pyx", line 197, in pandas._libs.index.IndexEngine._get_loc_duplicates
KeyError: 1

The above exception was the direct cause of the following exception:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestorNewRecord.py", line 153, in searchInvestor
    dropdown_field.send_keys(obj.INVESTOR_IDNumber)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 478, in send_keys
    {'text': "".join(keys_to_typing(value)),
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/common/utils.py", line 151, in keys_to_typing
    typing.append(val[i])
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/series.py", line 981, in __getitem__
    return self._get_value(key)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/series.py", line 1089, in _get_value
    loc = self.index.get_loc(label)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/indexes/base.py", line 3805, in get_loc
    raise KeyError(key) from err
KeyError: 1

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 340, in main
    pr.inflightPrcs(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 32, in inflightPrcs
    new.searchInvestor(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestorNewRecord.py", line 168, in searchInvestor
    raise Exception(f"error", str(ex))
Exception: ('error', '1')

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 363, in main
    obj.terminalConnection.terminate()
AttributeError: 'NoneType' object has no attribute 'terminate'
