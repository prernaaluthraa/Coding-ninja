obj.driver.execute_script("window.scrollBy(-3000,0)")
    try:
        dropdown_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[1]/div/div/div[2]/div/div/div/div[18]/div/a')))
        dropdown_button.click()
        print("PLS Investor settings clicked")

Process error ('error', 'Message: unknown error: Element is not clickable at point (62, 957)\n  (Session info: headless chrome=110.0.5481.177)\n  (Driver info: chromedriver=2.40.565383 (76257d1ab79276b2d53ee976b2c3e3b9f335cde7),platform=Linux 3.10.0-1160.95.1.el7.x86_64 x86_64)\n')
Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestorNewRecord.py", line 122, in searchInvestor
    dropdown_button.click()
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 80, in click
    self._execute(Command.CLICK_ELEMENT)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webelement.py", line 633, in _execute
    return self._parent.execute(command, params)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/webdriver.py", line 321, in execute
    self.error_handler.check_response(response)
  File "/home/svc_dl_dev_exec/.local/lib/python3.9/site-packages/selenium/webdriver/remote/errorhandler.py", line 242, in check_response
    raise exception_class(message, screen, stacktrace)
selenium.common.exceptions.WebDriverException: Message: unknown error: Element is not clickable at point (62, 957)
  (Session info: headless chrome=110.0.5481.177)
  (Driver info: chromedriver=2.40.565383 (76257d1ab79276b2d53ee976b2c3e3b9f335cde7),platform=Linux 3.10.0-1160.95.1.el7.x86_64 x86_64)

