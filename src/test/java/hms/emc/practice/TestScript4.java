package hms.emc.practice;

import java.util.Map;
import org.testng.annotations.Test;
import com.tyss.genericUtilities.Enums.ExcelSheet;
import hms.eMedCure.ObjectRepository.Doctor.DoctorDashboardTabNames;
import hms.eMedCure.ObjectRepository.User.userDashboardTabnames;

public class TestScript4 extends testNGPractice
{
	@Test
	public void UserRegistrationBookingAppointmentDoctorCancellingAppointmentTest()
	{
		String sheetName = ExcelSheet.TESTDATA.getSheetName();
		Map<String, String> map = excelutility.getData(sheetName, "UserBookingAppointmentDoctorCancellingAppointmentTest1");
		homepage.userLoginClick();
		userloginpage.createAnAccountAction();
		String usermailid = map.get("email")+javautility.getRandomNumber(100)+"@gmail.com";
		patientregistrationpage.patientRegistrationAction(excelutility.getData("TestData", "UserBookingAppointmentDoctorCancellingAppointmentTest"), usermailid);
		popuputility.acceptAlert(driver);
		patientregistrationpage.patientLogin();
		userloginpage.userLoginAction(userusername, userpassword);
		userdashboardpage.clickUserDashboardTab(userDashboardTabnames.BOOKAPPOINTMENT);
		bookappointment.BookAppointmentAction(dropdown, map.get("doctorSpecialisation"), 1);
		popuputility.acceptAlert(driver);
		userlogoutpage.UserLogoutAction();
		homepage.doctorLoginClick();
		doctorloginpage.DoctorLoginAction(doctorusername, doctorpassword);		
		doctordashboardpage.clickUserDashboardTab(DoctorDashboardTabNames.APPOINTMENTHISTORY);
		appointmenthistorypage.cancelAppointmentAction();
		popuputility.acceptAlert(driver);
	}
}
