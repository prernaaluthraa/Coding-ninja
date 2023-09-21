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
            temp_folder_name = "OldLogDump_" + time.strftime("%d%m%Y-%H%M%S")
            temp_folder_path = os.path.join("/application/LogDumps/", temp_folder_name)
            os.makedirs(temp_folder_path)

            # Check and delete zip folders older than 7 days
            seven_days_ago = time.time() - (7 * 24 * 60 * 60)
            for root, dirs, files in os.walk("/application/LogDumps/"):
                for item in os.listdir(root):
                    item_path = os.path.join(root, item)
                    if os.path.isfile(item_path):
                        # Check if it's a file and older than 7 days
                        item_mtime = os.path.getmtime(item_path)
                        if item_mtime < seven_days_ago:
                            os.remove(item_path)
                    elif os.path.isdir(item_path):
                        # Check if it's a directory and older than 7 days
                        item_mtime = os.path.getmtime(item_path)
                        if item_mtime < seven_days_ago:
                            # Delete files within the directory
                            for file in os.listdir(item_path):
                                file_path = os.path.join(item_path, file)
                                if os.path.isfile(file_path):
                                    os.remove(file_path)
                            # Delete the directory itself
                            os.rmdir(item_path)

            # Rest of your cleanup code goes here...

        except Exception as ex:
            self.SystemException = "Cleanup Script failed. Please look into it."
            raise Exception(f"error:", str(ex))
