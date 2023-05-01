package hms.eMedCure.ObjectRepository.Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistoryPage 
{
	//declartion
		@FindBy(xpath = "(//a[@title = 'Cancel Appointment'])[last()]") private WebElement cancelAppointmentButton;
		@FindBy(xpath = "//h1[. = 'Doctor  | Appointment History']") private WebElement appointmentHistoryPageVerify;
		//initialization
		public AppointmentHistoryPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void cancelAppointmentAction()
		{
			cancelAppointmentButton.click();
		}
		public String appointmentHistoryPageVerification()
		{
			return appointmentHistoryPageVerify.getText();
		}
}
