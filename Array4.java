def SaveRecord(obj):
    save_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[2]/div[5]/button')))
    save_button.click()
	#Saving changes window
    try:
        updatereason = "Investor Data Updated by BOT"
        reason = driver.find_element(By.XPATH, '/html/body/div[3]/div/div/form/div[2]/div/div/div/div[1]/div/textarea')
        reason.send_keys(updatereason)
        save_check = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div[3]/div/div/form/div[3]/div/div[2]/button')))
    	save_check.click()
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}") 
        obj.printlog.info(f"error:{e}")      
    except Exception as ex:
        raise Exception(f"error:", str(ex))
