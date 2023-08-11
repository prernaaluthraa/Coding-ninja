deal name: 0    PHH TCB Warehouse
0    PHH TCB Warehouse
Name: INVESTOR_DEAL_NAME, dtype: object

try:
        time.sleep(2)
        investor_deal_name = str(obj.INVESTOR_DEAL_NAME)
        print(f"deal name: {investor_deal_name}")
        if investor_deal_name == 'NULL' and investor_deal_name == '' :
            obj.investor_deal_name_updated = 'NO'
            obj.printlog.info("investor_deal_name null or empty so, not updated.")
            obj.driver.save_screenshot(obj.config['SS']+"Investor deal name.png")
        else:
            investorname_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[1]/div[1]/div/div/div/input')
            investorname_element.send_keys(investor_deal_name)
            print("investorname written.")
            obj.printlog.info("Investment name is %s",investor_deal_name) 
            obj.investor_deal_name_updated = 'YES'
            obj.printlog.info("investor_deal_name_updated is YES")
            obj.driver.save_screenshot(obj.config['SS']+"Investor deal name.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))
