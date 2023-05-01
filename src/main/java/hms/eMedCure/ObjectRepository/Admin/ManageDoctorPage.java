package hms.eMedCure.ObjectRepository.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtilities.WebActions.DropdownUtility;
import com.tyss.genericUtilities.WebActions.WaitUtility;

public class ManageDoctorPage 
{
	//declartion
			@FindBy(xpath = "(//i[@class = 'fa fa-times fa fa-white'])[last()]") private WebElement deleteDoctorIcon;
			@FindBy(xpath = "(//i[@class = 'fa fa-pencil'])[last()]") private WebElement editDoctorIcon;
			@FindBy(xpath = "(//h1[. = 'Admin | Manage Doctors'])") private WebElement manageDoctorPageVerify;
			@FindBy(xpath = "(//p[. = 'data deleted !!								'])") private WebElement deleteDoctorMessage;
			
			//initialization
			public ManageDoctorPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//utilization
			public void deleteDoctorAction()
			{
				deleteDoctorIcon.click();
			}
			public void editDoctorAction()
			{
				editDoctorIcon.click();
			}
			public String manageDoctorsPageVerification()
			{
				return manageDoctorPageVerify.getText();
			}
			public String deleteDoctorsVerification()
			{
				return deleteDoctorMessage.getText();
			}
}
