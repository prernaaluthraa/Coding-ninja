
    def cleanup(obj):
        try:

            rpa_path = "/application/RPA"
            folders_to_check = ["LOGS", "SCREENSHOTS", "ARCHIVE", "OUT", "TEMP"]
            time_period = time.time() - (180 * 24 * 60 * 60)
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
                                #os.remove(file_path)
                        ###Delete the folder
                        #shutil.rmtree(folder_path)

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

        except Exception as ex:
            obj.SystemException = "Cleanup Script failed. Please look into it."
            raise Exception(f"error:", str(ex))
        
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

            output_file_path = "/application/RPA/COMMON/CleanupFiles/LOGS/output_" + time.strftime("%Y%m%d-%H%M%S") + ".csv"
            BODY += "Output File Path: " + output_file_path
            time_period = 180
            BODY += "<Br>Time Period: {} days".format(time_period)
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


import os
import csv
import time
import uuid
import shutil
import smtplib
import ssl
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

# ... (the rest of your code)

def sendOutlookMail(obj):
    # ... (existing code)

    # Define the path to the output CSV file
    output_csv_filename = "output_" + time.strftime("%Y%m%d-%H%M%S") + ".csv"
    output_csv_path = "/application/RPA/COMMON/CleanupFiles/LOGS/" + output_csv_filename

    # Check if the CSV file exists before zipping it
    if os.path.exists(output_csv_path):
        # Define the desired ZIP filename format
        zip_filename = output_csv_filename.replace(".csv", ".zip")
        zip_path = os.path.join(os.path.dirname(output_csv_path), zip_filename)

        # Zip the CSV file
        shutil.make_archive(zip_path, 'zip', os.path.dirname(output_csv_path), output_csv_filename)

        # Attach the ZIP file to the email
        attachment = open(zip_path, "rb")
        part = MIMEBase('application', 'octet-stream')
        part.set_payload((attachment).read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', "attachment; filename= %s" % os.path.basename(zip_path))
        msg.attach(part)
    else:
        print(f"CSV file '{output_csv_path}' not found.")


import os
import csv
import time
import uuid
import shutil
import smtplib
import ssl
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

# ... (the rest of your code)

def sendOutlookMail(obj):
    # ... (existing code)

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
        shutil.make_archive(zip_path, 'zip', csv_directory, most_recent_csv)

        # Attach the ZIP file to the email
        attachment = open(zip_path, "rb")
        part = MIMEBase('application', 'octet-stream')
        part.set_payload((attachment).read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', "attachment; filename= %s" % os.path.basename(zip_path))
        msg.attach(part)
    else:
        print("No CSV files found in the directory.")

