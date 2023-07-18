    if inputFilename is None:
        msg['Subject']="INFO: "+obj.config['BU']+"-"+obj.config['PROCESSNAME']+": No loans"
        BODY=obj.config['ExchEmailBodyNoLoans']
    else:
        msg['Subject']=obj.config['BU']+"-"+obj.config['PROCESSNAME']+": Input File Notification "+str(obj.metrics.StartTime)[:-7].replace("-","/")
        BODY=obj.config['ExchEmailBodyInput'].replace('AAAAA',str(inputFilename.split('/')[-1]))
        with open(inputFilename,'rb') as atch:
            part=MIMEApplication(atch.read(),Name=inputFilename)
        part['Content-Disposition']='attachment;filename="{}"'.format(inputFilename.split('/')[-1])
        msg.attach(part)
