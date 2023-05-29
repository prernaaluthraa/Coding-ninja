DevTools listening on ws://127.0.0.1:53767/devtools/browser/4a25360f-5176-4454-917a-6f9ff0481a2c
Traceback (most recent call last):
  File "D:\RPA\Prerna\Investor Rules\Finalmain.py", line 178, in main
    ib.initApplications(obj)
  File "D:\RPA\Prerna\Investor Rules\Framework\InitBlock.py", line 20, in initApplications
    bkfs.Login(obj)
  File "D:\RPA\Prerna\Investor Rules\Framework\BKFSLogin.py", line 38, in Login
    obj.getDriver(obj)
  File "D:\RPA\Prerna\Investor Rules\Finalmain.py", line 105, in getDriver
    self.driver=webdriver.Chrome(options=options)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\chrome\webdriver.py", line 84, in __init__
    super().__init__(
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\chromium\webdriver.py", line 104, in __init__
    super().__init__(
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\remote\webdriver.py", line 286, in __init__
    self.start_session(capabilities, browser_profile)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\remote\webdriver.py", line 378, in start_session
    response = self.execute(Command.NEW_SESSION, parameters)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\remote\webdriver.py", line 440, in execute
    self.error_handler.check_response(response)
  File "C:\Users\luthrapr\AppData\Roaming\Python\Python39\site-packages\selenium\webdriver\remote\errorhandler.py", line 245, in check_response
    raise exception_class(message, screen, stacktrace)
selenium.common.exceptions.WebDriverException: Message: unknown error: failed to wait for extension background page to load: chrome-extension://mjhbphggpjjdhejhkcpehfegckjljllj/_generated_background_page.html
from unknown error: page could not be found: chrome-extension://mjhbphggpjjdhejhkcpehfegckjljllj/_generated_background_page.html


    def getDriver(self,obj):
        
        options=Options()
        download_dir=r"D:/RPA/Prerna/Investor Rules/TEMP/DOWNLOADS/TEMP/PDF_DOWNLOADS"
        # Incomecalc_SSO_ext_filepath = r"/application/RPA/Service_Order_Inflight/REQUIRED/QAbot1_chromeextension.crx"

        prefs={"download.default_directory": download_dir, "download.prompt_for_download": False,"download.directory_upgrade": True,"safebrowsing.enabled": True}
        options.add_extension(r"D:\RPA\Prerna\Extentions.crx")
       	########ENABLE back on PROD
       	options.add_experimental_option("prefs", prefs)
        options.add_argument("--headless")
        options.add_argument("--no--sandbox")
        options.add_argument("--start-maximized")
        # options.add_argument("---printing")
        options.add_experimental_option("detach", True)
        if obj.config['disable_shm_usage']=='True':
            options.add_argument("--disable-dev-shm-usage")
            obj.printlog.info("Usage of Shared Memory: DISABLED")
        self.options=options
        self.driver=webdriver.Chrome(options=options) 
        self.driver.command_executor._commands["send_command"] = ("POST", '/session/$sessionId/chromium/send_command')
        params = {'cmd':'Page.setDownloadBehavior', 'params': {'behavior': 'allow', 'downloadPath': download_dir}}
        self.driver.execute("send_command", params)

def Login(obj):
    driver=obj.driver
    count=1
    MAX_COUNT=int(str(obj.config['MaxRetryNumber']))
    # companyCode=str(obj.config['companyCode']).strip() 
   
    BKFS_Creds=obj.get_password(obj.config['asset_bkfs'])
  


    loanSphereURL=str(obj.config['BKFS_SEARCHURL']).strip()    
    logSuccess=False
    invalidCreds=False
    credsExpired=False
    obj.printlog.info("Entering into BKFS Portal")
    while(count<= MAX_COUNT):

        driver=obj.driver
        try:
            driver.close()
        except:
            pass
        finally:
            obj.getDriver(obj)
            driver=obj.driver
