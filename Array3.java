Traceback (most recent call last):
  File "/application/RPA/LRPU/PLSInvestorRulesAutomation/SRC/Framework/PLSInvestortoggle.py", line 42, in validatequest
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = 'NO'
ValueError: substring not found

def validatequest(obj):


    driver = obj.driver
    try:
        time.sleep(2)
        INVESTOR_DEAL_NAME = str(obj.INVESTOR_DEAL_NAME)
        investor_deal_element = driver.find_element(By.XPATH, '/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[3]/form/div[1]/div/div[1]/div[1]/div/div/div/input')
        investor_deal_text = investor_deal_element.get_attribute("value")
        print("Text from the investor deal field",investor_deal_text)
        obj.printlog.info(f"Text from the investor deal field : {investor_deal_text}")
        if INVESTOR_DEAL_NAME =='NULL' or INVESTOR_DEAL_NAME == 'nan':
            investor_deal_element.send_keys(Keys.CONTROL + "a")
            investor_deal_element.send_keys(Keys.BACKSPACE)
            obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = 'NA' 
            print("interestrate is done to null")
        else:
            if investor_deal_text == INVESTOR_DEAL_NAME:
                print("interestrate in the bkfs field matched with the output")
                obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = 'NO'
                obj.printlog.info(f"interestrate in the bkfs field matched with the output")
            else:
                investor_deal_element.send_keys(Keys.CONTROL + "a")
                interestrate_element.send_keys(Keys.BACKSPACE)
                investor_deal_element.send_keys(INVESTOR_DEAL_NAME)
                obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = 'YES'
                print("investor_deal_element replaced.")    
                obj.printlog.info(f"investor_deal_element replaced.: {INVESTOR_DEAL_NAME}")
    except (TimeoutException, StaleElementReferenceException) as e:
        traceback.print_exc()
        print(f"error:{e}")     
    except Exception as ex:
        raise Exception(f"error:", str(ex))

class Obj:
    def __init__(self,CofigPath):
