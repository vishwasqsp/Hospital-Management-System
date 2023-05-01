package hms.emc.doctor;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtilities.Enums.ExcelSheet;
import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;


import hms.eMedCure.ObjectRepository.User.userDashboardTabnames;
import hms.eMedCure.ObjectRepository.adminDashboardTabNames.AdminDasboardTabNames;


public class AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest extends AnnotationConfiguration{

	@Report(author = "Vishwas")
	@Test(groups = "regression")
	public void addingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest()
	{
		//to fetch data from excel
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest");
		String sheetNames = ExcelSheet.VERIFICATION.getSheetName();
		Map<String, String> maps = excelutility.getData(sheetNames, "AddingDoctorUserBookingAppointmentDeleteDoctorLoginAsDoctorTest");
		
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		
		homepage.adminLoginClick();
		Assert.assertEquals(adminlogin.AdminLoginPageVerify(), maps.get("adminLogin"), "adminloginpage");
		//admin login page
		adminlogin.AdminLoginAction(adminusername, adminpassword);
		Assert.assertEquals(admindashboard.adminDashboardVerification(), maps.get("adminDashboard"), "admindashboard");
		//click on Doctor
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORSPECIALIZATION);
		Assert.assertEquals(adddoctorspecialisation.AddDoctorSpecialisationPageVerification(), maps.get("addDoctorSpecialisation"));
		adddoctorspecialisation.AddDoctorSpecialization(map.get("doctorSpecialisation"));
		Assert.assertEquals(adddoctorspecialisation.DoctorSpecialisationPAddedOrNotVerification(), maps.get("addingDoctorSpecialisation"));
		
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.ADDDOCTOR);
		Assert.assertEquals(adddoctor.addDoctorPageVerification(), maps.get("addDoctorPage"));
		String doctoremail = map.get("doctorEmail")+javautility.getRandomNumber(100)+"@gmail.com";
		adddoctor.AddDoctorAction(dropdown, map.get("doctorSpecialisation"), map.get("doctorName"), map.get("doctorAddress"), map.get("doctorFees"), map.get("doctorContact"), doctoremail, map.get("doctorPassword"), map.get("doctorConfirmPassword"));	
		popuputility.acceptAlert(driver);
		
		adminlogoutpage.AdminLogoutAction();
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		homepage.userLoginClick();
		Assert.assertEquals(userloginpage.userLoginPageVerification(), maps.get("userLoginPage"));
		userloginpage.userLoginAction(userusername, userpassword);
		Assert.assertEquals(userdashboardpage.userDashboardPageVerification(), maps.get("userDashBoard"));
		userdashboardpage.clickUserDashboardTab(userDashboardTabnames.BOOKAPPOINTMENT);
		Assert.assertEquals(bookappointmentpage.bookAppointmentPageVerification(), maps.get("bookAppointmentPage"));
		
		bookappointmentpage.BookAppointmentAction(dropdown, map.get("doctorSpecialisation"), 1);
		popuputility.acceptAlert(driver);
		userlogoutpage.UserLogoutAction();
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		homepage.adminLoginClick();
		Assert.assertEquals(adminlogin.AdminLoginPageVerify(), maps.get("adminLogin"), "adminloginpage");
		adminlogin.AdminLoginAction(adminusername, adminpassword);
		Assert.assertEquals(admindashboard.adminDashboardVerification(), maps.get("adminDashboard"), "admindashboard");
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		Assert.assertEquals(managedoctorpage.manageDoctorsPageVerification(), maps.get("manageDoctorsPage"));
		managedoctorpage.deleteDoctorAction();
		popuputility.acceptAlert(driver);
		Assert.assertEquals(managedoctorpage.deleteDoctorsVerification(), maps.get("deleteDoctorMessage"));
		adminlogoutpage.AdminLogoutAction();
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		homepage.doctorLoginClick();
		Assert.assertEquals(doctorloginpage.doctorLoginPageVerification(), maps.get("doctorLoginPage"));
		doctorloginpage.DoctorLoginAction(doctoremail, doctorpassword);
		Assert.assertEquals(doctorloginpage.doctorLoginPageInvalidUnPwd(), maps.get("loginErrorMessage"));
	}

}
