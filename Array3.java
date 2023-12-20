
def main():
    logging.info("Process Started Successfully!")
    obj=Obj("/application/RPA/LRPU/PLSInvestorRulesAutomation/CONFIG/Config.csv")
      
    now= datetime.datetime.now()
    date = now.strftime("%m/%d/%Y")
    obj.BotRunDate = date
    print("bot run date is ",obj.BotRunDate)

    try:
        print("Starting applications")
        # enable back
        # inputsql.readDataInputSQL(obj)
        ib.initApplications(obj)

    except Exception as ex:
        traceback.print_exc()
        if "BRE" in str(ex):
            obj.BusinessRuleException=str(ex)
            obj.printlog.exception(str(ex))
        else:
            print("init block has exception")
            obj.SystemException=str(ex)
            obj.printlog.error(str(ex))

    try:
        if obj.BusinessRuleException is None and obj.SystemException is None:
            
            while(obj.TransactionItem is not None):
                
                obj.SystemException=None
                obj.BusinessRuleException=None
                try:
                    logging.info("Loading of Data!")
                    GT.loadData(obj)
                except Exception as ex:
                    print("in catch of gt"+str(ex))
                    traceback.print_exc()
                    message=str(ex)
                    obj.TransactionItem=None
                    obj.totalLoans=0
                    if 'BRE' in message:
                        obj.BusinessRuleException=message
                        obj.printlog.exception(message)
                    else:
                        print("Load data has exception")
                        obj.SystemException=message
                        obj.printlog.error(message)
                if obj.TransactionItem is None:
                    print("No more line items")
                    break
                
                print("Processing Transaction Item: "+str(obj.TransactionNumber)+" out of "+str(len(obj.TransactionData))+" ---- Investor ID # "+str(obj.TransactionData1))
                obj.printlog.info("Processing Transaction Item: "+str(obj.TransactionNumber)+" out of "+str(len(obj.TransactionData))+" ---- Investor ID# "+str(obj.TransactionData1))
            
                
                try:
                    logging.info("BKFS Investor Rules Process Started")
                    
                    pr.inflightPrcs(obj)
                    # Clear cookies
                    # driver.delete_all_cookies()
                    # Close the browser when you're done
                    # driver.quit()
                    print("inside try ",obj.TransactionItem)
                except Exception as ex:
                    message=str(ex)
                    if "BRE" not in str(ex):
                        try:
                            obj.driver.save_screenshot(obj.config['SS']+str(obj.TransactionData1)+".png")
                        except:
                            pass
                    print("Process error",message)
                    traceback.print_exc()
                    
                    if 'BRE' in message:
                        obj.BusinessRuleException=message
                        print("Process BRE error",message)
                        obj.printlog.exception(message)
                    elif 'Permission denied' in message or 'EOF' in message:
                        obj.SystemException='FILE ISSUE'
                        obj.printlog.error(message)
                    else:
                        print("Restarting session")
                        obj.sessionRestarted=True
                        obj.driver.close()
                        ib.initApplications(obj)
                        obj.SystemException=message
                        obj.printlog.error(message)
                finally:
                    obj.printlog.info("After process")
                   
                    TS.setTransactionStatus(obj)
                    
                    
                    
    except Exception as ex:
        print(ex)
        traceback.print_exc()

    finally:
        try:
            obj.metrics.writeMetrics(obj)
            if obj.TransactionNumber>1:
                obj.outputfile=obj.metrics.createOutputFile(obj)
                # escalation.escMails(obj) 
                # obj.TotExpCount=obj.FatcaExpCount+obj.UWExpCount+obj.CmpltPckgExpCount+obj.ValuesPndgExpCount+obj.LetterFailExpCount+obj.DelayLtrExpCount+obj.PndgInvstRvwExpCount
                # obj.printlog.info(f'Total count of loan categories is : {obj.TotExpCount}')
                
                obj.metrics.moveFile(obj)
     
        finally:
            obj.printlog.info("Final outlook mail")  
            mail.sendOutlookMail(obj)
        obj.printlog.info("Mail sent Successfully!")
        obj.printlog.info("Execution Completed Successfully!")



process.py:

def inflightPrcs(obj):
   
    try:


        inputmapping(obj)
        OutputMapping(obj)


        # # #FACTCA1 Check####################
        # fatca.fatca1Check(obj)
        # # #inverstor call#######################

        new.searchInvestor(obj)
        element_exists(obj.driver, "/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button", obj, exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists)
        
        if str(obj.INVESTOR_TYPE_NAME) == 'OMS':
            invcap.InvestorCap(obj)
        else:
            print("Investor type name is not OMS. It's :", str(obj.INVESTOR_TYPE_NAME))





    except Exception as ex:
        
        raise
