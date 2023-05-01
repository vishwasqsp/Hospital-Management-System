package hms.emc.admin;





import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtilities.Enums.ExcelSheet;
import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;
import hms.eMedCure.ObjectRepository.adminDashboardTabNames.AdminDasboardTabNames;





public class AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest extends AnnotationConfiguration {
	
	@Report(author = "Vishwas")
	@Test()
	public void addingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest()
	{
		
		
		//to fetch data from excel
		
		String sheetNames = ExcelSheet.VERIFICATION.getSheetName();
		Map<String, String> maps = excelutility.getData(sheetNames, "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest");
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "AddingDoctorSpecialisationDoctorEDitDoctorDeleteDoctorTest");
		
	
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		//launching application and passing url
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
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		
		
		
		
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		Assert.assertEquals(managedoctorpage.manageDoctorsPageVerification(), maps.get("manageDoctorsPage"));
		
		
		managedoctorpage.editDoctorAction();
		Assert.assertEquals(editdoctor.EditDoctorPageVerification(), maps.get("editDoctorDetailsPage"));
		editdoctor.EditDoctorAction(map.get("editDoctorName"), map.get("editDoctorFees"), map.get("editDoctorAddress"), map.get("editDoctorContact"));
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.DOCTORS);
		admindashboard.clickAdminDashboardTab(AdminDasboardTabNames.MANAGEDOCTORS);
		Assert.assertEquals(managedoctorpage.manageDoctorsPageVerification(), maps.get("manageDoctorsPage"));
		managedoctorpage.deleteDoctorAction();
		popuputility.acceptAlert(driver);
		Assert.assertEquals(managedoctorpage.deleteDoctorsVerification(), maps.get("deleteDoctorMessage"));
		
		adminlogoutpage.AdminLogoutAction();
		Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
	}
		
}
