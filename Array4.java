import zipfile

# Check folders in the "deleted_files" folder
for folder in os.listdir(temp_folder_path):
    folder_path = os.path.join(temp_folder_path, folder)
    if os.path.isdir(folder_path):
        folder_mtime = os.path.getmtime(folder_path)
        if folder_mtime < seven_days_ago:
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
