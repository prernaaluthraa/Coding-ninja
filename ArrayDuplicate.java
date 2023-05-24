try:
    time.sleep(2)
    in_floorrate = '2'
    # driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    floorrate_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div/span/input')
    floorrate_text = floorrate_element.text
    print("Text from the floorrate field",floorrate_text)
    if floorrate_text == in_floorrate:
        print("floorrate in the bkfs field matched with the output")
    else:
        floorrate_element.send_keys(Keys.CONTROL + "a")
        floorrate_element.send_keys(Keys.BACKSPACE)
        floorrate_element.send_keys(in_floorrate)
        print("floorrate_element replaced.")    

except (TimeoutException, StaleElementReferenceException) as e:
    traceback.print_exc()           
    print(f"error:{e}")       
except Exception as ex:
    raise Exception(f"error:", str(ex))
