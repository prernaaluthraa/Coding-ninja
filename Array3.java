def SaveRecord(obj):
    driver = obj.driver
    try:
        save_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[2]/div[5]/button')))
        
        # If the save button is active, proceed to click on it
        driver.execute_script("arguments[0].click();", save_button)
        print("Save clicked")

        # Saving changes window
        try:
            updatereason = "Investor Data Updated by BOT"
            reason = driver.find_element(By.XPATH, '/html/body/div[3]/div/div/form/div[2]/div/div/div/div[1]/div/textarea')
            reason.send_keys(updatereason)
            print("Reason updated")
            save_check = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div[3]/div/div/form/div[3]/div/div[2]/button')))
            save_check.click()
            print("Save changes clicked")
            driver.save_screenshot(obj.config['SS'] + "save_changes.png")

        except (TimeoutException, StaleElementReferenceException) as e:
            traceback.print_exc()
            print(f"Error during save changes: {e}")
            obj.printlog.info(f"Error during save changes: {e}")
        
    except TimeoutException:
        # If the save button is not active, click on the cancel button
        print("Save button not active. Clicking on cancel button.")
        try:
            cancel_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[2]/div[3]/button')))
            driver.execute_script("arguments[0].scrollIntoView(false);", cancel_button)
            driver.execute_script("arguments[0].click();", cancel_button)
            print("Cancel button clicked")
            time.sleep(2)
            driver.save_screenshot(obj.config['SS'] + "cancel_button.png")
            time.sleep(2)
        except (TimeoutException, StaleElementReferenceException) as e:
            traceback.print_exc()
            print(f"Error during cancel: {e}")
            obj.printlog.info(f"Error during cancel: {e}")
        except Exception as ex:
            raise Exception("Error during cancel:", str(ex))
