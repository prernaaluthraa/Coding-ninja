# Check files in the "deleted_files" folder
for folder in os.listdir(temp_folder_path):
    folder_path = os.path.join(temp_folder_path, folder)
    if os.path.isdir(folder_path) and os.path.getmtime(folder_path) < seven_days_ago:
        # Extract files from the ZIP folder
        shutil.unpack_archive(folder_path, temp_folder_path)
        
        # Delete files in the extracted folder
        for root, dirs, files in os.walk(temp_folder_path):
            for file in files:
                file_path = os.path.abspath(os.path.join(root, file))
                if os.path.isfile(file_path):
                    csvwriter.writerow(["Deleting file", file_path, ""])
                    os.remove(file_path)
        
        # Delete the extracted folder
        shutil.rmtree(folder_path)
