        #Message############################
    try:
        time.sleep(2)
        if obj.message =='NULL' and obj.message =='':
            obj.Message_updated = 'NO'
            obj.printlog.info("obj.Message_Updated is Null or emtly so, its is NO")
        else:    
            message_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
            print("New record message",obj.message)
            obj.printlog.info(f"New record message",obj.message)
            message_element.send_keys(obj.message)
            print("message updated.")
            obj.printlog.info(f"message updated ",obj.message)
            obj.Message_updated = 'NO'
            obj.printlog.info("obj.Message_Updated is updated to NO")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))



New record message nan
--- Logging error ---
Traceback (most recent call last):
  File "/usr/local/lib/python3.9/logging/__init__.py", line 1083, in emit
    msg = self.format(record)
  File "/usr/local/lib/python3.9/logging/__init__.py", line 927, in format
    return fmt.format(record)
  File "/usr/local/lib/python3.9/logging/__init__.py", line 663, in format
    record.message = record.getMessage()
  File "/usr/local/lib/python3.9/logging/__init__.py", line 367, in getMessage
    msg = msg % self.args
TypeError: not all arguments converted during string formatting
Call stack:
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 397, in <module>
    main()
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 340, in main
    pr.inflightPrcs(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 33, in inflightPrcs
    element_exists(obj.driver, "/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button", obj, exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 328, in element_exists
    Non_exists_action(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 411, in on_edit_not_exists
    create.createNew(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 382, in createNew
    obj.printlog.info(f"New record message",obj.message)
Message: 'New record message'
Arguments: (nan,)
Process error ('error:', "object of type 'numpy.float64' has no len()")
Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 383, in createNew
    message_element.send_keys(obj.message)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 478, in send_keys
    {'text': "".join(keys_to_typing(value)),
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/common/utils.py", line 150, in keys_to_typing
    for i in range(len(val)):
TypeError: object of type 'numpy.float64' has no len()

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 340, in main
    pr.inflightPrcs(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 33, in inflightPrcs
    element_exists(obj.driver, "/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button", obj, exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 328, in element_exists
    Non_exists_action(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 411, in on_edit_not_exists
    create.createNew(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 392, in createNew
    raise Exception(f"error:", str(ex))
Exception: ('error:', "object of type 'numpy.float64' has no len()")
Restarting session
'NoneType' object has no attribute 'terminate'
Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 383, in createNew
    message_element.send_keys(obj.message)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 478, in send_keys
    {'text': "".join(keys_to_typing(value)),
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/common/utils.py", line 150, in keys_to_typing
    for i in range(len(val)):
TypeError: object of type 'numpy.float64' has no len()

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 340, in main
    pr.inflightPrcs(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 33, in inflightPrcs
    element_exists(obj.driver, "/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button", obj, exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 328, in element_exists
    Non_exists_action(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 411, in on_edit_not_exists
    create.createNew(obj)
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 392, in createNew
    raise Exception(f"error:", str(ex))
Exception: ('error:', "object of type 'numpy.float64' has no len()")

During handling of the above exception, another exception occurred:

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Finalmain.py", line 363, in main
    obj.terminalConnection.terminate()
AttributeError: 'NoneType' object has no attribute 'terminate'
