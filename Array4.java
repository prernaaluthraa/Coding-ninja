import os
import time
import csv
import pandas as pd
import shutil
import uuid
import zipfile

class Obj:
    def __init__(self, ConfigPath):
        self.config = self.load_config(ConfigPath)
        self.SystemException = None

    def load_config(self, ConfigPath):
        df = pd.read_csv(ConfigPath)
        config = {}
        for _, row in df.iterrows():
            config[row['NAME']] = row['VALUE']
        return config

    def cleanup(self):
        try:
            rpa_path = "/application/RPA"
            folders_to_check = ["LOGS", "SCREENSHOTS", "ARCHIVE", "OUT", "TEMP"]
            time_period = time.time() - (float(self.config['days']) * 24 * 60 * 60)
            seven_days_ago = time.time() - (7 * 24 * 60 * 60)
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

                # Check and delete zip folders older than 7 days
                for root, dirs, files in os.walk("/application/LogDumps/"):
                    for folder_name in dirs:
                        folder_path = os.path.join(root, folder_name)
                        if folder_name.endswith(".zip"):
                            folder_mtime = os.path.getmtime(folder_path)
                            if folder_mtime < seven_days_ago:
                                csvwriter.writerow(["Deleting zip folder", folder_path, ""])
                                shutil.rmtree(folder_path)

                # Check for and delete folders older than 7 days
                for folder_name in os.listdir("/application/LogDumps/"):
                    folder_path = os.path.join("/application/LogDumps/", folder_name)
                    if os.path.isdir(folder_path):
                        folder_mtime = os.path.getmtime(folder_path)
                        if folder_mtime < seven_days_ago:
                            print(f"Folder {folder_path} is older than 7 days. Deleting...")
                            shutil.rmtree(folder_path)

                temp_folder_name = "OldLogDump_" + time.strftime("%d%m%Y-%H%M%S")
                temp_folder_path = os.path.join("/application/LogDumps/", temp_folder_name)
                os.makedirs(temp_folder_path)

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

            # Rest of your cleanup code goes here...

        except Exception as ex:
            self.SystemException = "Cleanup Script failed. Please look into it."
            raise Exception(f"error:", str(ex))
