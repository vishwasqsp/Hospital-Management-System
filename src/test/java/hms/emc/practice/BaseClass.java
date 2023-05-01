//package hms.emc.practice;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//
//public class BaseClass 
//{
//	protected PropertyUtility propertyUtils; 
//	protected ExcelUtilities excelUtils;
//
//	public WebDriverUtilities webDriverUtils; 
//	protected VerificationUtility verificationUtils;
//	public JavaUtility javaUtils;
//	protected DropDownUtility dropDownUtils;
//	protected PopUpUtilities popUpUtils;
//	protected JavaScriptUtilites javaScriptUtils;
//	public WebDriver driver;
//	protected long timeUnit;
//	protected String url;
//	protected String browser;
//	public TakesScreenshotUtility takesScreenshotUtils;
//	protected WaitsUtility waitUtils;
//	protected LoginPage loginPage;
//	protected Hospital_Management_SystemPage hmsHomePage;
//	protected RegistrationPage registrationPage;
//	protected UserCommonPage userCommonPage;
//	protected BookAppointmentPage bookAppointmentPage; 
//	protected DoctorAppointmentHistoryPage doctorAppointmentHistoryPage;
//	protected String doctorUsername;
//	protected String doctorPassword;
//	protected String adminUsername;
//	protected String adminPassword;
//	protected String userUsername;
//	protected String userPassword;
//	protected DoctorCommonPage doctorCommonPage;
//	protected AdminCommonPage adminCommonPage;
//	protected AddDoctorPage addDoctorPage;
//	protected ManageDoctorPage manageDoctorPage;
//	protected AddDoctorSpecializationPage addDoctorSpecializationPage;
//	protected AddPatientPage addPatientPage;
//	protected ManagePatientsPage managePatientsPage;
//	protected AddMedicalHistoryPage addMedicalHistoryPage;
//	protected AdminAppointmentHistoryPage adminAppointmentHistoryPage;
//	protected SoftAssert softassert;
//	
//	public ExtentTest test;
//	protected ReportUtility report;
//
//	
//	@Parameters(value="browser")
//	@BeforeClass(alwaysRun=true)
//	public void initializationSetup(@Optional String browser) {
//		report=ExtentReportListener.sreport;
//		propertyUtils= new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
//		excelUtils = new ExcelUtilities(FrameworkConstants.TEST_EXCEL_FILE_PATH);
//
//		webDriverUtils=new WebDriverUtilities();
//		verificationUtils = new VerificationUtility();
//		javaUtils= new JavaUtility();
//		dropDownUtils=new DropDownUtility();
//		popUpUtils = new PopUpUtilities();
//		
//		if(browser==null || browser.isEmpty() ||browser.isBlank() || browser.equals("")) {
//			browser = propertyUtils.getPropertyData(PropertyKey.BROWSER);
//		}
//		this.browser=browser;
//		
//		url = propertyUtils.getPropertyData(PropertyKey.URL);
//		timeUnit = Long.parseLong(propertyUtils.getPropertyData(PropertyKey.TIMEUNIT));
//		userUsername = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.USERUSERNAME));
//		userPassword = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.USERPASSWORD));
//		doctorUsername = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.DOCTORUSERNAME));
//		doctorPassword = javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.DOCTORPASSWORD));
//		adminUsername =javaUtils.decode(propertyUtils.getPropertyData(PropertyKey.ADMINUSERNAME));
//		adminPassword =javaUtils.decode( propertyUtils.getPropertyData(PropertyKey.ADMINPASSWORD));
//
//	}
//
//	@BeforeMethod(alwaysRun=true)
//	public void setUp() {
//		driver = webDriverUtils.launchApplication(browser);
//		webDriverUtils.maximizeBrowser();
//		webDriverUtils.getUrl(url);
//		waitUtils = new WaitsUtility(driver);
//		waitUtils.waitForPageLod(timeUnit);
//		takesScreenshotUtils = new TakesScreenshotUtility(driver);
//		javaScriptUtils = new JavaScriptUtilites(driver);
//
//		softassert= new SoftAssert();
//
//		loginPage=new LoginPage(driver);
//		hmsHomePage= new Hospital_Management_SystemPage(driver);
//		registrationPage= new RegistrationPage(driver);
//		userCommonPage= new UserCommonPage(driver);
//		bookAppointmentPage = new BookAppointmentPage(driver);
//		doctorAppointmentHistoryPage = new DoctorAppointmentHistoryPage(driver);
//		doctorCommonPage= new DoctorCommonPage(driver);
//		adminCommonPage= new AdminCommonPage(driver);
//		addDoctorPage = new AddDoctorPage(driver);
//		manageDoctorPage= new ManageDoctorPage(driver);
//		addDoctorSpecializationPage= new AddDoctorSpecializationPage(driver);
//		addPatientPage= new AddPatientPage(driver);
//		managePatientsPage = new ManagePatientsPage(driver);
//		addMedicalHistoryPage = new AddMedicalHistoryPage(driver);
//		adminAppointmentHistoryPage = new AdminAppointmentHistoryPage(driver);
//
//	}
//
//	@AfterMethod(alwaysRun=true)
//	public void tearDown() {
//		webDriverUtils.closeApplication();
//	}
//
//	@AfterClass(alwaysRun=true)
//	public void initializationTearDown() {
//		excelUtils.close();
//	}
//
//}
//}
