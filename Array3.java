try:
    time.sleep(2)
    # obj.message = 'yes ONLY STANDARD FREDDIE MODS ALLOWED'
    message_element = driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[3]/form/div[1]/div/div[3]/div/div/div[2]/div/div[1]/div/textarea')
    message_text = message_element.text
    print("Text from the message field:", message_text)
    obj.printlog.info("Text from the message field: " + message_text)

    if message_text == obj.message:
        print("Message in the bkfs field matched with the output")
        obj.printlog.info("Message in the bkfs field matched with the output")
        obj.message_updated = 'YES'
    else:
        if obj.message != 'NULL' and obj.message != '':
            message_element.send_keys(Keys.CONTROL + "a")
            message_element.send_keys(Keys.BACKSPACE)
            message_element.send_keys(obj.message)
            print("Message replaced.")
            obj.printlog.info("Message replaced: " + obj.message)
            obj.message_updated = 'YES'
        else:
            print("No action taken.")
            obj.printlog.info("No action taken.")
            obj.message_updated = 'NO'

except (TimeoutException, StaleElementReferenceException) as e:
    traceback.print_exc()
    print(f"Error: {e}")
except Exception as ex:
    raise Exception("Error: " + str(ex))
