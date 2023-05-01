package hms.emc.doctor;


import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tyss.genericUtilities.Enums.ExcelSheet;
import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardTabNames;




public class DoctorAddingMedicalHistoryTest extends AnnotationConfiguration {

	@Report(author = "Vishwas")
	@Test(groups = "regression")
	public void doctorAddingMedicalHistoryTest()
	{
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "DoctorAddingMedicalHistoryTest");
		String sheetNames = ExcelSheet.VERIFICATION.getSheetName();
		Map<String, String> maps = excelutility.getData(sheetNames, "DoctorAddingMedicalHistoryTest");
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"));
		//Assert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"), "homepage");
		
		
		homepage.doctorLoginClick();
		//Assert.assertEquals(doctorloginpage.doctorLoginPageVerification(), maps.get("doctorLoginPage"));
		softassert.assertEquals(doctorloginpage.doctorLoginPageVerification(), maps.get("doctorLoginPage"));
		
		doctorloginpage.DoctorLoginAction(doctorusername, doctorpassword);
		//Assert.assertEquals(doctordashboardpage.doctorDashboardPageVerification(), maps.get("doctorDashboard"));
		softassert.assertEquals(doctordashboardpage.doctorDashboardPageVerification(), maps.get("doctorDashboard"));
		
		
		
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.APPOINTMENTHISTORY);
		//Assert.assertEquals(appointmenthistorypage.appointmentHistoryPageVerification(), maps.get("doctorAppointmentHistotry"));
		softassert.assertEquals(appointmenthistorypage.appointmentHistoryPageVerification(), maps.get("doctorAppointmentHistotry"));
		
		
		String name = driver.findElement(By.xpath("//td[. = 'harshitha']")).getText();
		String ExpectedUser = name;
		if(name.contains(ExpectedUser))
		{
			System.out.println("User Booked an Appointment");
		}
		else
		{
			System.out.println("User not Booked an Appointment");
		}
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.PATIENTS);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.ADDPATIENT);
		//Assert.assertEquals(addpatientpage.addPatientPageVerification(), maps.get("addPatientPage"));
		softassert.assertEquals(addpatientpage.addPatientPageVerification(), maps.get("addPatientPage"));
		
		String patientemail = map.get("patemail")+javautility.getRandomNumber(100)+"@gmail.com";
		addpatientpage.addPatientAction(excelutility.getData("TestData", "DoctorAddingMedicalHistoryTest1"), patientemail);
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.PATIENTS);
		
		
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.MANAGEPATIENTS);
		//Assert.assertEquals(managepatientpage.managePatientsPageVerification(), maps.get("managePatientPage"));
		softassert.assertEquals(managepatientpage.managePatientsPageVerification(), maps.get("managePatientPage"));
		
		managepatientpage.viewPatientAction();
		
		
		managepatientpage.addMedicalHistoryAction();
		softassert.assertEquals(addmedicalhistorypage.addMedicalHistoryPageVerification(), maps.get("addMedicalHistoryPopup"));
		addmedicalhistorypage.addMedicalHistoryAction(excelutility.getData("TestData", "PatientMedicalHistory"));
		popuputility.acceptAlert(driver);
		doctorlogoutpage.doctorLogoutAction();
		softassert.assertEquals(homepage.homePageVerification(), maps.get("homePageName"));
	}

}
