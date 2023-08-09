element_exists(driver,"/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button",exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists, obj)



def element_exists(driver, selector, exists_action=None, Non_exists_action=None,obj):
    
    elements = driver.find_elements(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button')
    if elements:
        element = elements[0]   
        if exists_action:
            exists_action(element)
        return True
    else:
        if Non_exists_action:
            Non_exists_action()
        return False    

def on_edit_exists(obj,element):
    element.click()
    print("edit clicked")
    # toggle.validatequest(obj)
    # vdfield.validateQuestField(obj)
    # vdfieldlast.validateQuestFieldLast(obj)

    obj.printlog.info("Edit exists and clicked")

def on_edit_not_exists(obj):
    print("edit doesn't exist")
    obj.printlog.info("New Record as edit doesn't exist")
    driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[1]/button').click()
    print("new record clicked")
    obj.printlog.info("Clicked on new record")
