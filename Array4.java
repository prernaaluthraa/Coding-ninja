INVESTOR_DEAL_NAME	
INVESTOR_IDNumber	
INVESTOR_CATEGORY	
MOD_ALLOWED	STREAMLINE_ALLOWED	
INVESTOR_APPROVAL_REQUIRED	
PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED	
NON_INTERST_BEARING_BALLOON_ALLOWED	
INTEREST_RATE_REDUCTION_ALLOWED	INTEREST_BEARING_BALLOON_ALLOWED	
MATURITY_EXTENSION_ALLOWED	
DEFERMENT_ALLOWED	
FORGIVENESS_ALLOWED	
AddInterimMonth	
SHORT_SALE_ALLOWED	
SHORT_SALE_DELEGATED	
DIL_ALLOWED	DIL_DELEGATED	
FORBEARANCE_PLAN_ALLOWED	
Message	
INTEREST_RATE_REDUCTION_INCREMENTS	
FLOOR_RATE	
MARKET_RATE_TYPE	
NUMBER_OF_MODS_ALLOWED	
NUMBER_CAPITALIZATIONS_ALLOWED	
MAX_TERM	
MINIMUM_CREDIT_SCORE	
TRIAL_DURATION	
FORGIVENESS_UPB_LIMIT_PERCENTAGE	
FORGIVENESS_LOWER_LTV_LIMIT	
MATURITY_RESTRICTION_DATE	
MIN_DAYS_DELINQUENT	
IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT	
MIN_PRE_MOD_DTI	MIN_POST_MOD_DTI	
MAXIMUM_POST_MOD_DTI	
MIN_PRE_MOD_LTV	
FORBEARANCE_LTV_LOWER_LIMIT	
FORBEARANCE_UPB_LIMIT_PERCENTAGE	
PAYMENT_REDUCTION_PERCENTAGE	
DECREMENTS_FOR_FORBEARANCE_FORGIVENESS	
MAX_EVAL_DAY_OF_THE_MONTH	
STREAMLINE_MIN_DAYS_DELINQUENT	
MATURITY_DATE_EXTENTIONS_BY_MONTH	
CREDIT_BUREAU_EXPIRATION_DAYS	
CREDIT_BUREAU_MIN_DAYS_DELINQUENT	
MODLASTUPDATE	
FBLASTUPDATE	
DILLASTUPDATE	
SSLASTUPDATE	
BOT Status	
BOT Run Date	
INVESTOR_DEAL_NAME_Updated ( Yes/No )	
INVESTOR_IDNumber_Updated ( Yes/No )	
INVESTOR_CATEGORY_Updated ( Yes/No )	
MOD_ALLOWED_Updated ( Yes/No )	
STREAMLINE_ALLOWED_Updated ( Yes/No )	
INVESTOR_APPROVAL_REQUIRED_Updated ( Yes/No )	
PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED_Updated ( Yes/No )	
NON_INTERST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )	
INTEREST_RATE_REDUCTION_ALLOWED_Updated ( Yes/No )	
INTEREST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )	
MATURITY_EXTENSION_ALLOWED_Updated ( Yes/No )	
DEFERMENT_ALLOWED_Updated ( Yes/No )	
FORGIVENESS_ALLOWED_Updated ( Yes/No )	
AddInterimMonth_Updated ( Yes/No )	
SHORT_SALE_ALLOWED_Updated ( Yes/No )	
SHORT_SALE_DELEGATED_Updated ( Yes/No )	
DIL_ALLOWED_Updated ( Yes/No )	
DIL_DELEGATED_Updated ( Yes/No )	
FORBEARANCE_PLAN_ALLOWED_Updated ( Yes/No )	
Message_Updated ( Yes/No )	
INTEREST_RATE_REDUCTION_INCREMENTS_Updated ( Yes/No )	
FLOOR_RATE_Updated ( Yes/No )	
MARKET_RATE_TYPE_Updated ( Yes/No )	
NUMBER_OF_MODS_ALLOWED_Updated ( Yes/No )	
NUMBER_CAPITALIZATIONS_ALLOWED_Updated ( Yes/No )	
MAX_TERM_Updated ( Yes/No )	
MINIMUM_CREDIT_SCORE_Updated ( Yes/No )	
TRIAL_DURATION_Updated ( Yes/No )	
FORGIVENESS_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )	
FORGIVENESS_LOWER_LTV_LIMIT_Updated ( Yes/No )	
MATURITY_RESTRICTION_DATE_Updated ( Yes/No )	
MIN_DAYS_DELINQUENT_Updated ( Yes/No )	
IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT_Updated ( Yes/No )	
MIN_PRE_MOD_DTI_Updated ( Yes/No )	
MIN_POST_MOD_DTI_Updated ( Yes/No )	
MAXIMUM_POST_MOD_DTI_Updated ( Yes/No )	
MIN_PRE_MOD_LTV_Updated ( Yes/No )	
FORBEARANCE_LTV_LOWER_LIMIT_Updated ( Yes/No )	
FORBEARANCE_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )	
PAYMENT_REDUCTION_PERCENTAGE_Updated ( Yes/No )	
DECREMENTS_FOR_FORBEARANCE_FORGIVENESS_Updated ( Yes/No )	
MAX_EVAL_DAY_OF_THE_MONTH_Updated ( Yes/No )	
STREAMLINE_MIN_DAYS_DELINQUENT_Updated ( Yes/No )	
MATURITY_DATE_EXTENTIONS_BY_MONTH_Updated ( Yes/No )	
CREDIT_BUREAU_EXPIRATION_DAYS_Updated ( Yes/No )	
CREDIT_BUREAU_MIN_DAYS_DELINQUENT_Updated ( Yes/No )


    obj.row[obj.headerlist.index('INVESTOR_IDNumber')] = obj.INVESTOR_IDNumber  #To be updated in files.
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME')] = obj.investor_deal_name
    obj.row[obj.headerlist.index('INVESTOR_CATEGORY')] = obj.investor_category
    obj.row[obj.headerlist.index('MOD_ALLOWED')] = obj.mod_allowed
    obj.row[obj.headerlist.index('STREAMLINE_ALLOWED')] = obj.streamline_allowed
    obj.row[obj.headerlist.index('INVESTOR_APPROVAL_REQUIRED')] = obj.investor_approval_required
    obj.row[obj.headerlist.index('PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED')] = obj.proprietary_mod_discount_approval_required
    obj.row[obj.headerlist.index('NON_INTERST_BEARING_BALLOON_ALLOWED')] = obj.non_interest_bearing_balloon_allowed
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_ALLOWED')] = obj.interest_rate_reduction_allowed
    obj.row[obj.headerlist.index('INTEREST_BEARING_BALLOON_ALLOWED')] = obj.interest_bearing_balloon_allowed
    obj.row[obj.headerlist.index('MATURITY_EXTEMSION_ALLOWED')] = obj.maturity_extension_allowed
    obj.row[obj.headerlist.index('DEFERMENT_ALLOWED')] = obj.deferment_allowed
    obj.row[obj.headerlist.index('FORGIVENESS_ALLOWED')] = obj.forgiveness_allowed
    obj.row[obj.headerlist.index('ADDINTERIMMONTH')] = obj.add_interim_month
    obj.row[obj.headerlist.index('SHORT_SALE_ALLOWED')] = obj.short_sale_allowed
    obj.row[obj.headerlist.index('SHORT_SALE_DELEGATED')] = obj.short_sale_delegated
    obj.row[obj.headerlist.index('DEED_IN_LIEU_ALLOWED')] = obj.deed_in_lieu_allowed
    obj.row[obj.headerlist.index('DIL_DELEGATED')] = obj.dil_delegated
    obj.row[obj.headerlist.index('FORBEARANCE_ALLOWED')] = obj.forbearance_allowed
    obj.row[obj.headerlist.index('MESSAGE')] = obj.message
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
    obj.row[obj.headerlist.index('SYSDATE')] = obj.sysdate
    obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION')] = obj.maturity_date_restriction
    obj.row[obj.headerlist.index('MIN_DAYS_DELINQUENT')] = obj.min_days_delinquent
    obj.row[obj.headerlist.index('IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT')] = obj.imminent_default_max_days_delinquent
    obj.row[obj.headerlist.index('MIN_PRE_MOD_DTI')] = obj.min_pre_mod_dti
    obj.row[obj.headerlist.index('MIN_POST_MOD_DTI')] = obj.min_post_mod_dti
    obj.row[obj.headerlist.index('MAXIMUM_POST_MOD_DTI')] = obj.maximum_post_mod_dti
    obj.row[obj.headerlist.index('MINIMUM_PRE_MOD_LTV')] = obj.minimum_pre_mod_ltv
    obj.row[obj.headerlist.index('FORBEARANCE_LTV_LOWER_LIMIT')] = obj.forbearance_ltv_lower_limit
    obj.row[obj.headerlist.index('FORBEARANCE_UPB_LIMIT_PERCENTAGE')] = obj.forbearance_upb_limit_percentage
    obj.row[obj.headerlist.index('PAYMENT_REDUCTION_PERCENTAGE')] = obj.payment_reduction_percentage
    obj.row[obj.headerlist.index('DECREMENTS_FOR_FORBEARANCE_FORGIVENESS')] = obj.decrements_for_forbearance_forgiveness
    obj.row[obj.headerlist.index('MAX_EVAL_DAY_OF_THE_MONTH')] = obj.max_eval_day_of_the_month
    obj.row[obj.headerlist.index('STREAMLINE_MIN_DAYS_DELINQUENT')] = obj.streamline_min_days_delinquent
    obj.row[obj.headerlist.index('MATURITY_DATE_EXTENTIONS_BY_MONTH')] = obj.maturity_date_extentions_by_month
    obj.row[obj.headerlist.index('CREDIT_BUREAU_EXPIRATION_DAYS')] = obj.credit_bureau_expiration_days
    obj.row[obj.headerlist.index('CREDIT_BUREAU_MIN_DAYS_DELINQUENT')] = obj.credit_bureau_min_days_delinquent
    obj.row[obj.headerlist.index('MODLASTUPDATE')] = obj.mod_last_update
    obj.row[obj.headerlist.index('FBLASTUPDATE')] = obj.fbl_last_update
    obj.row[obj.headerlist.index('DILLASTUPDATE')] = obj.dil_last_update
    obj.row[obj.headerlist.index('SSLASTUPDATE')] = obj.ssl_last_update
    obj.row[obj.headerlist.index('BOT Status')] = obj.bot_status
    obj.row[obj.headerlist.index('BOT Run Date')] = obj.bot_run_date
    obj.row[obj.headerlist.index('INVESTOR_DEAL_NAME_Updated ( Yes/No )')] = obj.investor_deal_name_updated
    obj.row[obj.headerlist.index('INVESTOR_CATEGORY_Updated ( Yes/No )')] = obj.investor_category_updated
    obj.row[obj.headerlist.index('MOD_ALLOWED_Updated ( Yes/No )')] = obj.mod_allowed_updated
    obj.row[obj.headerlist.index('STREAMLINE_ALLOWED_Updated ( Yes/No )')] = obj.streamline_allowed_updated
    obj.row[obj.headerlist.index('INVESTOR_APPROVAL_REQUIRED_Updated ( Yes/No )')] = obj.investor_approval_required_updated
    obj.row[obj.headerlist.index('PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED_Updated ( Yes/No )')] = obj.proprietary_mod_discount_approval_required_updated
    obj.row[obj.headerlist.index('NON_INTERST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')] = obj.non_interest_bearing_balloon_allowed_updated
    obj.row[obj.headerlist.index('INTEREST_RATE_REDUCTION_ALLOWED_Updated ( Yes/No )')] = obj.interest_rate_reduction_allowed_updated
    obj.row[obj.headerlist.index('INTEREST_BEARING_BALLOON_ALLOWED_Updated ( Yes/No )')] = obj.interest_bearing_balloon_allowed_updated
    obj.row[obj.headerlist.index('MATURITY_EXTEMSION_ALLOWED_Updated ( Yes/No )')] = obj.maturity_extension_allowed_updated
    obj.row[obj.headerlist.index('DEFERMENT_ALLOWED_Updated ( Yes/No )')] = obj.deferment_allowed_updated
    obj.row[obj.headerlist.index('FORGIVENESS_ALLOWED_Updated ( Yes/No )')] = obj.forgiveness_allowed_updated
    obj.row[obj.headerlist.index('ADDINTERIMMONTH_Updated ( Yes/No )')] = obj.add_interim_month_updated
    obj.row[obj.headerlist.index('SHORT_SALE_ALLOWED_Updated ( Yes/No )')] = obj.short_sale_allowed_updated
    obj.row[obj.headerlist.index('SHORT_SALE_DELEGATED_Updated ( Yes/No )')] = obj.short_sale_delegated_updated
    obj.row[obj.headerlist.index('DEED_IN_LIEU_ALLOWED_Updated ( Yes/No )')] = obj.deed_in_lieu_allowed_updated
    obj.row[obj.headerlist.index('DIL_DELEGATED_Updated ( Yes/No )')] = obj.dil_delegated_updated
    obj.row[obj.headerlist.index('FORBEARANCE_ALLOWED_Updated ( Yes/No )')] = obj.forbearance_allowed_updated
    obj.row[obj.headerlist.index('MESSAGE_Updated ( Yes/No )')] = obj.message_updated
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
    obj.row[obj.headerlist.index('SYSDATE_Updated ( Yes/No )')] = obj.sysdate_updated
    obj.row[obj.headerlist.index('MATURITY_DATE_RESTRICTION_Updated ( Yes/No )')] = obj.maturity_date_restriction_updated
    obj.row[obj.headerlist.index('MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.min_days_delinquent_updated
    obj.row[obj.headerlist.index('IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.imminent_default_max_days_delinquent_updated
    obj.row[obj.headerlist.index('MIN_PRE_MOD_DTI_Updated ( Yes/No )')] = obj.min_pre_mod_dti_updated
    obj.row[obj.headerlist.index('MIN_POST_MOD_DTI_Updated ( Yes/No )')] = obj.min_post_mod_dti_updated
    obj.row[obj.headerlist.index('MAXIMUM_POST_MOD_DTI_Updated ( Yes/No )')] = obj.maximum_post_mod_dti_updated
    obj.row[obj.headerlist.index('MINIMUM_PRE_MOD_LTV_Updated ( Yes/No )')] = obj.minimum_pre_mod_ltv_updated
    obj.row[obj.headerlist.index('FORBEARANCE_LTV_LOWER_LIMIT_Updated ( Yes/No )')] = obj.forbearance_ltv_lower_limit_updated
    obj.row[obj.headerlist.index('FORBEARANCE_UPB_LIMIT_PERCENTAGE_Updated ( Yes/No )')] = obj.forbearance_upb_limit_percentage_updated
    obj.row[obj.headerlist.index('PAYMENT_REDUCTION_PERCENTAGE_Updated ( Yes/No )')] = obj.payment_reduction_percentage_updated
    obj.row[obj.headerlist.index('DECREMENTS_FOR_FORBEARANCE_FORGIVENESS_Updated ( Yes/No )')] = obj.decrements_for_forbearance_forgiveness_updated
    obj.row[obj.headerlist.index('MAX_EVAL_DAY_OF_THE_MONTH_Updated ( Yes/No )')] = obj.max_eval_day_of_the_month_updated
    obj.row[obj.headerlist.index('STREAMLINE_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.streamline_min_days_delinquent_updated
    obj.row[obj.headerlist.index('MATURITY_DATE_EXTENTIONS_BY_MONTH_Updated ( Yes/No )')] = obj.maturity_date_extentions_by_month_updated
    obj.row[obj.headerlist.index('CREDIT_BUREAU_EXPIRATION_DAYS_Updated ( Yes/No )')] = obj.credit_bureau_expiration_days_updated
    obj.row[obj.headerlist.index('CREDIT_BUREAU_MIN_DAYS_DELINQUENT_Updated ( Yes/No )')] = obj.credit_bureau_min_days_delinquent_updated

