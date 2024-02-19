    def cleanup(obj):
        try:

            rpa_path = "/application/RPA"
            folders_to_check = ["LOGS", "SCREENSHOTS", "ARCHIVE", "OUT", "TEMP"]
            time_period = time.time() - (float(obj.config['days']) * 24 * 60 * 60)
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


                used_before = total_before - free_before

                # Convert sizes to human-readable format
                used_before_str = f"{used_before / (1024 ** 3):.2f} GB"
                # Print disk storage information before running the script
                csvwriter.writerow(["Disk Storage Before Script Execution"])
                csvwriter.writerow(["Total", total_before_str])
                csvwriter.writerow(["Used", used_before_str])
                csvwriter.writerow(["Free", free_before_str])
                csvwriter.writerow([])  # Empty row for separation

                temp_folder_name = "OldLogDump_" + time.strftime("%d%m%Y-%H%M%S")
                temp_folder_path = os.path.join("/application/LogDumps/", temp_folder_name)
                os.makedirs(temp_folder_path)
                # Check and delete zip folders older than 7 days
                for root, dirs, files in os.walk("/application/LogDumps/"):
                    print("going through log dumps folder")
                    csvwriter.writerow(["going through log dumps folder"])
                    for item in os.listdir(root):
                        print("checking in directory")
                        csvwriter.writerow(["checking in directory"])
                        item_path = os.path.join(root, item)
                        if os.path.isfile(item_path):
                            # Check if it's a file and older than 7 days
                            csvwriter.writerow(["Check if it's a file and older than 7 days"])
                            item_mtime = os.path.getmtime(item_path)
                            if item_mtime < seven_days_ago:
                                csvwriter.writerow(["deleting zip folder older than 7 days"])
                                os.remove(item_path)
                        elif os.path.isdir(item_path):
                            # Check if it's a directory and older than 7 days
                            item_mtime = os.path.getmtime(item_path)
                            if item_mtime < seven_days_ago:
                                # Delete files within the directory
                                csvwriter.writerow(["deleting zip folder older than 7 days"])
                                for file in os.listdir(item_path):
                                    file_path = os.path.join(item_path, file)
                                    if os.path.isfile(file_path):
                                        os.remove(file_path)
                                # Delete the directory itself
                                os.rmdir(item_path)


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
                return total_before_str, used_before_str, free_before_str
        except Exception as ex:
            obj.SystemException = "Cleanup Script failed. Please look into it."
            raise Exception(f"error:", str(ex))
                

def cleanup(obj):
    try:
        rpa_path = "/application/RPA"
        common_path = "/application/RPA/COMMON"
        ocr_path = "/application/RPA/COMMON/OCR"
        # ... (rest of the code remains unchanged)

        # Move files in the OCR folder
        for root, dirs, files in os.walk(rpa_path):
            if common_path in root and root != ocr_path:
                # Skip folders under /application/RPA/COMMON except /application/RPA/COMMON/OCR
                continue

            for folder_name in folders_to_check:
                folder_path = os.path.join(root, folder_name)
                csvwriter.writerow(["Checking", folder_path, ""])

                if folder_name == "LOGS":
   
