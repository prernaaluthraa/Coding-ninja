element_exists(driver,"/html/body/div/div/div[2]/main/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div/div[2]/div/div/div/div[6]/div/span/button",exists_action=on_edit_exists, Non_exists_action=on_edit_not_exists, obj)




        #evaluating all the Data
        # evaluate.evaluateRequirements(obj)
##fetching output values
        obj.investor_deal_name_updated = obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')]
        obj.INVESTOR_IDNumber_Updated = obj.row[obj.headerlist.index('INVESTOR_IDNumber_Updated (Yes/No')]
        obj.investor_category_updated = obj.row[obj.headerlist.index('INVESTOR_CATEGORY_Updated ( Yes/No )')]
        obj.mod_allowed_updated = obj.row[obj.headerlist.index('MOD_ALLOWED_Updated ( Yes/No )')]
        obj.streamline_allowed_updated = obj.row[obj.headerlist.index('STREAMLINE_ALLOWED_Updated ( Yes/No )')]
        obj.investor_approval_required_updated = obj.row[obj.headerlist.index('INVESTOR_APPROVAL_REQUIRED_Updated ( Yes/No )')]
        obj.proprietary_mod_discount_approval_required_updated = obj.row[obj.headerlist.index('PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED_Updated ( Yes/No )')]
        obj.non_interest_bearing_balloon_allowed_updated = obj.row[obj.headerlist.index('NON_INTERST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')]
        obj.interest_rate_reduction_allowed_updated = obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_ALLOWED_Updated ( Yes/No )')]
        obj.interest_bearing_balloon_allowed_updated = obj.row[obj.headerlist.index('INTEREST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')]
        obj.maturity_extension_allowed_updated = obj.row[obj.headerlist.index('MATURITY_EXTEMSION_ALLOWED_Updated ( Yes/No )')]
        obj.deferment_allowed_updated = obj.row[obj.headerlist.index('DEFERMENT_ALLOWED_Updated ( Yes/No )')]
        obj.forgiveness_allowed_updated = obj.row[obj.headerlist.index('FORGIVENESS_ALLOWED_Updated ( Yes/No )')]
        obj.add_interim_month_updated = obj.row[obj.headerlist.index('ADDINTERIMMONTH_Updated ( Yes/No )')]
        obj.short_sale_allowed_updated = obj.row[obj.headerlist.index('SHORT_SALE_ALLOWED_Updated ( Yes/No )')]
        obj.short_sale_delegated_updated = obj.row[obj.headerlist.index('SHORT_SALE_DELEGATED_Updated ( Yes/No )')]
        obj.dil_allowed_updated = obj.row[obj.headerlist.index('DIL_ALLOWED_Updated ( Yes/No )')]
        obj.dil_delegated_updated = obj.row[obj.headerlist.index('DIL_DELEGATED_Updated ( Yes/No )')]
        obj.forbearance_allowed_updated = obj.row[obj.headerlist.index('FORBEARANCE_ALLOWED_Updated ( Yes/No )')]
        obj.message_updated = obj.row[obj.headerlist.index('MESSAGE_Updated ( Yes/No )')]
        obj.interest_rate_reduction_increments_updated = obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_INCREMENTS_Updated ( Yes/No )')]
        obj.floor_rate_updated = obj.row[obj.headerlist.index('FLOOR_RATE_Updated ( Yes/No )')]
        obj.market_rate_type_updated = obj.row[obj.headerlist.index('MARKET_RATE_TYPE_Updated ( Yes/No )')]
        obj.number_of_mods_allowed_updated = obj.row[obj.headerlist.index('NUMBER_OF_MODS_ALLOWED_Updated ( Yes/No )')]
        obj.number_capitalizations_allowed_updated = obj.row[obj.headerlist.index('NUMBER_CAPITALIZATIONS_ALLOWED_Updated ( Yes/No )')]
        obj.max_term_updated = obj.row[obj.headerlist.index('MAX_TERM_Updated ( Yes/No )')]
        obj.minimum_credit_score_updated = obj.row[obj.headerlist.index('MINIMUM_CREDIT_SCORE_Updated ( Yes/No )')]
        obj.trial_duration_updated = obj.row[obj.headerlist.index('TRIAL_DURATION_Updated ( Yes/No )')]
        obj.forgiveness_upb_limit_percentage_updated = obj.row[obj.headerlist.index('FORGIVENESS_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )')]
        obj.forgiveness_lower_ltv_limit_updated = obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT_Updated ( Yes/No )')]
        #obj.sysdate_updated = obj.row[obj.headerlist.index('SYSDATE_Updated ( Yes/No )')]
        obj.maturity_date_restriction_updated = obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated ( Yes/No )')]
        obj.min_days_delinquent_updated = obj.row[obj.headerlist.index('MIN_DAYS_DELINQUENT_Updated ( Yes/No )')]
        obj.imminent_default_max_days_delinquent_updated = obj.row[obj.headerlist.index('IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT_Updated ( Yes/No )')]
        obj.min_pre_mod_dti_updated = obj.row[obj.headerlist.index('MIN_PRE_MOD_DTI_Updated ( Yes/No )')]
        obj.min_post_mod_dti_updated = obj.row[obj.headerlist.index('MIN_POST_MOD_DTI_Updated ( Yes/No )')]
        obj.maximum_post_mod_dti_updated = obj.row[obj.headerlist.index('MAXIMUM_POST_MOD_DTI_Updated ( Yes/No )')]
        obj.minimum_pre_mod_ltv_updated = obj.row[obj.headerlist.index('MINIMUM_PRE_MOD_LTV_Updated ( Yes/No )')]
        obj.forbearance_ltv_lower_limit_updated = obj.row[obj.headerlist.index('FORBEARANCE_LTV_LOWER_LIMIT_Updated ( Yes/No )')]
        obj.forbearance_upb_limit_percentage_updated = obj.row[obj.headerlist.index('FORBEARANCE_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )')]
        obj.payment_reduction_percentage_updated = obj.row[obj.headerlist.index('PAYMENT_REDUCTION_PERCENTAGE_Updated ( Yes/No )')]
        obj.decrements_for_forbearance_forgiveness_updated = obj.row[obj.headerlist.index('DECREMENTS_FOR_FORBEARANCE_FORGIVENESS_Updated ( Yes/No )')]
        obj.max_eval_day_of_the_month_updated = obj.row[obj.headerlist.index('MAX_EVAL_DAY_OF_THE_MONTH_Updated ( Yes/No )')]
        obj.streamline_min_days_delinquent_updated = obj.row[obj.headerlist.index('STREAMLINE_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')]
        obj.maturity_date_extentions_by_month_updated = obj.row[obj.headerlist.index('MATURITY_DATE_EXTENTIONS_BY_MONTH_Updated ( Yes/No )')]
        obj.credit_bureau_expiration_days_updated = obj.row[obj.headerlist.index('CREDIT_BUREAU_EXPIRATION_DAYS_Updated ( Yes/No )')]
        obj.credit_bureau_min_days_delinquent_updated = obj.row[obj.headerlist.index('CREDIT_BUREAU_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')]



        
        #all values check
        # if (obj.FHFNMAEval == True)  or (obj.portfolio== 'FHA' or obj.portfolio== 'VA' or obj.portfolio== 'PLS' or obj.portfolio== 'USDA'):

        #     values.valuesCheck1(obj)
        #     values.valuesCheck2(obj)
        # elif (obj.portfolio== 'FHLMC' or obj.portfolio == 'FNMA') and obj.paymnt == True:

        #     values.valuesCheck3(obj)


       
        #esclation check
        # if obj.row[obj.headerlist.index('BOT Status')] == 'NA' or pd.isnull(obj.row[obj.headerlist.index('BOT Status')]) == True:
        #     escalation.escalationChecks(obj) #mails after final output mail
        #       #escalation emails
        #     # obj.metrics.createEscalationFiles(obj)
            
        # #delay letter check
        # if obj.row[obj.headerlist.index('BOT Status')] == 'NA' or pd.isnull(obj.row[obj.headerlist.index('BOT Status')]) == True:
        #     delay.delayLetterCheck(obj)


        #Final output Tag
        # if obj.row[obj.headerlist.index('BOT Status')] == 'NA' or pd.isnull(obj.row[obj.headerlist.index('BOT Status')]) == True:
           
        #     fcheck.update_commentCode(obj,'Loan reviewed by Order Values_Escalation Matrix_Delay Letter BOT - Awaiting required values / Required escalation sent')
        #     if obj.openTaskCode == 'LMINFL':
        #         fcheck.updateBotCategory(obj,'LMLDCL')
                
        #     fcheck.closeTask(obj,'LMINFL')
        #     obj.row[obj.headerlist.index('BOT Status')]='Values Pending'
        #     obj.row[obj.headerlist.index('Output Status')]='Loan reviewed by Order Values_Escalation Matrix_Delay Letter BOT - Awaiting required values / Required escalation sent'  
        #     obj.printlog.info('Loan reviewed by Order Values_Escalation Matrix_Delay Letter BOT - Awaiting required values / Required escalation sent')
    


    except Exception as ex:
        
        raise

