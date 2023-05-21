    try:

      
        # brp_switch = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/fieldset/form/div[3]/table/div/div[2]/div[1]/div/div[2]/label[2]/input')))
        # brp_switch=driver.find_element(by=By.XPATH,value='/html/body/div/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/fieldset/form/div[3]/table/div/div[2]/div[1]/div/div[2]/label[2]/input')
        # brp_switch = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '//*[@id="divToPrint"]/div[3]/div[2]/div/div/fieldset/form/div[3]/table/div/div[2]/div[1]/div/div[2]/label[2]')))
        brp_switch=driver.find_element(by=By.XPATH,value='/html/body/div/div/main/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[3]/div[2]/div/div/fieldset/form/div[3]/table/div/div[2]/div[1]/div/div[2]/label[2]/span')

        
        bgcolor=brp_switch.value_of_css_property('background-color')
        bgcolor=bgcolor.replace('rgba','')
        bgcolor=eval(bgcolor)
        rgbcolor='#{:02x}{:02x}{:02x}'.format(*bgcolor)
        print(rgbcolor)
        print("rgbtohex is ",rgbcolor)
        if '#2196f3' == rgbcolor:
            print("BRP toggle already selected")
            pass
  
        else:
            print("BRP is greyed out")
            brp_switch.click()
            time.sleep(2)
        obj.driver.save_screenshot(obj.config['SS']+loanNumber+"FHA"+"BRPtoggle_3_1.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        print("BRP toggle not selected")
        obj.printlog.info("BRP toggle not sleected")
    except Exception as ex:
        raise Exception("BRP toggle not selected", str(ex))    