self.output=[['INVESTOR_DEAL_NAME','INVESTOR_IDNumber','INVESTOR_CATEGORY','MOD_ALLOWED','STREAMLINE_ALLOWED','INVESTOR_APPROVAL_REQUIRED','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED','NON_INTERST_BEARING_BALLOON_ALLOWED','INTEREST_RATE_REDUCTION_ALLOWED','INTEREST_BEARING_BALLOON_ALLOWED','MATURITY_EXTENSION_ALLOWED','DEFERMENT_ALLOWED','FORGIVENESS_ALLOWED','AddInterimMonth','SHORT_SALE_ALLOWED','SHORT_SALE_DELEGATED','DIL_ALLOWED','DIL_DELEGATED','FORBEARANCE_PLAN_ALLOWED','Message','INTEREST_RATE_REDUCTION_INCREMENTS','FLOOR_RATE','MARKET_RATE_TYPE','NUMBER_OF_MODS_ALLOWED','NUMBER_CAPITALIZATIONS_ALLOWED','MAX_TERM','MINIMUM_CREDIT_SCORE','TRIAL_DURATION','FORGIVENESS_UPB_LIMIT_PERCENTAGE','FORGIVENESS_LOWER_LTV_LIMIT','MATURITY_RESTRICTION_DATE','MIN_DAYS_DELINQUENT','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT','MIN_PRE_MOD_DTI','MIN_POST_MOD_DTI','MAXIMUM_POST_MOD_DTI','MIN_PRE_MOD_LTV','FORBEARANCE_LTV_LOWER_LIMIT','FORBEARANCE_UPB_LIMIT_PERCENTAGE','PAYMENT_REDUCTION_PERCENTAGE','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS','MAX_EVAL_DAY_OF_THE_MONTH','STREAMLINE_MIN_DAYS_DELINQUENT','MATURITY_DATE_EXTENTIONS_BY_MONTH','CREDIT_BUREAU_EXPIRATION_DAYS','CREDIT_BUREAU_MIN_DAYS_DELINQUENT','MODLASTUPDATE','FBLASTUPDATE','DILLASTUPDATE','SSLASTUPDATE','BOT Status','BOT Run Date','INVESTOR_DEAL_NAME_Updated ( Yes/No )','INVESTOR_IDNumber_Updated (Yes/No)','INVESTOR_CATEGORY_Updated (Yes/No)','MOD_ALLOWED_Updated (Yes/No)','STREAMLINE_ALLOWED_Updated (Yes/No)','INVESTOR_APPROVAL_REQUIRED_Updated (Yes/No)','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED_Updated (Yes/No)','NON_INTERST_BEARING_BALLOON_ALLOWED_Updated (Yes/No)','INTEREST_RATE_REDUCTION_ALLOWED_Updated (Yes/No)','INTEREST_BEARING_BALLOON_ALLOWED_Updated (Yes/No)','MATURITY_EXTENSION_ALLOWED_Updated (Yes/No)','DEFERMENT_ALLOWED_Updated (Yes/No)','FORGIVENESS_ALLOWED_Updated (Yes/No)','AddInterimMonth_Updated (Yes/No)','SHORT_SALE_ALLOWED_Updated (Yes/No)','SHORT_SALE_DELEGATED_Updated (Yes/No)','DIL_ALLOWED_Updated (Yes/No)','DIL_DELEGATED_Updated (Yes/No)','FORBEARANCE_PLAN_ALLOWED_Updated (Yes/No)','Message_Updated (Yes/No)','INTEREST_RATE_REDUCTION_INCREMENTS_Updated (Yes/No)','FLOOR_RATE_Updated (Yes/No)','MARKET_RATE_TYPE_Updated (Yes/No)','NUMBER_OF_MODS_ALLOWED_Updated (Yes/No)','NUMBER_CAPITALIZATIONS_ALLOWED_Updated (Yes/No)','MAX_TERM_Updated (Yes/No)','MINIMUM_CREDIT_SCORE_Updated (Yes/No)','TRIAL_DURATION_Updated (Yes/No)','FORGIVENESS_UPB_LIMIT_PERCENTAGE_Updated (Yes/No)','FORGIVENESS_LOWER_LTV_LIMIT_Updated (Yes/No)','MATURITY_RESTRICTION_DATE_Updated (Yes/No)','MIN_DAYS_DELINQUENT_Updated (Yes/No)','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT_Updated (Yes/No)','MIN_PRE_MOD_DTI_Updated (Yes/No)','MIN_POST_MOD_DTI_Updated (Yes/No)','MAXIMUM_POST_MOD_DTI_Updated (Yes/No)','MIN_PRE_MOD_LTV_Updated (Yes/No)','FORBEARANCE_LTV_LOWER_LIMIT_Updated (Yes/No)','FORBEARANCE_UPB_LIMIT_PERCENTAGE_Updated (Yes/No)','PAYMENT_REDUCTION_PERCENTAGE_Updated (Yes/No)','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS_Updated (Yes/No)','MAX_EVAL_DAY_OF_THE_MONTH_Updated (Yes/No)','STREAMLINE_MIN_DAYS_DELINQUENT_Updated (Yes/No)','MATURITY_DATE_EXTENTIONS_BY_MONTH_Updated (Yes/No)','CREDIT_BUREAU_EXPIRATION_DAYS_Updated (Yes/No)','CREDIT_BUREAU_MIN_DAYS_DELINQUENT_Updated (Yes/No)']]        
        self.driver=None
        
        self.sessionRestarted=False
        self.lienflag=False
        self.BotRunDate=""
        self.InputData=""
        self.em=""
        self.errorMsg=""
        self.loanstatus=""
        self.restartcount=0

        self.botstatus=""
        self.openTaskCode=""
        self.outputstatus=""
        self.InputData=""
        self.OutputData=pd.DataFrame()
        self.df1=pd.DataFrame()
        self.escDF=pd.DataFrame()
        self.delayDF=pd.DataFrame()
        self.finaldf=pd.DataFrame()
        self.outdf=pd.DataFrame()
        self.headerlist=""
        self.row=None
        self.finaloutputfile=None
        # self.POST_MARK_DATE=None
        self.partialOutputcount=0
        self.row=[]
