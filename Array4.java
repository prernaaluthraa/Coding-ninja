import os
import time
import csv
import shutil
import uuid

def cleanup(obj):
    try:
        rpa_path = "/application/RPA"
        folders_to_check = ["LOGS", "SCREENSHOTS", "ARCHIVE", "OUT"]
        three_days_ago = time.time() - (90 * 24 * 60 * 60)
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

            # Create a temporary folder with a unique identifier appended to the name
            temp_folder_name = "temp_" + time.strftime("%Y%m%d-%H%M%S") + "_" + str(uuid.uuid4())
            temp_folder_path = os.path.join("/application/RPA/COMMON/CleanupFiles/DeletedFiles", temp_folder_name)
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
                    # Delete the folder
                    shutil.rmtree(folder_path)

            # Continue with the existing code to move files older than 90 days
            for root, dirs, files in os.walk(rpa_path):
                for folder_name in folders_to_check:
                    if folder_name in dirs:
                        folder_path = os.path.join(root, folder_name)
                        csvwriter.writerow(["Checking", folder_path, ""])

                        # Move the files to the temporary folder instead of deleting
                        for filename in os.listdir(folder_path):
                            file_path = os.path.join(folder_path, filename)
                            if os.path.isfile(file_path) and os.path.getmtime(file_path) < three_days_ago:
                                mod_time = os.path.getmtime(file_path)
                                mod_date = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(mod_time))
                                
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

    except Exception as ex:
        obj.SystemException = "Cleanup Script failed. Please look into it."
        raise Exception("Error:", str(ex))
