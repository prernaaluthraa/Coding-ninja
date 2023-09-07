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
