package hms.emc.practice;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameters;
import com.tyss.genericUtilities.VerificationUtility;
import com.tyss.genericUtilities.Enums.ExcelSheet.PropertyKey;
import com.tyss.genericUtilities.WebActions.DropdownUtility;
import com.tyss.genericUtilities.WebActions.PopupUtility;
import com.tyss.genericUtilities.WebActions.SeleniumUtility;
import com.tyss.genericUtilities.WebActions.SwitchWindowUtility;
import com.tyss.genericUtilities.WebActions.WaitUtility;
import com.tyss.genericUtilities.externalFileUtility.Excelutility;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;
import com.tyss.genericUtilities.frameworkConstant.FrameworkConstant;
import com.tyss.genericUtilities.javaUtility.JavaUtility;
import com.tyss.genericUtilities.reportUtility.ReportUtility;

import Listener.ExtentReportListener;
import hms.eMedCure.ObjectRepository.Admin.AddDoctor;
import hms.eMedCure.ObjectRepository.Admin.AddDoctorSpecialization;
import hms.eMedCure.ObjectRepository.Admin.AdminDashboard;
import hms.eMedCure.ObjectRepository.Admin.AdminLogin;
import hms.eMedCure.ObjectRepository.Admin.AdminLogoutPage;
import hms.eMedCure.ObjectRepository.Admin.EditDoctor;
import hms.eMedCure.ObjectRepository.Admin.ManageDoctorPage;
import hms.eMedCure.ObjectRepository.Doctor.AddMedicalHistoryPage;
import hms.eMedCure.ObjectRepository.Doctor.AddPatientPage;
import hms.eMedCure.ObjectRepository.Doctor.AppointmentHistoryPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLoginPage;
import hms.eMedCure.ObjectRepository.Doctor.DoctorLogoutPage;
import hms.eMedCure.ObjectRepository.Doctor.ManagePatientPage;
import hms.eMedCure.ObjectRepository.User.BookAppointmentPage;
import hms.eMedCure.ObjectRepository.User.PatientRegistrationPage;
import hms.eMedCure.ObjectRepository.User.UserLoginPage;
import hms.eMedCure.ObjectRepository.User.UserLogoutPage;
import hms.eMedCure.ObjectRepository.User.userDashboardPage;
import hms.eMedCure.ObjectRepository.homePage.HomePage;

public class testNGPractice 
{

	protected PropertyUtility propertyutility;
	protected Excelutility excelutility;
	public SeleniumUtility seleniumutility;
	public JavaUtility javautility;
	protected VerificationUtility verificationutility;
	protected DropdownUtility dropdown;
	protected PopupUtility popuputility;
	protected SwitchWindowUtility switchwindowutility;
	public ExtentTest test;
	protected ReportUtility report;
	protected WebDriver driver;
	protected WaitUtility waitutility;
	protected String adminusername;
	protected String adminpassword;
	protected String userusername;
	protected String userpassword;
	protected String doctorusername;
	protected String doctorpassword;
	protected AddDoctorSpecialization adddoctorspecialization;
	protected AdminLogin adminlogin;
	protected HomePage homepage;
	protected AdminDashboard admindashboard;
	protected AddDoctorSpecialization adddoctorspecialisation;
	protected AddDoctor adddoctor;
	protected EditDoctor editdoctor;
	protected ManageDoctorPage managedoctorpage;
	protected AdminLogoutPage adminlogoutpage;
	protected userDashboardPage userdashboardpage;
	protected UserLoginPage userloginpage;
	protected DoctorLoginPage doctorloginpage;
	protected BookAppointmentPage bookappointmentpage;
	protected UserLogoutPage userlogoutpage;
	protected DoctorLogoutPage doctorlogoutpage;
	protected BookAppointmentPage bookappointment;
	protected AppointmentHistoryPage appointmenthistorypage;
	protected PatientRegistrationPage patientregistrationpage;
	protected ManagePatientPage managepatientpage;
	protected DoctorDashboardPage doctordashboardpage;
	protected AddPatientPage addpatientpage;
	protected AddMedicalHistoryPage addmedicalhistorypage;
	
	//@Parameters(value = "browser")
	@BeforeClass
	public void ImplementationSetup(@Optional String browser)
	{
		report = ExtentReportListener.sreport;
		propertyutility = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		excelutility = new Excelutility(FrameworkConstant.TEST_EXCEL_FILE_PATH);
		seleniumutility = new SeleniumUtility();
		javautility = new JavaUtility();
		verificationutility = new VerificationUtility();
		dropdown = new DropdownUtility();
		popuputility = new PopupUtility();
		switchwindowutility = new SwitchWindowUtility();
		adminusername = javautility.decode(propertyutility.getPropertyData(PropertyKey.ADMINUSERNAME));
		adminpassword = javautility.decode(propertyutility.getPropertyData(PropertyKey.ADMINPASSWORD));
		userusername = propertyutility.getPropertyData(PropertyKey.USERUSERNAME);
		userpassword = propertyutility.getPropertyData(PropertyKey.USERPASSWORD);
		doctorusername = propertyutility.getPropertyData(PropertyKey.DOCTORUSERNAME);
		doctorpassword = propertyutility.getPropertyData(PropertyKey.DOCTORPASSWORD);
	}
	@BeforeMethod
		public void setup()
		{
			driver = seleniumutility.launchBrowser(propertyutility.getPropertyData(PropertyKey.BROWSER));
			long timeout = Long.parseLong(propertyutility.getPropertyData(PropertyKey.TIMEUNIT));
			waitutility = new WaitUtility(driver, timeout);	
			seleniumutility.maximizeBrowser();
			String url = propertyutility.getPropertyData(PropertyKey.URL);
			seleniumutility.applicationUrl(url);
			waitutility.WaitForElementTOLoad(driver, timeout);
			adddoctorspecialization = new AddDoctorSpecialization(driver);
			adminlogin = new AdminLogin(driver);
			homepage = new HomePage(driver);
			admindashboard = new AdminDashboard(driver);
			adddoctorspecialisation = new AddDoctorSpecialization(driver);
			adddoctor = new AddDoctor(driver);
			editdoctor = new EditDoctor(driver);
			managedoctorpage = new ManageDoctorPage(driver);
			adminlogoutpage = new AdminLogoutPage(driver);
			userloginpage = new UserLoginPage(driver);
			userdashboardpage = new userDashboardPage(driver);
			bookappointmentpage = new BookAppointmentPage(driver);
			userlogoutpage = new UserLogoutPage(driver);
			doctorloginpage = new DoctorLoginPage(driver);
			doctorlogoutpage = new DoctorLogoutPage(driver);
			doctordashboardpage = new DoctorDashboardPage(driver);
			addpatientpage = new AddPatientPage(driver);
			managepatientpage = new ManagePatientPage(driver);
			addmedicalhistorypage = new AddMedicalHistoryPage(driver);
			patientregistrationpage = new PatientRegistrationPage(driver);
			bookappointment = new BookAppointmentPage(driver);
			appointmenthistorypage = new AppointmentHistoryPage(driver);	
		}
	
//		@AfterMethod
//		public void close()
//		{
//			seleniumutility.closeBrowser();
//		}
		@AfterClass
		public void ImplementationTearDown()
		{
			try {
				excelutility.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


