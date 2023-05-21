    try:
        hardship_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/fieldset/form/div[4]/table/div/div[2]/div[3]/div/div[2]/label[2]/span')))
        hardship_toggle_color=hardship_toggle.value_of_css_property('background-color')
        hardship_toggle_color=hardship_toggle_color.replace('rgba','')
        hardship_toggle_color=eval(hardship_toggle_color)
        hardship_toggle_hex='#{:02x}{:02x}{:02x}'.format(*hardship_toggle_color)

        if (str(obj.hardship_resolved)).lower() == "yes":
            
            if  obj.bluergbcolor in hardship_toggle_hex:
                print("hardship is already yes")
                obj.printlog.info(f"Hardship toggle already selected. input:{obj.hardship_resolved} 4.3")        
               
            else:
                hardship_toggle.click()
                obj.printlog.info(f"Hardship toggle selected. input:{obj.hardship_resolved} 4.3")
           
        elif (str(obj.hardship_resolved)).lower() == "no":

            if  obj.bluergbcolor in hardship_toggle_hex:
                
                hardship_toggle.click()
                obj.printlog.info(f"Hardship toggle unselected. input:{obj.hardship_resolved} 4.3")
            else:
                print("hardship already toggle no")
                obj.printlog.info(f"Hardship toggle  already unselected. input:{obj.hardship_resolved} 4.3")
        obj.printlog.info("hardship toggle answered. 4.3")
        obj.driver.save_screenshot(obj.config['SS']+loanNumber+"FHA"+"Hardshiptoggle_4_3.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        print(f"Error selecting '{obj.hardship_resolved}' toggle hardship: {e}")
        
    except Exception as ex:
        raise Exception(f"Hardship toggle {obj.hardship_resolved} not unanswered.4.3", str(ex))    

