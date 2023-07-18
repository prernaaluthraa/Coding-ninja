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
