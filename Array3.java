    try:
        # obj.mod_allowed = "YES"
        mod_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/div/label[2]/span')))
        mod_toggle_color=mod_toggle.value_of_css_property('background-color')
        mod_toggle_color=mod_toggle_color.replace('rgba','')
        mod_toggle_color=eval(mod_toggle_color)
        mod_toggle_hex='#{:02x}{:02x}{:02x}'.format(*mod_toggle_color)
        print(mod_toggle_hex)
        print("mod_toggle_hex is ",mod_toggle_hex)
        obj.printlog.info(f"mod_toggle_hex is ",mod_toggle_hex)

        if obj.mod_allowed == "YES" :  
            if '#2196f3' in mod_toggle_hex:    
                print("Mod toggle already selected")
                obj.printlog.info(f"Mod toggle already selected. input:{obj.mod_allowed} 1")           
            else:
                mod_toggle.click()
                obj.mod_allowed_updated = "Yes"
                print("Mod toggle selected")
                obj.printlog.info(f"Mod toggle selected. input:{obj.mod_allowed} 1")   
        else:
            if '#2196f3' in mod_toggle_hex:
                mod_toggle.click()
                obj.mod_allowed_updated = "Yes"
                print("Mod toggle unselected")
                obj.printlog.info(f"mod toggle unselected. input:{obj.mod_allowed} 1")
            else:
                print("mod_toggle already toggle no")
                obj.printlog.info(f"Mod toggle  already unselected. input:{obj.mod_allowed} 1")
        obj.printlog.info("Mod toggle answered. 4.3")
        obj.driver.save_screenshot(obj.config['SS']+investorid+"Modtoggle_1.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))    
