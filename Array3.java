    #Forgiveness Lower LTV Limit 10
    try:
        forgiveness_lower_ltv_limit = str(obj.forgiveness_lower_ltv_limit)
        forgivenesslower_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr[10]/td[2]/div/div/div/span/input')
        forgivenesslower_text = forgivenesslower_element.get_attribute("value")
        print("Text from the forgivenesslower field", forgivenesslower_text)
        obj.printlog.info(f"Text from the forgivenesslower field.  {forgivenesslower_text}")
        if forgiveness_lower_ltv_limit =='NULL' or forgiveness_lower_ltv_limit == 'nan':
            forgivenesslower_element.send_keys(Keys.CONTROL + "a")
            forgivenesslower_element.send_keys(Keys.BACKSPACE)
            obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT_Updated (Yes/No)')]= 'NA'
            print("forgivenesslower done to null")
            obj.printlog.info("forgivenesslower done to null")
        else:    
            if forgivenesslower_text == forgiveness_lower_ltv_limit:
                obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT_Updated (Yes/No)')]= 'NO'
                print("forgivenesslower in the bkfs field matched with the output")
                obj.printlog.info("forgivenesslower in the bkfs field matched with the output")
            else:
                forgivenesslower_element.send_keys(Keys.CONTROL + "a")
                forgivenesslower_element.send_keys(Keys.BACKSPACE)
                forgivenesslower_element.send_keys(forgiveness_lower_ltv_limit)
                obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT_Updated (Yes/No)')]= 'YES'
                print("forgivenesslower_element replaced.",forgiveness_lower_ltv_limit)
                obj.printlog.info(f"forgivenesslower_element replaced. : {forgiveness_lower_ltv_limit}")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))

    #Maturity Restriction Date  11
    try:
        time.sleep(2)
        maturity_date_restriction = str(obj.maturity_restriction_date)
        maturityrestrict_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/table/tbody/tr[11]/td[2]/div/div/div/div/div[1]/input')
        maturityrestrict_text = maturityrestrict_element.get_attribute("value")
        print("Text from the maturityrestrict field", maturityrestrict_text)
        obj.printlog.info(f"Text from the maturityrestrict field: {maturityrestrict_text}")
        if maturity_date_restriction =='NULL' or maturity_date_restriction == 'NaT':
            maturityrestrict_element.send_keys(Keys.CONTROL + "a")
            maturityrestrict_element.send_keys(Keys.BACKSPACE)
            obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated (Yes/No)')] = 'NA'
            print("maturityrestrict done to null")
            obj.printlog.info("maturityrestrict done to null")
        else:
            parsed_date = dateparser.parse(maturity_date_restriction)
            if parsed_date:
                final_date = parsed_date.strftime('%m/%d/%Y')
                if maturityrestrict_text == final_date:
                    print("maturityrestrict in the bkfs field matched with the output")
                    obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated (Yes/No)')] = 'NO'
                    obj.printlog.info("maturityrestrict in the bkfs field matched with the output")
                else:
                    maturityrestrict_element.send_keys(Keys.CONTROL + "a")
                    maturityrestrict_element.send_keys(Keys.BACKSPACE)
                    maturityrestrict_element.send_keys(final_date)
                    print("maturityrestrict_element replaced.", final_date)
                    obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated (Yes/No)')] = 'YES'
                    obj.printlog.info("maturityrestrict_element replaced.", final_date)
            else:
                print("Invalid date format. can't enter in the field", maturity_date_restriction )
                obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated (Yes/No)')] = 'NO'
                obj.printlog.info(f"Invalid date format. can't enter in the field : {maturity_date_restriction}")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()           
        print(f"error:{e}")       
    except Exception as ex:
        raise Exception(f"error:", str(ex))  
