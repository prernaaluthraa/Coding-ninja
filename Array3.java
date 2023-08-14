PLSInvestortoggle.py
def validatequest(obj):


    driver = obj.driver
    try:
        time.sleep(2)
        INVESTOR_DEAL_NAME = str(obj.INVESTOR_DEAL_NAME)
        investor_deal_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[1]/div[1]/div/div/div/input')
        investor_deal_text = investor_deal_element.get_attribute("value")
        print("Text from the investor deal field",investor_deal_text)
        obj.printlog.info(f"Text from the investor deal field : {investor_deal_text}")
        if INVESTOR_DEAL_NAME =='NULL' or INVESTOR_DEAL_NAME == 'nan':
            investor_deal_element.send_keys(Keys.CONTROL + "a")
            investor_deal_element.send_keys(Keys.BACKSPACE)
            obj.investor_deal_name_updated = 'NA' 
            print("interestrate is done to null")
        else:
            if investor_deal_text == INVESTOR_DEAL_NAME:
                print("interestrate in the bkfs field matched with the output")
                obj.investor_deal_name_updated = 'NO'
                obj.printlog.info(f"interestrate in the bkfs field matched with the output")
            else:
                investor_deal_element.send_keys(Keys.CONTROL + "a")
                interestrate_element.send_keys(Keys.BACKSPACE)
                investor_deal_element.send_keys(INVESTOR_DEAL_NAME)
                obj.investor_deal_name_updated = 'YES'
                print("investor_deal_element replaced.")    
                obj.printlog.info(f"investor_deal_element replaced.: {INVESTOR_DEAL_NAME}")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()
        print(f"error:{e}")     
    except Exception as ex:
        raise Exception(f"error:", str(ex))


    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = obj.investor_deal_name_updated

  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/process.py", line 220, in OutputMapping
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = obj.investor_deal_name_updated
ValueError: 'INVESTOR_DEAL_NAME_Updated ( Yes/No )' is not in list
