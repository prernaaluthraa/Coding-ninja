
forbearance toggle already toggle no
New record message 0   NaN
0   NaN
Name: Message, dtype: float64
message updated.
interestrate field to be updated.   %s 0    0.0125
0    0.0125
Name: INTEREST_RATE_REDUCTION_INCREMENTS, dtype: float64
interestrate_element updated.  %s 0    0.0125
0    0.0125
Name: INTEREST_RATE_REDUCTION_INCREMENTS, dtype: float64
floorrate_element updated.  %s 0   NaN
0   NaN
Name: FLOOR_RATE, dtype: float64
marketrate_element replaced.  %s 0    PMMS


    try:
        forbearance_plan_allowed = str(obj.forbearance_plan_allowed)
        forbearance_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/table/tbody/tr[16]/td[2]/div/div/div/div/label[2]/span')))
        if forbearance_plan_allowed == "YES" :  
            driver.execute_script("arguments[0].click();",forbearance_toggle)
            obj.forbearance_plan_allowed_updated = "YES"
            print("forbearance toggle selected")
            obj.printlog.info("forbearance toggle selected. input:{forbearance_plan_allowed} 16")   
        else:
            print("forbearance toggle already toggle no")
            obj.printlog.info("forbearance toggle  already unselected. input:{forbearance_plan_allowed} 16")
            obj.forbearance_plan_allowed_updated = "NO"
        obj.printlog.info("forbearance toggle answered. 16")
        obj.driver.save_screenshot(obj.config['SS']+str(obj.INVESTOR_IDNumber)+"forbearancetoggle_16.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()
        print(f"error:{e}")
    except Exception as ex:
        raise Exception(f"error:", str(ex))

        #Message############################
    try:
        time.sleep(2)
        message_text = str(obj.message)
        if not message_text  or message_text  == 'NULL':
            obj.message_updated = 'NO'
            obj.printlog.info("obj.Message_Updated is Null or emtly so, its is NO")
        else:   
            message_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
            print("New record message",message_text )
            obj.printlog.info("New record message  %s", message_text)
            message_element.send_keys(message_text)
            print("message updated.")
            obj.printlog.info("message updated   %s", message_text)
            obj.message_updated = 'NO'
            obj.printlog.info("Message_Updated is updated to NO")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))

   #Interest Rate Reduction Increments 1
    try:
        time.sleep(2)
        interest_rate_red = str(obj.interest_rate_reduction_increments)
        if interest_rate_red == 'NULL' or interest_rate_red == '':
            obj.printlog.info("interest rate reduction increment is null")
            obj.interest_rate_reduction_increments_updated = 'NO' 
        else:
            interestrate_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/span/input')
            print("interestrate field to be updated.   %s",interest_rate_red)
            obj.printlog.info("interestrate field to be updated.   %s",interest_rate_red)

            interestrate_element.send_keys(interest_rate_red)
            print("interestrate_element updated.  %s", interest_rate_red)    
            obj.printlog.info("interestrate_element updated. %s", interest_rate_red)
            obj.interest_rate_reduction_increments_Updated = 'YES'    
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()
        print(f"error:{e}")     
    except Exception as ex:
        raise Exception(f"error:", str(ex))

    #Floor Rate 2
    try:
        time.sleep(2)
        floor_rate = str(obj.floor_rate)
        if floor_rate == 'NULL' or floor_rate == '':
            obj.printlog.info("floor rate is null")
            obj.floor_rate_updated = 'NO'
        else:    
            floorrate_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div/span/input')
            floorrate_element.send_keys(floor_rate)
            print("floorrate_element updated.  %s", floor_rate)
            obj.printlog.info("floorrate in the bkfs field  updated  %s", floor_rate)
            obj.floor_rate_Updated = 'YES'
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))
