    try:
        mod_allowed = str(obj.mod_allowed)
        mod_toggle = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH,'/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/div/div/div/div/label[2]/span')))

        if mod_allowed == "YES" :
            mod_toggle.click()
            obj.mod_allowed_updated = "YES"
            print("Mod toggle selected")
            obj.printlog.info("Mod toggle selected. input:{mod_allowed} 1")   
        else:
            
            print("mod_toggle already toggle no")
            obj.mod_allowed_updated = "NO"
            obj.printlog.info("Mod toggle  already unselected. input:{mod_allowed} 1")
        obj.printlog.info("Mod toggle answered. 4.3")
        obj.driver.save_screenshot(obj.config['SS']+obj.INVESTOR_IDNumber+"Modtoggle_1.png")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))

Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/CreatePLSInvestor.py", line 37, in createNew
    obj.driver.save_screenshot(obj.config['SS']+obj.INVESTOR_IDNumber+"Modtoggle_1.png")
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webdriver.py", line 1055, in save_screenshot
    return self.get_screenshot_as_file(filename)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webdriver.py", line 1029, in get_screenshot_as_file
    if not filename.lower().endswith('.png'):
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/pandas/core/generic.py", line 5902, in __getattr__
    return object.__getattribute__(self, name)
AttributeError: 'Series' object has no attribute 'lower'
