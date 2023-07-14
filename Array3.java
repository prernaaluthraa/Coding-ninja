try:
    in_message = 'As there are multiple securities in investor code W85 please see below regarding the latest possible maturity date for each category--W85-001 Restriction Date 11/01/2032W85-006 Restriction Date 07/01/2036W85-018 Restriction Date 01/01/2034W85-031 Restriction Date 05/01/2037W85-032 Restriction Date 06/01/2034W85-033 Restriction Date 06/01/2034W85-035 Restriction Date 06/01/2034W85-042 Restriction Date 10/01/2034W85-048 Restriction Date 12/01/2034W85-051 Restriction Date 01/01/2036W85-052 Restriction Date 03/01/2038W85-056 Restriction Date 04/01/2038W85-060 Restriction Date 10/01/2038'
    # driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    message_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
    message_text = message_element.text
    print("Text from the message field",message_text)
    if message_text == in_message:
        print("message in the bkfs field matched with the output")
    else:
        message_element.send_keys(Keys.CONTROL + "a")
        message_element.send_keys(Keys.BACKSPACE)
        message_element.send_keys(in_message)
        print("message replaced.")    

except (TimeoutException, StaleElementReferenceException) as e:
    traceback.print_exc()           
    print(f"error:{e}")       
except Exception as ex:
    raise Exception(f"error:", str(ex)) 
