    try:
        
        mod_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/div/label[2]/span')))

        if obj.mod_allowed == "YES" :
            mod_toggle.click()
            obj.mod_allowed_updated = "YES"
            print("Mod toggle selected")
            obj.printlog.info(f"Mod toggle selected. input:{obj.mod_allowed} 1")   
        else:
            
            print("mod_toggle already toggle no")
            obj.mod_allowed_updated = "NO"
            obj.printlog.info(f"Mod toggle  already unselected. input:{obj.mod_allowed} 1")
        obj.printlog.info("Mod toggle answered. 4.3")
        obj.driver.save_screenshot(obj.config['SS']+investorid+"Modtoggle_1.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))
