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
import zipfile
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
from pyvirtualdisplay import Display
from email.mime.base import MIMEBase
from email import encoders

from selenium.common.exceptions import TimeoutException, StaleElementReferenceException, InvalidElementStateException



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



    def cleanup(obj):
        try:

            rpa_path = "/application/RPA"
            folders_to_check = ["LOGS", "SCREENSHOTS", "ARCHIVE", "OUT", "TEMP"]
            time_period = time.time() - (float(obj.config['days']) * 24 * 60 * 60)
            seven_days_ago = time.time() - (7 * 60 * 60 * 60)
            log_count = 0
            screenshot_count = 0
            others_count = 0
            size = 0

            output_filename = "/application/RPA/COMMON/CleanupFiles/LOGS/output_" + time.strftime("%Y%m%d-%H%M%S") + ".csv"
            with open(output_filename, 'w', newline='') as csvfile:
                csvwriter = csv.writer(csvfile)
                csvwriter.writerow(["Action", "File Path", "Modification Date"])

                # Get disk storage before running the script
                total_before = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_blocks
                free_before = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_bfree

                # Convert sizes to human-readable format
                total_before_str = f"{total_before / (1024 ** 3):.2f} GB"
                free_before_str = f"{free_before / (1024 ** 3):.2f} GB"

                # Print disk storage information before running the script
                csvwriter.writerow(["Disk Storage Before Script Execution"])
                csvwriter.writerow(["Total", total_before_str])
                csvwriter.writerow(["Free", free_before_str])
                csvwriter.writerow([])  # Empty row for separation

                temp_folder_name = "OldLogDump_" + time.strftime("%d%m%Y-%H%M%S")
                temp_folder_path = os.path.join("/application/LogDumps/", temp_folder_name)
                os.makedirs(temp_folder_path)
                try:
                    for folder in os.listdir(temp_folder_path):
                        folder_path = os.path.join(temp_folder_path, folder)
                        if os.path.isdir(folder_path):
                            folder_mtime = os.path.getmtime(folder_path)
                            if folder_mtime < seven_days_ago:
                                print("folder present is older than 7 days")
                                # Delete files in the folder
                                for file in os.listdir(folder_path):
                                    file_path = os.path.join(folder_path, file)
                                    if os.path.isfile(file_path):
                                        csvwriter.writerow(["Deleting file", file_path, ""])
                                        os.remove(file_path)
                                
                                # Check if the folder is empty after deleting files
                                if not os.listdir(folder_path):
                                    # Delete the folder if it's empty
                                    csvwriter.writerow(["Deleting folder", folder_path, ""])
                                    os.rmdir(folder_path)
                                else:
                                    # If the folder still has contents, it may be a zip archive, so extract it
                                    with zipfile.ZipFile(folder_path, 'r') as zip_ref:
                                        zip_ref.extractall(temp_folder_path)
                                    
                                    # After extracting, check if the folder is empty again
                                    if not os.listdir(folder_path):
                                        # Delete the folder if it's empty
                                        csvwriter.writerow(["Deleting folder", folder_path, ""])
                                        os.rmdir(folder_path)
                            else:
                                print("folder not older than 7 days")
                                csvwriter.writerow(["folder not older than 7 days", folder_path, ""])


                except (TimeoutException, StaleElementReferenceException) as e:
                    traceback.print_exc()           
                    print(f"error:{e}")       
                except Exception as ex:
                    raise Exception(f"error:", str(ex))                            


                ###move files
                for root, dirs, files in os.walk(rpa_path):
                    for folder_name in folders_to_check:
                        if folder_name in dirs:
                            folder_path = os.path.join(root, folder_name)
                            csvwriter.writerow(["Checking", folder_path, ""])

                            if folder_name == "LOGS":
                                runlogs_path = os.path.join(folder_path, "RUNLOGS")
                                if os.path.exists(runlogs_path):
                                    for filename in os.listdir(runlogs_path):
                                        file_path = os.path.join(runlogs_path, filename)
                                        if os.path.isfile(file_path) and os.path.getmtime(file_path) < time_period:
                                            mod_time = os.path.getmtime(file_path)
                                            mod_date = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(mod_time))
                                            log_count += 1
                                            # Generate a unique identifier for the destination filename
                                            unique_filename = str(uuid.uuid4()) + "_" + filename
                                            move_path = os.path.join(temp_folder_path, unique_filename)
                                            csvwriter.writerow(["File path", file_path, mod_date])
                                            # Check if the destination file already exists
                                            while os.path.exists(move_path):
                                                # Append a unique identifier to the filename
                                                unique_filename = str(uuid.uuid4()) + "_" + filename
                                                move_path = os.path.join(temp_folder_path, unique_filename)
                                            #Move the file to the temporary folder with the unique filename
                                            shutil.move(file_path, move_path)
                                else:
                                    pass 

                            elif folder_name == "SCREENSHOTS":
                                print(folder_path)
                                for root, dirs, files in os.walk(folder_path, topdown=True):
                                    for file in files:
                                        file_path = os.path.abspath(os.path.join(root, file))
                                        
                                        if os.path.isfile(file_path) and os.path.getmtime(file_path) < time_period:
                                            mod_time = os.path.getmtime(file_path)
                                            mod_date = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(mod_time))
                                            csvwriter.writerow(["File path", file_path, mod_date])
                                            print(file)
                                            screenshot_count += 1
                                            # Generate a unique identifier for the destination filename
                                            unique_filename = str(uuid.uuid4()) + "_" + filename
                                            move_path = os.path.join(temp_folder_path, unique_filename)
                                            csvwriter.writerow(["File path", file_path, mod_date])
                                            # Check if the destination file already exists
                                            while os.path.exists(move_path):
                                                # Append a unique identifier to the filename
                                                unique_filename = str(uuid.uuid4()) + "_" + filename
                                                move_path = os.path.join(temp_folder_path, unique_filename)
                                            # Move the file to the temporary folder with the unique filename
                                            shutil.move(file_path, move_path)
                                        else:
                                            pass
                            else:
                                for filename in os.listdir(folder_path):
                                    file_path = os.path.join(folder_path, filename)
                                    if os.path.isfile(file_path) and os.path.getmtime(file_path) < time_period:
                                        mod_time = os.path.getmtime(file_path)
                                        mod_date = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(mod_time))
                                        csvwriter.writerow(["File path", file_path, mod_date])
                                        others_count += 1
                                        # Generate a unique identifier for the destination filename
                                        unique_filename = str(uuid.uuid4()) + "_" + filename
                                        move_path = os.path.join(temp_folder_path, unique_filename)
                                        csvwriter.writerow(["File path", file_path, mod_date])
                                        # Check if the destination file already exists
                                        while os.path.exists(move_path):
                                            # Append a unique identifier to the filename
                                            unique_filename = str(uuid.uuid4()) + "_" + filename
                                            move_path = os.path.join(temp_folder_path, unique_filename)
                                        # Move the file to the temporary folder with the unique filename
                                        shutil.move(file_path, move_path)
                                    else:
                                        pass
                # Get disk storage after running the script
                total_after = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_blocks
                free_after = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_bfree

                # Calculate used space
                used_before = total_before - free_before
                used_after = total_after - free_after

                # Convert sizes to human-readable format
                total_after_str = f"{total_after / (1024 ** 3):.2f} GB"
                used_after_str = f"{used_after / (1024 ** 3):.2f} GB"
                free_after_str = f"{free_after / (1024 ** 3):.2f} GB"

                # Print disk storage information after running the script
                csvwriter.writerow([])  # Empty row for separation
                csvwriter.writerow(["Disk Storage After Script Execution"])
                csvwriter.writerow(["Total", total_after_str])
                csvwriter.writerow(["Used", used_after_str])
                csvwriter.writerow(["Free", free_after_str])

                zip_filename = f"OldLogDump_{time.strftime('%d%m%Y - %H%M%S')}.zip"
                zip_path = os.path.join("/application/LogDumps/", zip_filename)

                #Zip the temporary folder
                shutil.make_archive(temp_folder_path, 'zip', "/application/LogDumps/", temp_folder_name)
                #deletes the normal folder
                shutil.rmtree("/application/LogDumps/" + temp_folder_name)
        except Exception as ex:
            obj.SystemException = "Cleanup Script failed. Please look into it."
            raise Exception(f"error:", str(ex))
                

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
            msg['Subject']=obj.config['PROCESSNAME']+"  FAILED"
            BODY+=obj.SystemException
        else:
            msg['Subject']=obj.config['PROCESSNAME'] + "  SUCCESS"

            total_before = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_blocks
            free_before = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_bfree
            total_before_str = f"{total_before / (1024 ** 3):.2f} GB"
            free_before_str = f"{free_before / (1024 ** 3):.2f} GB"
            used_before_str = f"{(total_before - free_before) / (1024 ** 3):.2f} GB"

            BODY+=obj.config['ExchEmailBodySuccess']
            
            # Calculate disk storage details after script execution
            total_after = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_blocks
            free_after = os.statvfs("/application/RPA").f_frsize * os.statvfs("/application/RPA").f_bfree
            total_after_str = f"{total_after / (1024 ** 3):.2f} GB"
            used_after_str = f"{(total_after - free_after) / (1024 ** 3):.2f} GB"
            free_after_str = f"{free_after / (1024 ** 3):.2f} GB"

            BODY+= "<br>Disk Storage Before Script Execution: <br>"
            BODY+= f"Total: {total_before_str} <br>"
            BODY+= f"Used: {used_before_str}<br>"
            BODY+= f"Free: {free_before_str}<br>"
            # Add disk storage details to the body

            BODY+= "<br>Disk Storage After Script Execution: <br>"
            BODY+= f"Total: {total_after_str}<br>"
            BODY+= f"Used: {used_after_str}<br>"
            BODY+= f"Free: {free_after_str}<br><br>"

            output_csv_filename = "output_" + time.strftime("%Y%m%d-%H%M%S") + ".csv"
            output_csv_path = "/application/RPA/COMMON/CleanupFiles/LOGS/" + output_csv_filename

    # Check if the CSV file exists before zipping it

        # Define the path to the directory containing CSV files
            csv_directory = "/application/RPA/COMMON/CleanupFiles/LOGS/"

            # Get a list of all CSV files in the directory
            csv_files = [f for f in os.listdir(csv_directory) if f.endswith(".csv")]

            # Sort the list of CSV files by modification time in descending order
            csv_files.sort(key=lambda x: os.path.getmtime(os.path.join(csv_directory, x)), reverse=True)

            # Check if there are any CSV files in the directory
            if csv_files:
                # Get the most recent CSV file in the directory
                most_recent_csv = csv_files[0]

                # Define the desired ZIP filename format
                zip_filename = most_recent_csv.replace(".csv", ".zip")
                zip_path = os.path.join(csv_directory, zip_filename)

                # Zip the most recent CSV file
                shutil.make_archive(os.path.join(csv_directory, most_recent_csv), 'zip', csv_directory, most_recent_csv)

                # Rename the generated ZIP file to remove the extra ".zip" extension
                os.rename(os.path.join(csv_directory, most_recent_csv + ".zip"), zip_path)

                # Attach the ZIP file to the email
                attachment = open(zip_path, "rb")
                part = MIMEBase('application', 'octet-stream')
                part.set_payload((attachment).read())
                encoders.encode_base64(part)
                part.add_header('Content-Disposition', "attachment; filename= %s" % os.path.basename(zip_path))
                msg.attach(part)
            else:
                print("No CSV files found in the directory.")

            BODY += "Output File Path: " + output_csv_path
            BODY += "<Br>Time Period: {} days".format(str(obj.config['days']))
            # Add disk storage details before script execution


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
    obj=Obj("/application/RPA/COMMON/CleanupFiles/Config.csv")

    
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




