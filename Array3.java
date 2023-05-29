    def getDriver(self,obj):
        
        options=Options()
        download_dir=r"D:/RPA/Prerna/Investor Rules/TEMP/DOWNLOADS/TEMP/PDF_DOWNLOADS"
        # Incomecalc_SSO_ext_filepath = r"/application/RPA/Service_Order_Inflight/REQUIRED/QAbot1_chromeextension.crx"

        prefs={"download.default_directory": download_dir, "download.prompt_for_download": False,"download.directory_upgrade": True,"safebrowsing.enabled": True}
        
        options.add_extension(r"D:\RPA\Prerna\Extentions.crx")
       	########ENABLE back on PROD
       	#options.add_experimental_option("prefs", prefs)
        #options.add_argument("--headless")
        #options.add_argument("--no--sandbox")
        options.add_argument("--start-maximized")
        options.add_argument("---printing")
        # options.add_experimental_option("detach", True)
        if obj.config['disable_shm_usage']=='True':
            options.add_argument("--disable-dev-shm-usage")
            obj.printlog.info("Usage of Shared Memory: DISABLED")
        self.options=options
        self.driver=webdriver.Chrome(options=options) 
        self.driver.command_executor._commands["send_command"] = ("POST", '/session/$sessionId/chromium/send_command')
        params = {'cmd':'Page.setDownloadBehavior', 'params': {'behavior': 'allow', 'downloadPath': download_dir}}
        self.driver.execute("send_command", params)
