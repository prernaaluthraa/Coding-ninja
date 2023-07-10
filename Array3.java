    try:
        time.sleep(2)
        # obj.message = 'yes ONLY STANDARD FREDDIE MODS ALLOWED'
        message_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
        print("New record message",obj.message)
        obj.printlog.info(f"New record message",obj.message)
        message_element.send_keys(obj.message)
        print("message updated.")
        obj.printlog.info(f"message updated ",obj.message)
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))
