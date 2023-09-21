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
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.application import MIMEApplication
from pyvirtualdisplay import Display
from email.mime.base import MIMEBase
from email import encoders


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

                # Check files in the "deleted_files" folder
                for folder in os.listdir(temp_folder_path):
                    folder_path = os.path.join(temp_folder_path, folder)
                    if os.path.isdir(folder_path) and os.path.getmtime(folder_path) < seven_days_ago:
                        # Delete files in the folder
                        for file in os.listdir(folder_path):
                            file_path = os.path.join(folder_path, file)
                            if os.path.isfile(file_path):
                                csvwriter.writerow(["Deleting file", file_path, ""])
                                os.remove(file_path)
                        ###Delete the folder
                        shutil.rmtree(folder_path)

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
                
