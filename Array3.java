import pandas as pd
import os
import time
import sys
sys.path.append('/application/RPA/COMMON/MODULE') 
import RQ_API
from datetime import datetime


def loadData(obj):
    if obj.TransactionData is None:
        try:
            setup(obj)
            retry_count_query=0
            query_flag=True
            file1 = open(obj.config['REQUIRED']+'QUERY.TXT',"r")  ##### READ THE QUERY
            query=file1.read()
            query=str(query)
            response=RQ_API.request(query,'ReverseQuest') #### SEND API REQUEST

            while(query_flag):
                print("###########",response)
                obj.printlog.info(response)
                if response['MESSAGE']=='Query executed successfully':
                    obj.printlog.info(str(response['MESSAGE'])+","+str(response['HTTP_STATUS_CODE']))
                    query_flag=False
                    df = pd.DataFrame(response['VALUES'],columns = ['loan_skey','original_loan_number','fha_case_number','LOAN_STATUS','LOAN_SUB_STATUS','task_description','status_description','workflow_manager','responsible_party_id','WF_TYPE','Workflow_Status','START_DATE','DUE_DATE','COMPLETE_DATE'])
                    obj.InputFile='InputFile_'+datetime.now().strftime('%m-%d-%Y')+'.csv'
                    df.to_csv(obj.config['M_IN']+obj.InputFile)
                    data=df
                    data1=pd.DataFrame()
                    data1['Loan Skey']=data['loan_skey']
                    data1['FHA_CASE_NO']=data['fha_case_number']
                    data1['Loan #']=data['original_loan_number']
                    data1['WORKFLOW_TYPE']=data['WF_TYPE']
                    data1['COMP_DATE']=data['COMPLETE_DATE']
                    data1['TSK_DESCRIPTION']=data['task_description']
                    obj.TransactionData=data1
                    obj.TransactionData=obj.TransactionData.values.tolist()
                    #obj.TransactionData=obj.TransactionData[:1]  #### CHANGE IN PROD
                    obj.printlog.info('Data Read Success!')

                elif response['MESSAGE']!='Query executed successfully':
                    if retry_count_query<int(obj.config['MAX_RETRY_COUNT']):
                        retry_count_query+=1
                        obj.printlog.info(str(retry_count_query))
                        continue
                    else:
                        obj.printlog.info(str(response['MESSAGE'])+","+str(response['HTTP_STATUS_CODE']))
                        query_flag=False
                        raise
                    
                elif response['HTTP_STATUS_CODE'] !=200:
                    if retry_count_query<int(obj.config['MAX_RETRY_COUNT']):
                        obj.printlog.info(str(retry_count_query))
                        retry_count_query+=1
                        continue
                    else:
                        query_flag=False
                        raise
                        
        
        except Exception as ex:
            raise Exception("ERROR GETTING INPUT FILE FROM RQ DATABASE")

    if obj.TransactionNumber<=len(obj.TransactionData):
        obj.TransactionItem=obj.TransactionData[obj.TransactionNumber-1]
        obj.TransactionData1=obj.TransactionItem[0]
        obj.outputfile = obj.metrics.createOutputFile(obj)
    else:
        obj.TransactionItem=None