def OutputMapping(obj):
    obj.printlog.info("Ouput values mapping start")
   
    obj.headerlist=obj.output[0]
    # print("header list is ",obj.headerlist)obj.row
    obj.row=[]
    obj.row=["NA"]*(len(obj.headerlist))
    print("index of bot run date ",obj.headerlist.index('BOT Run Date'))
    obj.row[obj.headerlist.index('BOT Run Date')]=obj.BotRunDate
    obj.row[obj.headerlist.index('INVESTOR_IDNumber')]=obj.TransactionItem[0] 

    #fetching date from DLQ1 to calculate current due days
    # if (obj.TransactionNumber == 1 or obj.sessionRestarted):
    #     if obj.sessionRestarted == True:
    #         obj.sessionRestarted=False
    #     obj.terminalConnection.send_string("DLQ1"+str(obj.TransactionData1),1,57)
    #     obj.terminalConnection.send_enter()
    #     obj.terminalConnection.wait_for_field()
    # else:
    #     obj.terminalConnection.send_string("DLQ1"+str(obj.TransactionData1),1,2)
    #     obj.terminalConnection.send_enter()
    #     obj.terminalConnection.wait_for_field()
    # obj.DLQ1Date=obj.terminalConnection.string_get(3,29,8)

    # date1=datetime.strptime(obj.BotRunDate, '%m/%d/%Y')
    # if (obj.DLQ1Date != '') or ('_' not in obj.DLQ1Date):
    #     date2=datetime.strptime(obj.DLQ1Date, '%m/%d/%y')
    # else:
    #     date2=0

    #Updated
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME')] = obj.INVESTOR_DEAL_NAME
    obj.row[obj.headerlist.index('INVESTOR_IDNumber')] = obj.INVESTOR_IDNumber
    obj.row[obj.headerlist.index('INVESTOR_CATEGORY')] = obj.investor_category
    obj.row[obj.headerlist.index('MOD_ALLOWED')] = obj.mod_allowed
    obj.row[obj.headerlist.index('STREAMLINE_ALLOWED')] = obj.streamline_allowed
    obj.row[obj.headerlist.index('INVESTOR_APPROVAL_REQUIRED')] = obj.investor_approval_required
    obj.row[obj.headerlist.index('PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED')] = obj.proprietary_mod_discount_approval_required
    obj.row[obj.headerlist.index('NON_INTERST_BEARING_BALLOON_ALLOWED')] = obj.non_interest_bearing_balloon_allowed
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_ALLOWED')] = obj.interest_rate_reduction_allowed
    obj.row[obj.headerlist.index('INTEREST_BEARING_BALLOON_ALLOWED')] = obj.interest_bearing_balloon_allowed
    obj.row[obj.headerlist.index('MATURITY_EXTENSION_ALLOWED')] = obj.maturity_extension_allowed
    obj.row[obj.headerlist.index('DEFERMENT_ALLOWED')] = obj.deferment_allowed
    obj.row[obj.headerlist.index('FORGIVENESS_ALLOWED')] = obj.forgiveness_allowed
    obj.row[obj.headerlist.index('AddInterimMonth')] = obj.add_interim_month
    obj.row[obj.headerlist.index('SHORT_SALE_ALLOWED')] = obj.short_sale_allowed
    obj.row[obj.headerlist.index('SHORT_SALE_DELEGATED')] = obj.short_sale_delegated
    obj.row[obj.headerlist.index('DIL_ALLOWED')] = obj.dil_allowed
    obj.row[obj.headerlist.index('DIL_DELEGATED')] = obj.dil_delegated
    obj.row[obj.headerlist.index('FORBEARANCE_PLAN_ALLOWED')] = obj.forbearance_plan_allowed
    obj.row[obj.headerlist.index('Message')] = obj.message
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_INCREMENTS')] = obj.interest_rate_reduction_increments
    obj.row[obj.headerlist.index('FLOOR_RATE')] = obj.floor_rate
    obj.row[obj.headerlist.index('MARKET_RATE_TYPE')] = obj.market_rate_type
    obj.row[obj.headerlist.index('NUMBER_OF_MODS_ALLOWED')] = obj.number_of_mods_allowed
    obj.row[obj.headerlist.index('NUMBER_CAPITALIZATIONS_ALLOWED')] = obj.number_capitalizations_allowed
    obj.row[obj.headerlist.index('MAX_TERM')] = obj.max_term
    obj.row[obj.headerlist.index('MINIMUM_CREDIT_SCORE')] = obj.minimum_credit_score
    obj.row[obj.headerlist.index('TRIAL_DURATION')] = obj.trial_duration
    obj.row[obj.headerlist.index('FORGIVENESS_UPB_LIMIT_PERCENTAGE')] = obj.forgiveness_upb_limit_percentage
    obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT')] = obj.forgiveness_lower_ltv_limit
    obj.row[obj.headerlist.index('MATURITY_RESTRICTION_DATE')] = obj.maturity_restriction_date
    obj.row[obj.headerlist.index('MIN_DAYS_DELINQUENT')] = obj.min_days_delinquent
    obj.row[obj.headerlist.index('IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT')] = obj.imminent_default_max_days_delinquent
    obj.row[obj.headerlist.index('MIN_PRE_MOD_DTI')] = obj.min_pre_mod_dti
    obj.row[obj.headerlist.index('MIN_POST_MOD_DTI')] = obj.min_post_mod_dti
    obj.row[obj.headerlist.index('MAXIMUM_POST_MOD_DTI')] = obj.maximum_post_mod_dti
    obj.row[obj.headerlist.index('MIN_PRE_MOD_LTV')] = obj.min_pre_mod_ltv
    obj.row[obj.headerlist.index('FORBEARANCE_LTV_LOWER_LIMIT')] = obj.forbearance_ltv_lower_limit
    obj.row[obj.headerlist.index('FORBEARANCE_UPB_LIMIT_PERCENTAGE')] = obj.forbearance_upb_limit_percentage
    obj.row[obj.headerlist.index('PAYMENT_REDUCTION_PERCENTAGE')] = obj.payment_reduction_percentage
    obj.row[obj.headerlist.index('DECREMENTS_FOR_FORBEARANCE_FORGIVENESS')] = obj.decrements_for_forbearance_forgiveness
    obj.row[obj.headerlist.index('MAX_EVAL_DAY_OF_THE_MONTH')] = obj.max_eval_day_of_the_month
    obj.row[obj.headerlist.index('STREAMLINE_MIN_DAYS_DELINQUENT')] = obj.streamline_min_days_delinquent
    obj.row[obj.headerlist.index('MATURITY_DATE_EXTENTIONS_BY_MONTH')] = obj.maturity_date_extensions_by_month
    obj.row[obj.headerlist.index('CREDIT_BUREAU_EXPIRATION_DAYS')] = obj.credit_bureau_expiration_days
    obj.row[obj.headerlist.index('CREDIT_BUREAU_MIN_DAYS_DELINQUENT')] = obj.credit_bureau_min_days_delinquent
    obj.row[obj.headerlist.index('MODLASTUPDATE')] = obj.mod_last_update
    obj.row[obj.headerlist.index('FBLASTUPDATE')] = obj.fbl_last_update
    obj.row[obj.headerlist.index('DILLASTUPDATE')] = obj.dil_last_update
    obj.row[obj.headerlist.index('SSLASTUPDATE')] = obj.ssl_last_update
    obj.row[obj.headerlist.index('BOT Status')] = obj.BOT_Status
    obj.row[obj.headerlist.index('BOT Run Date')] = obj.BOT_Run_Date
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = obj.investor_deal_name_updated
    obj.row[obj.headerlist.index('INVESTOR_IDNumber_Updated ( Yes/No )')] = obj.INVESTOR_IDNumber_Updated
    obj.row[obj.headerlist.index('INVESTOR_CATEGORY_Updated ( Yes/No )')] = obj.investor_category_updated
    obj.row[obj.headerlist.index('MOD_ALLOWED_Updated ( Yes/No )')] = obj.mod_allowed_updated
    obj.row[obj.headerlist.index('STREAMLINE_ALLOWED_Updated ( Yes/No )')] = obj.streamline_allowed_updated
    obj.row[obj.headerlist.index('INVESTOR_APPROVAL_REQUIRED_Updated ( Yes/No )')] = obj.investor_approval_required_updated
    obj.row[obj.headerlist.index('PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED_Updated ( Yes/No )')] = obj.proprietary_mod_discount_approval_required_updated
    obj.row[obj.headerlist.index('NON_INTERST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')] = obj.non_interest_bearing_balloon_allowed_updated
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_ALLOWED_Updated ( Yes/No )')] = obj.interest_rate_reduction_allowed_updated
    obj.row[obj.headerlist.index('INTEREST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')] = obj.interest_bearing_balloon_allowed_updated
    obj.row[obj.headerlist.index('MATURITY_EXTENSION_ALLOWED_Updated ( Yes/No )')] = obj.maturity_extension_allowed_updated
    obj.row[obj.headerlist.index('DEFERMENT_ALLOWED_Updated ( Yes/No )')] = obj.deferment_alllowed_updated
    obj.row[obj.headerlist.index('FORGIVENESS_ALLOWED_Updated ( Yes/No )')] = obj.forgiveness_allowed_updated
    obj.row[obj.headerlist.index('AddInterimMonth_Updated ( Yes/No )')] = obj.add_interim_month_updated
    obj.row[obj.headerlist.index('SHORT_SALE_ALLOWED_Updated ( Yes/No )')] = obj.short_sale_allowed_updated
    obj.row[obj.headerlist.index('SHORT_SALE_DELEGATED_Updated ( Yes/No )')] = obj.short_sale_delegated_updated
    obj.row[obj.headerlist.index('DIL_ALLOWED_Updated ( Yes/No )')] = obj.dil_allowed_updated
    obj.row[obj.headerlist.index('DIL_DELEGATED_Updated ( Yes/No )')] = obj.dil_delegated_updated
    obj.row[obj.headerlist.index('FORBEARANCE_PLAN_ALLOWED_Updated ( Yes/No )')] = obj.forbearance_allowed_updated
    obj.row[obj.headerlist.index('Message_Updated ( Yes/No )')] = obj.message_updated
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_INCREMENTS_Updated ( Yes/No )')] = obj.interest_rate_reduction_increments_updated
    obj.row[obj.headerlist.index('FLOOR_RATE_Updated ( Yes/No )')] = obj.floor_rate_updated
    obj.row[obj.headerlist.index('MARKET_RATE_TYPE_Updated ( Yes/No )')] = obj.market_rate_type_updated
    obj.row[obj.headerlist.index('NUMBER_OF_MODS_ALLOWED_Updated ( Yes/No )')] = obj.number_of_mods_allowed_updated
    obj.row[obj.headerlist.index('NUMBER_CAPITALIZATIONS_ALLOWED_Updated ( Yes/No )')] = obj.number_capitalizations_allowed_updated
    obj.row[obj.headerlist.index('MAX_TERM_Updated ( Yes/No )')] = obj.max_term_updated
    obj.row[obj.headerlist.index('MINIMUM_CREDIT_SCORE_Updated ( Yes/No )')] = obj.minimum_credit_score_updated
    obj.row[obj.headerlist.index('TRIAL_DURATION_Updated ( Yes/No )')] = obj.trial_duration_updated
    obj.row[obj.headerlist.index('FORGIVENESS_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )')] = obj.forgiveness_upb_limit_percentage_updated
    obj.row[obj.headerlist.index('FORGIVENESS_LOWER_LTV_LIMIT_Updated ( Yes/No )')] = obj.forgiveness_lower_ltv_limit_updated
    obj.row[obj.headerlist.index('MATURITY_RESTRICTION_DATE_Updated ( Yes/No )')] = obj.maturity_date_restriction_updated
    obj.row[obj.headerlist.index('MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.min_days_delinquent_updated
    obj.row[obj.headerlist.index('IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.imminent_default_max_days_delinquent_updated
    obj.row[obj.headerlist.index('MIN_PRE_MOD_DTI_Updated ( Yes/No )')] = obj.min_pre_mod_dti_updated
    obj.row[obj.headerlist.index('MIN_POST_MOD_DTI_Updated ( Yes/No )')] = obj.min_post_mod_dti_updated
    obj.row[obj.headerlist.index('MAXIMUM_POST_MOD_DTI_Updated ( Yes/No )')] = obj.maximum_post_mod_dti_updated
    obj.row[obj.headerlist.index('MIN_PRE_MOD_LTV_Updated ( Yes/No )')] = obj.minimum_pre_mod_ltv_updated
    obj.row[obj.headerlist.index('FORBEARANCE_LTV_LOWER_LIMIT_Updated ( Yes/No )')] = obj.forbearance_ltv_lower_limit_updated
    obj.row[obj.headerlist.index('FORBEARANCE_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )')] = obj.forbearance_upb_limit_percentage_updated
    obj.row[obj.headerlist.index('PAYMENT_REDUCTION_PERCENTAGE_Updated ( Yes/No )')] = obj.payment_reduction_percentage_updated
    obj.row[obj.headerlist.index('DECREMENTS_FOR_FORBEARANCE_FORGIVENESS_Updated ( Yes/No )')] = obj.decrements_for_forbearance_forgiveness_updated
    obj.row[obj.headerlist.index('MAX_EVAL_DAY_OF_THE_MONTH_Updated ( Yes/No )')] = obj.max_eval_day_of_the_month_updated
    obj.row[obj.headerlist.index('STREAMLINE_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.streamline_min_days_delinquent_updated
    obj.row[obj.headerlist.index('MATURITY_DATE_EXTENTIONS_BY_MONTH_Updated ( Yes/No )')] = obj.maturity_date_extentions_by_month_updated
    obj.row[obj.headerlist.index('CREDIT_BUREAU_EXPIRATION_DAYS_Updated ( Yes/No )')] = obj.credit_bureau_expiration_days_updated
    obj.row[obj.headerlist.index('CREDIT_BUREAU_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.credit_bureau_min_days_delinquent_updated

def inputmapping(obj):

    obj.printlog.info("input values mapping start")
    obj.INVESTOR_DEAL_NAME = obj.InputData['INVESTOR_DEAL_NAME'][obj.TransactionNumber-1]
    obj.INVESTOR_IDNumber = obj.InputData['INVESTOR_IDNumber'][obj.TransactionNumber-1]
    obj.investor_category = obj.InputData['INVESTOR_CATEGORY'][obj.TransactionNumber-1]
    obj.mod_allowed = obj.InputData['MOD_ALLOWED'][obj.TransactionNumber-1]
    obj.streamline_allowed = obj.InputData['STREAMLINE_ALLOWED'][obj.TransactionNumber-1]
    obj.investor_approval_required = obj.InputData['INVESTOR_APPROVAL_REQUIRED'][obj.TransactionNumber-1]
    obj.proprietary_mod_discount_approval_required = obj.InputData['PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED'][obj.TransactionNumber-1]
    obj.non_interest_bearing_balloon_allowed = obj.InputData['NON_INTERST_BEARING_BALLOON_ALLOWED'][obj.TransactionNumber-1]
    obj.interest_rate_reduction_allowed = obj.InputData['INTEREST_RATE_REDUCTION_ALLOWED'][obj.TransactionNumber-1]
    obj.interest_bearing_balloon_allowed = obj.InputData['INTEREST_BEARING_BALLOON_ALLOWED'][obj.TransactionNumber-1]
    obj.maturity_extension_allowed = obj.InputData['MATURITY_EXTENSION_ALLOWED'][obj.TransactionNumber-1]
    obj.deferment_allowed = obj.InputData['DEFERMENT_ALLOWED'][obj.TransactionNumber-1]
    obj.forgiveness_allowed = obj.InputData['FORGIVENESS_ALLOWED'][obj.TransactionNumber-1]
    obj.add_interim_month = obj.InputData['AddInterimMonth'][obj.TransactionNumber-1]
    obj.short_sale_allowed = obj.InputData['SHORT_SALE_ALLOWED'][obj.TransactionNumber-1]
    obj.short_sale_delegated = obj.InputData['SHORT_SALE_DELEGATED'][obj.TransactionNumber-1]
    obj.dil_allowed = obj.InputData['DIL_ALLOWED'][obj.TransactionNumber-1]
    obj.dil_delegated = obj.InputData['DIL_DELEGATED'][obj.TransactionNumber-1]
    obj.forbearance_plan_allowed = obj.InputData['FORBEARANCE_PLAN_ALLOWED'][obj.TransactionNumber-1]
    obj.message = obj.InputData['Message'][obj.TransactionNumber-1]
    obj.interest_rate_reduction_increments = obj.InputData['INTEREST_RATE_REDUCTION_INCREMENTS'][obj.TransactionNumber-1]
    obj.floor_rate = obj.InputData['FLOOR_RATE'][obj.TransactionNumber-1]
    obj.market_rate_type = obj.InputData['MARKET_RATE_TYPE'][obj.TransactionNumber-1]
    obj.number_of_mods_allowed = obj.InputData['NUMBER_OF_MODS_ALLOWED'][obj.TransactionNumber-1]
    obj.number_capitalizations_allowed = obj.InputData['NUMBER_CAPITALIZATIONS_ALLOWED'][obj.TransactionNumber-1]
    obj.max_term = obj.InputData['MAX_TERM'][obj.TransactionNumber-1]
    obj.minimum_credit_score = obj.InputData['MINIMUM_CREDIT_SCORE'][obj.TransactionNumber-1]
    obj.trial_duration = obj.InputData['TRIAL_DURATION'][obj.TransactionNumber-1]
    obj.forgiveness_upb_limit_percentage = obj.InputData['FORGIVENESS_UPB_LIMIT_PERCENTAGE'][obj.TransactionNumber-1]
    obj.forgiveness_lower_ltv_limit = obj.InputData['FORGIVENESS_LOWER_LTV_LIMIT'][obj.TransactionNumber-1]
    obj.maturity_restriction_date = obj.InputData['MATURITY_RESTRICTION_DATE'][obj.TransactionNumber-1]
    obj.min_days_delinquent = obj.InputData['MIN_DAYS_DELINQUENT'][obj.TransactionNumber-1]
    obj.imminent_default_max_days_delinquent = obj.InputData['IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT'][obj.TransactionNumber-1]
    obj.min_pre_mod_dti = obj.InputData['MIN_PRE_MOD_DTI'][obj.TransactionNumber-1]
    obj.min_post_mod_dti = obj.InputData['MIN_POST_MOD_DTI'][obj.TransactionNumber-1]
    obj.maximum_post_mod_dti = obj.InputData['MAXIMUM_POST_MOD_DTI'][obj.TransactionNumber-1]
    obj.min_pre_mod_ltv = obj.InputData['MIN_PRE_MOD_LTV'][obj.TransactionNumber-1]
    obj.forbearance_ltv_lower_limit = obj.InputData['FORBEARANCE_LTV_LOWER_LIMIT'][obj.TransactionNumber-1]
    obj.forbearance_upb_limit_percentage = obj.InputData['FORBEARANCE_UPB_LIMIT_PERCENTAGE'][obj.TransactionNumber-1]
    obj.payment_reduction_percentage = obj.InputData['PAYMENT_REDUCTION_PERCENTAGE'][obj.TransactionNumber-1]
    obj.decrements_for_forbearance_forgiveness = obj.InputData['DECREMENTS_FOR_FORBEARANCE_FORGIVENESS'][obj.TransactionNumber-1]
    obj.max_eval_day_of_the_month = obj.InputData['MAX_EVAL_DAY_OF_THE_MONTH'][obj.TransactionNumber-1]
    obj.streamline_min_days_delinquent = obj.InputData['STREAMLINE_MIN_DAYS_DELINQUENT'][obj.TransactionNumber-1]
    obj.maturity_date_extensions_by_month = obj.InputData['MATURITY_DATE_EXTENTIONS_BY_MONTH'][obj.TransactionNumber-1]
    obj.credit_bureau_expiration_days = obj.InputData['CREDIT_BUREAU_EXPIRATION_DAYS'][obj.TransactionNumber-1]
    obj.credit_bureau_min_days_delinquent = obj.InputData['CREDIT_BUREAU_MIN_DAYS_DELINQUENT'][obj.TransactionNumber-1]
    obj.mod_last_update = obj.InputData['MODLASTUPDATE'][obj.TransactionNumber-1]
    obj.fbl_last_update = obj.InputData['FBLASTUPDATE'][obj.TransactionNumber-1]
    obj.dil_last_update = obj.InputData['DILLASTUPDATE'][obj.TransactionNumber-1]
    obj.ssl_last_update = obj.InputData['SSLASTUPDATE'][obj.TransactionNumber-1]   
    obj.printlog.info("input values mapping End")


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
  
