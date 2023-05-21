try:
    in_mod_toggle = "YES"
    bluergbcolor = (33,150,243)
    mod_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/div/label[2]/span')))
    mod_toggle_color=mod_toggle.value_of_css_property('background-color')
    mod_toggle_color=mod_toggle_color.replace('rgba','')
    mod_toggle_color=eval(mod_toggle_color)
    mod_toggle_hex='#{:02x}{:02x}{:02x}'.format(*mod_toggle_color)
    print(mod_toggle_hex)
    print("mod_toggle_hex is ",mod_toggle_hex)

    #if (str(obj.hardship_resolved)).lower() == "yes":
    if in_mod_toggle == "YES" :  
        if  ''.join(map(str, bluergbcolor)) in mod_toggle_hex:
            print("mod_toggle is already yes")
            # obj.printlog.info(f"Hardship toggle already selected. input:{obj.hardship_resolved} 4.3")           
        else:
            mod_toggle.click()
            print("Mod toggle selected")
            # obj.printlog.info(f"Hardship toggle selected. input:{obj.hardship_resolved} 4.3")
       
    elif in_mod_toggle == "NO" :
        if  ''.join(map(str, bluergbcolor)) in mod_toggle_hex:
            mod_toggle.click()
            print("Mod toggle unselected")
            # obj.printlog.info(f"Hardship toggle unselected. input:{obj.hardship_resolved} 4.3")
        else:
            print("mod_toggle already toggle no")
            # obj.printlog.info(f"Hardship toggle  already unselected. input:{obj.hardship_resolved} 4.3")
    # obj.printlog.info("hardship toggle answered. 4.3")
    # obj.driver.save_screenshot(obj.config['SS']+loanNumber+"FHA"+"Hardshiptoggle_4_3.png")
except (TimeoutException, StaleElementReferenceException) as e:
    traceback.print_exc()           
    print(f"error:{e}")       
except Exception as ex:
    raise Exception(f"error:", str(ex)) 
