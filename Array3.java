from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import NoSuchElementException, TimeoutException, NoSuchFrameException

import time

import json
import os
from datetime import datetime

            
def Login(obj):
    driver=obj.driver
    count=2
    MAX_COUNT=int(str(obj.config['MaxRetryNumber']))
    # companyCode=str(obj.config['companyCode']).strip() 
   
    BKFS_Creds=obj.get_password(obj.config['asset_bkfs'])
  


    loanSphereURL=str(obj.config['BKFS_SEARCHURL']).strip()    
    logSuccess=False
    invalidCreds=False
    credsExpired=False
    obj.printlog.info("Entering into BKFS Portal")
    while(count<= MAX_COUNT):

        driver=obj.driver
        try:
            driver.close()
        except:
            pass
        finally:
            obj.getDriver(obj)
            driver=obj.driver

        try:
            
            obj.printlog.info("Load URL "+ obj.config["BKFS_SEARCHURL"])
            driver.get(obj.config["BKFS_SEARCHURL"])
            time.sleep(5)
            if  check_exists_by_xpath(driver,"//*[@id='companyLogo']")==True:
                
                obj.printlog.info("Landed on login page")
             
                obj.printlog.info("Enter Username "+ BKFS_Creds[0])
              
                driver.find_element_by_xpath('//*[@id="userNameInput"]').send_keys(BKFS_Creds[0])
                obj.printlog.info("Enter BKFS Password")
                obj.driver.save_screenshot(obj.config['SS']+"Login page.png")
                
                driver.find_element_by_xpath('//*[@id="passwordInput"]').send_keys((BKFS_Creds[1])+Keys.RETURN)
                time.sleep(5)
                obj.driver.save_screenshot(obj.config['SS']+"BKFS Logged_in.png")

                if  check_exists_by_xpath(driver,"//*[@id='lblPageTitle']")==True:
                
                    obj.printlog.info("Entered  inside BKFS Portal")
              
                    time.sleep(6)
                   
                    obj.printlog.info("clicking on loss mitigation button")
                  
                    driver.find_element_by_xpath(r'//*[@id="lblPageTitle"]').click()
                    time.sleep(5)


                    driver.find_element_by_link_text("Loss Mitigation").click()
                    time.sleep(8)
                            
                  
                    
                    
                    obj.printlog.info("Successfully landed on loan search page")
                    #PLS investor
                    # for PLS Investor settings
                    driver.switch_to.frame('ifr_LMT')
                    time.sleep(5)
                    print("entered loss mitigation")
                    obj.printlog.info("entered loss mitigation")
                    dropdown_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/header/div/div/div[1]/div/div[1]/div/button')))
                    time.sleep(5)
                    dropdown_button.click()
                    print("dropdown button clicked")
                    obj.printlog.info("dropdown button clicked")
                    obj.driver.save_screenshot(obj.config['SS']+"tabdropdown.png")
                    time.sleep(5)

                    dropdown_options = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/header/div/div/div[1]/div/div[1]/div/div/a[2]')))
                    dropdown_options.click()
                    print("Admin tab entered")
                    obj.printlog.info("Admin tab entered")
                    obj.driver.save_screenshot(obj.config['SS']+"Admin Tab.png")

                    time.sleep(5)
                    obj.driver.save_screenshot(obj.config['SS']+"Admin page.png")

                    obj.driver.save_screenshot(obj.config['SS']+"PLS Investor visible.png")
                    time.sleep(5)
                    try:
                        pls_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[1]/div/div/div[2]/div/div/div/div[19]/div/a')))

                        # obj.driver.execute_script("window.scrollBy(0, 2000)")
                        driver.execute_script("arguments[0].click();",pls_button)
                        obj.driver.save_screenshot(obj.config['SS']+"PLS Investor.png")
                        time.sleep(5)

                        print("PLS Investor settings clicked")
                        # time.sleep(5)

                        obj.driver.save_screenshot(obj.config['SS']+"PLS Investor page.png")
                        time.sleep(2)
                        obj.driver.save_screenshot(obj.config['SS']+"PLS Investor page check.png")

                        # investor_id = str(obj.TransactionItem[1])
                        # print("investor ID", investor_id)
                        column_header = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div')
                        print("column header found")
                        # driver.execute_script("arguments[0].scrollIntoView(false);",column_header)
                        driver.execute_script("arguments[0].click();",column_header)
                        obj.driver.save_screenshot(obj.config['SS']+str(obj.INVESTOR_IDNumber)+"Investor ID column.png")
                        print("column header clicked")
                        time.sleep(1)
                    except (TimeoutException, StaleElementReferenceException) as e:
                        traceback.print_exc()          
                        print(f"error:{e}")
                    except Exception as ex:            
                        raise Exception(f"error", str(ex))


                elif check_exists_by_xpath(driver,'//*[@id="lblWarning"]')==True:
                    driver.find_element_by_xpath(r'//*[@id="btnClearSessn"]').click()
                    print("BKFS Portal session expired")
                    raise Exception("Session Expired Try login again")

                elif obj.config['BKFS_security_message'] in obj.driver.page_source:
                    obj.driver.save_screenshot(obj.config['SS']+"SecurityQue_1.png")

                    question=WebDriverWait(obj.driver,30).until(EC.presence_of_element_located((By.XPATH,'//*[@id="loginForm"]/label'))).text.strip()
                    securityQuesAns_dict=json.loads(obj.config['BKFS_security_QuesAns_dict'].replace(";", ","))
                    answer=next((securityQuesAns_dict[key] for key in securityQuesAns_dict if key in question),'')
                    obj.printlog.info('Question : {} | Answer : {}'.format(str(question),answer))
                    if answer=='':
                        raise Exception("BRE: BKFS Portal - Invalid security question being asked! (for '{}')".format(obj.bkfsUserName))
                    else:
                        answer_field=obj.driver.find_element(By.XPATH,'/html/body/div[2]/div[2]/div/main/div/div/div[3]/div/form/input[4]')
                        answer_field.send_keys(answer+Keys.RETURN)
                        obj.driver.save_screenshot(obj.config['SS']+"SecurityQue_2.png")

                        time.sleep(2)

                time.sleep(6)

                    

                if check_exists_by_xpath(driver,'//*[@id="lblWarning"]')==True:
                    driver.find_element_by_xpath(r'//*[@id="btnClearSessn"]').click()
                    print("BKFS Portal session expired")
                
                obj.printlog.info("clicking on loss mitigation button")
                
                driver.find_element_by_xpath(r'//*[@id="lblPageTitle"]').click()
                time.sleep(5)


                driver.find_element_by_link_text("Loss Mitigation").click()
                time.sleep(8)   
                obj.driver.save_screenshot(obj.config['SS']+"LossMitScreen.png")

                #PLS investor
                # for PLS Investor settings
                driver.switch_to.frame('ifr_LMT')
                time.sleep(5)
                print("entered loss mitigation")
                obj.printlog.info("entered loss mitigation")
                dropdown_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/header/div/div/div[1]/div/div[1]/div/button')))
                time.sleep(2)
                dropdown_button.click()
                print("dropdown button clicked")
                obj.printlog.info("dropdown button clicked")
                obj.driver.save_screenshot(obj.config['SS']+"tabdropdown.png")
                dropdown_options = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/header/div/div/div[1]/div/div[1]/div/div/a[2]')))
                dropdown_options.click()
                print("Admin tab entered")
                obj.printlog.info("Admin tab entered")
                obj.driver.save_screenshot(obj.config['SS']+"Admin Tab.png")

                time.sleep(5)
                obj.driver.save_screenshot(obj.config['SS']+"Admin page.png")

                obj.driver.save_screenshot(obj.config['SS']+"PLS Investor visible.png")
                try:
                    pls_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[1]/div/div/div[2]/div/div/div/div[19]/div/a')))

                    # obj.driver.execute_script("window.scrollBy(0, 2000)")
                    driver.execute_script("arguments[0].click();",pls_button)
                    obj.driver.save_screenshot(obj.config['SS']+"PLS Investor.png")
                    time.sleep(5)
                    print("PLS Investor settings clicked")
                    # time.sleep(5)
                    obj.driver.save_screenshot(obj.config['SS']+"PLS Investor page.png")
                    time.sleep(2)
                    obj.driver.save_screenshot(obj.config['SS']+"PLS Investor page confirm.png")
                    # investor_id = str(obj.TransactionItem[1])
                    # print("investor ID", investor_id)
                    column_header = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]/div')
                    print("column header found")
                    # driver.execute_script("arguments[0].scrollIntoView(false);",column_header)
                    driver.execute_script("arguments[0].click();",column_header)
                    obj.driver.save_screenshot(obj.config['SS']+str(obj.INVESTOR_IDNumber)+"Investor ID column.png")
                    print("column header clicked")
                    time.sleep(1)
                except (TimeoutException, StaleElementReferenceException) as e:
                    traceback.print_exc()          
                    print(f"error:{e}")
                except Exception as ex:            
                    raise Exception(f"error", str(ex))

                if check_exists_by_xpath(driver,'//*[@id="errorText"]')==True:
                    obj.printlog.info("Error while loging to LPS  as credentials are invalid for the user "+BKFS_Creds[0])
                    # global invalidCreds
                    invalidCreds=True
                    raise Exception("Error while loging to LPS  as credentials are invalid for the user "+BKFS_Creds[0])
                elif True:
                    try:
                        driver.switch_to.frame("iframeDialog")
                        credsExpired=True
                        raise Exception("Error while loging in to LPS as credentials have expired for the user "+BKFS_Creds[0])
                    except NoSuchFrameException:
                        obj.printlog.info("Password hasn't expired")

                    

                else:
                    obj.printlog.info("Logged in")
                    pass
                    
                    

                time.sleep(5)
                return driver
              

                
            else:
                #print("did not login")
                obj.printlog.info("Didn't land on login page")
                raise Exception("Didn't land on login page")   


        except Exception as ex:
            obj.printlog.info("Error while landing to Login page "+ str(ex))
            count+=1
            
            if ( invalidCreds==True or credsExpired==True):
                raise
            elif count>MAX_COUNT :
                raise Exception(f"Login to LPS failed for the user {BKFS_Creds[0]} after trying for {MAX_COUNT} times")


            else:
                pass
        finally:
            obj.printlog.info("In finally for bkfs login")
    return None

def check_exists_by_id(driver,Id):
    try:
        driver.find_element(By.ID,Id)
        return True
    except NoSuchElementException:
        return False

def check_exists_by_xpath(driver,Xpath):
    try:
        driver.find_element_by_xpath(Xpath)
        return True
    except NoSuchElementException:
        return False                      
                
            


               
            
        
        

            











