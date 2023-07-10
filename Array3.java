    try:
        time.sleep(2)
        # obj.message = 'yes ONLY STANDARD FREDDIE MODS ALLOWED'
        message_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
        message_text = message_element.text
        print("Text from the message field",message_text)
        obj.printlog.info(f"Text from the message field",message_text)
        if message_text == obj.message:
            print("message in the bkfs field matched with the output")
            obj.printlog.info(f"message in the bkfs field matched with the output")
        else:
            message_element.send_keys(Keys.CONTROL + "a")
            message_element.send_keys(Keys.BACKSPACE)
            message_element.send_keys(obj.message)
            print("message replaced.")
            obj.printlog.info(f"message replaced ",obj.message)
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex)) 
