import os
import time
import csv
import pandas as pd
import smtplib,ssl
import getpass
import sys
import cx_Oracle
import traceback
import base64
import shutil
import uuid
import pyodbc
import openpyxl
from datetime import date, datetime, timedelta
import openpyxl.styles as styles
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
from pyvirtualdisplay import Display
from exchangelib import Message, FileAttachment, HTMLBody

class Obj:
    # def __init__(self,CofigPath):
        
    #     self.config=None
    #     self.CofigPath=CofigPath
    #     self.SystemException=None
    def __init__(self, ConfigPath):
        self.config = self.load_config(ConfigPath)
        self.SystemException = None
        #self.asset_connection=None
        self.connection=None
        self.asset_connection=self.dbConnect('RPA_RO','Rpa#357dtro','ononpexd-scan.corp.ocwen.com','1521','odclrep_atl')


    def load_config(self, ConfigPath):
        df = pd.read_csv(ConfigPath)
        config = {}
        for _, row in df.iterrows():
            config[row['NAME']] = row['VALUE']
        return config

    def dbConnect(self,user,pwd,host,port,service):
        try:
            connectionString=user+'/'+pwd+'@'+host+':'+str(port)+'/'+service
            connection=cx_Oracle.connect(connectionString)
            print("Connected to the DB!")
            return connection
        except Exception as ex:
            raise Exception("Error Connecting DataBase with Exception :",str(ex))  

    def last_working_date(obj):
        today = date.today()
        weekday = today.weekday()

        if weekday == 0:
            last_working_day = today - timedelta(days=3)
        else:
            last_working_day = today - timedelta(days=1)

        formatted_date = last_working_day.strftime("%m/%d/%Y")
        print("Last working day:", formatted_date)
        return formatted_date

    def read_query(obj, file_path):
        with open(file_path, 'r') as file:
            query = file.read()
        return query

    def cleanup(obj):
        query_file_path = '/application/RPA/LRPU/PLSInvestorRulesAutomation/REQUIRED/Query.txt'
        # filename = 'data.xlsx'   
        query = obj.read_query(query_file_path)
        query = query.replace('date',last_working_date(obj))
        print(query)

        drivers = [item for item in pyodbc.drivers()]
        print("Establishing connection")
        print("############### DRIVERS",drivers)
        driver = drivers[0]
        server = '10.72.8.53,50011'
        database = 'InvestorRulesMSP'
        uid = 'svcs_rpa_prod_bot1'
        pwd = 'OcwenBOAT@123'
        SSO = 'Trusted_Connection=yes'
        timeout = '30'
        con_string = f'driver={driver};server={server};database={database};uid={uid};pwd={pwd};'
        cnxn = pyodbc.connect(con_string)
        print("connection established")
        cursor = cnxn.cursor()
        print("connection established, yes")

        # Execute the query
        cursor.execute(query)

        # Get the column names

        column_names = [description[0] for description in cursor.description]

        # Fetch all the results
        results = cursor.fetchall()
        print("Number od rows in results", len(results))
        # Preprocess the results to handle 'NULL' values
        processed_results = []
        for row in results:
            processed_row = [value if value is not None else 'NULL' for value in row]
            processed_results.append(processed_row)

        # Create a DataFrame from the processed results and column names if there are rows
        if len(processed_results) > 0:
            print("Number of columns in results:", len(processed_results[0]))
            print("Number of column names:", column_names)

            # Create a DataFrame from the processed results and column names
            df = pd.DataFrame(processed_results, columns=column_names)

            InputFile = 'BKFS PLS Investor Rules Input Data_' + datetime.now().strftime('%m.%d.%Y') + '.xlsx'
            df.to_excel('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile, index=False)
            print("Results saved to input file")
            # df = pd.DataFrame(results, columns = ['INVESTOR_ID','INVESTOR_DEAL_NAME','INVESTOR_CATEGORY','MOD_ALLOWED','STREAMLINE_ALLOWED','INVESTOR_APPROVAL_REQUIRED','PROPRIETARY_MOD_DISCOUNT_APPROVAL_REQUIRED','NON_INTERST_BEARING_BALLOON_ALLOWED','INTEREST_RATE_REDUCTION_ALLOWED','INTEREST_BEARING_BALLOON_ALLOWED','MATURITY_EXTEMSION_ALLOWED','DEFERMENT_ALLOWED','FORGIVENESS_ALLOWED','ADDINTERIMMONTH','SHORT_SALE_ALLOWED','SHORT_SALE_DELEGATED','DEED_IN_LIEU_ALLOWED','DIL_DELEGATED','FORBEARANCE_ALLOWED','MESSAGE','INTEREST_RATE_REDUCTION_INCREMENTS','FLOOR_RATE','MARKET_RATE_TYPE','NUMBER_OF_MODS_ALLOWED','NUMBER_CAPITALIZATIONS_ALLOWED','MAX_TERM','MINIMUM_CREDIT_SCORE','TRIAL_DURATION','FORGIVENESS_UPB_LIMIT_PERCENTAGE','FORGIVENESS_LOWER_LTV_LIMIT','SYSDATE','MATURITY_DATE_RESTRICTION','MIN_DAYS_DELINQUENT','IMMINENT_DEFAULT_MAX_DAYS_DELINQUENT','MIN_PRE_MOD_DTI','MIN_POST_MOD_DTI','MAXIMUM_POST_MOD_DTI','MINIMUM_PRE_MOD_LTV','FORBEARANCE_LTV_LOWER_LIMIT','FORBEARANCE_UPB_LIMIT_PERCENTAGE','PAYMENT_REDUCTION_PERCENTAGE','DECREMENTS_FOR_FORBEARANCE_FORGIVENESS','MAX_EVAL_DAY_OF_THE_MONTH','STREAMLINE_MIN_DAYS_DELINQUENT','MATURITY_DATE_EXTENTIONS_BY_MONTH','CREDIT_BUREAU_EXPIRATION_DAYS','CREDIT_BUREAU_MIN_DAYS_DELINQUENT','MODLASTUPDATE','FBLASTUPDATE','DILLASTUPDATE','SSLASTUPDATE'])

            # InputFile='InputFile_'+datetime.now().strftime('%m-%d-%Y')+'.csv'
            # df.to_csv('D:/RPA/Prerna/Investor Rules/'+InputFile, index=False)
            
            # Load the Excel file using openpyxl
            wb = openpyxl.load_workbook('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile)

            # Select the active sheet
            sheet = wb.active

            # Apply formatting to column headers
            header_font = styles.Font(color="000000", bold=True)
            header_fill = styles.PatternFill(fill_type="solid", fgColor="FFCC99")

            for col_idx, column_name in enumerate(column_names, start=1):
                cell = sheet.cell(row=1, column=col_idx)
                cell.font = header_font
                cell.fill = header_fill

            # Save the modified Excel file
            wb.save('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile)
            print("Results input file saved")

        else:
            print("No results found. Creating empty file with headers.")

            # Create an empty DataFrame with only the column names
            df = pd.DataFrame(columns=column_names)

            InputFile = 'BKFS PLS Investor Rules Input Data_' + datetime.now().strftime('%m.%d.%Y') + '.xlsx'
            #df.to_excel('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile, index=False)

            wb = openpyxl.Workbook()
            sheet = wb.active

            header_font = styles.Font(color="000000", bold=True)
            header_fill = styles.PatternFill(fill_type="solid", fgColor="FFCC99")

            for col_idx, column_name in enumerate(column_names, start=1):
                cell = sheet.cell(row=1, column=col_idx)
                cell.value = column_name
                cell.font = header_font
                cell.fill = header_fill

            wb.save('/application/RPA/LRPU/PLSInvestorRulesAutomation/IN/' + InputFile)

        # Close the cursor and connection
        cursor.close()
        cnxn.close()


    def get_password(self,asset_name):
        try:
            query="select USER_ID,PASSWORD from RPA.PYTHON_ASSETS WHERE ASSET_NAME='{}'".format(asset_name.upper())
            cursor=self.asset_connection.cursor()
            result=cursor.execute(query)
            asset=result.fetchall()
            if len(asset)==0:
                raise Exception("BRE: Asset Not Found")
            count=int(asset[0][1].split('?')[1])
            password=asset[0][1].split('?')[0]
            for i in range(count):
                password=base64.b64decode(password)
            return [asset[0][0],password.decode('utf-8')]
        except:
            raise
    #email part
    def sendOutlookMail(obj):
        port = int(obj.config['ExchangePort'])
        SERVER = obj.config['ExchangeServer']
        msg=MIMEMultipart('alternative')
        asset=obj.get_password(obj.config['asset_email'])
        frm=asset[0]
        disclamerfile=open(obj.config['COMMON_REQUIRED']+"Disclaimer.htm",'r')
        disclamer=disclamerfile.read()
        disclamerfile.close()
        to=obj.config['ExchEmailTo'].split(";")
        cc=obj.config['ExchEmailCc'].split(";")
        msg['From']=frm
        msg['To']=','.join(to)
        msg['Cc']=','.join(cc)
        to+=cc
        BODY=''
        if obj.SystemException:
            msg['Subject']=obj.config['PROCESSNAME']+ " FAILED"
            BODY+=obj.SystemException
        else:
            msg['Subject']=obj.config['PROCESSNAME'] + "Input Data_" + datetime.now().strftime('%m.%d.%Y')
            BODY+=obj.config['ExchEmailBodySuccess'].replace('AAAAA',str(InputFile.split('/')[-1]))
            with open(InputFile,'rb') as atch:
                part=MIMEApplication(atch.read(),Name=InputFile)
            part['Content-Disposition']='attachment;filename="{}"'.format(InputFile.split('/')[-1])
            msg.attach(part)
        BODY+=disclamer
        msg.attach(MIMEText(BODY,'plain'))
        msg.attach(MIMEText(BODY,'html'))
        context = ssl.create_default_context()
        server=smtplib.SMTP(SERVER,port)
        server.starttls(context=context)
        #server.login(frm,asset[1])
        server.sendmail(frm,to,msg.as_string())
        server.quit()

def main():
    print("Process Started Successfully!")
    obj=Obj("/application/RPA/LRPU/PLSInvestorRulesAutomation/CONFIG/Config.csv")
    formatted_date = obj.last_working_date()
    
    try:
        #call functions here
        obj.cleanup()
        obj.sendOutlookMail()
    finally:

        print("Execution Completed Successfully!")

if __name__=="__main__":
    display=Display(visible=0,size=(1366,768))
    display.start()
    main()
    display.stop()
