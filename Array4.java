
def element_exists(driver, selector, exists_action=None, Non_exists_action=None):
    
    elements = driver.find_elements(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div[2]/div/div/div/div[6]/div/button')
    if elements:
        element = elements[0]   
        if exists_action:
            exists_action(element)
        return True
    else:
        if Non_exists_action:
            Non_exists_action()
        return False    

def on_edit_exists(element):
    element.click()
    print("edit clicked")

def on_edit_not_exists():
    print("edit doesn't exist")
    driver.find_element(By.XPATH, '/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[2]/div/div[1]/button').click()
    print("new record clicked")



element_exists(driver,"/html/body/div/div/main/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div[2]/div/div/div/div[6]/div/button",exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists)
   


