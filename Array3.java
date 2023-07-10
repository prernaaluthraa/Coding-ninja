    try:
        time.sleep(2)
        #in_interestrate = '0.0125'
        interestrate_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/span/input')
        interestrate_text = interestrate_element.get_attribute("value")
        print("Text from the interestrate field",interestrate_text)
        obj.printlog.info(f"Text from the interestrate field",interestrate_text)
        if obj.interest_rate_reduction_increments =='NULL' and '':
            interestrate_element.send_keys(Keys.CONTROL + "a")
            interestrate_element.send_keys(Keys.BACKSPACE)
            obj.interest_rate_reduction_increments_updated = 'NA' 
            print("interestrate is done to null")
        else:
            if interestrate_text == obj.interest_rate_reduction_increments:
                print("interestrate in the bkfs field matched with the output")
                obj.interest_rate_reduction_increments_updated = 'NO'
                obj.printlog.info(f"interestrate in the bkfs field matched with the output")
            else:
                interestrate_element.send_keys(Keys.CONTROL + "a")
                interestrate_element.send_keys(Keys.BACKSPACE)
                interestrate_element.send_keys(obj.interest_rate_reduction_increments)
                obj.interest_rate_reduction_increments_updated = 'YES'
                print("interestrate_element replaced.")    
                obj.printlog.info(f"interestrate_element replaced.")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()
        print(f"error:{e}")     
    except Exception as ex:
        raise Exception(f"error:", str(ex)) 
