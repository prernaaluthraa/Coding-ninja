def SaveRecord(obj):
    driver = obj.driver
    save_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[2]/div[5]/button')))
    driver.execute_script("arguments[0].click();",save_button)
    print("save clicked")
    #Saving changes window
    try:
        updatereason = "Investor Data Updated by BOT"
        reason = driver.find_element(By.XPATH, '/html/body/div[3]/div/div/form/div[2]/div/div/div/div[1]/div/textarea')
        reason.send_keys(updatereason)
        print("Reason updated")
        save_check = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div[3]/div/div/form/div[3]/div/div[2]/button')))
        save_check.click()
        print("Save changes clicked")
        driver.save_screenshot(obj.config['SS']+"save changes.png")

        cancel_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[2]/div[3]/button')))
        driver.execute_script("arguments[0].scrollIntoView(false);",cancel_button)
        driver.execute_script("arguments[0].click();",cancel_button)
        print("Cancel button clicked")
        time.sleep(2)
        driver.save_screenshot(obj.config['SS']+"cancel button.png")
        time.sleep(2)

    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}") 
        obj.printlog.info(f"error:{e}")      
    except Exception as ex:
        raise Exception(f"error:", str(ex))
