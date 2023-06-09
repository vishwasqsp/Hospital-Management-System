package hms.eMedCure.ObjectRepository.Doctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage 
{
	//declartion
	@FindBy(name = "username") private WebElement doctorUsernameTextfield;
	@FindBy(name = "password") private WebElement doctorPasswordTextfield;
	@FindBy(name = "submit") private WebElement doctorLoginButton;
	@FindBy(xpath = "//h2[. = ' HMS | Doctor Login']") private WebElement doctorLoginPageVerify;
	@FindBy(xpath = "//span[. = 'Invalid username or password']") private WebElement doctorLoginPageInvalidUnPwd;
	
	//initialization
	public DoctorLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void DoctorLoginAction(String username, String password)
	{
		doctorUsernameTextfield.sendKeys(username);
		doctorPasswordTextfield.sendKeys(password);
		doctorLoginButton.click();
	}
	public String doctorLoginPageVerification()
	{
		return doctorLoginPageVerify.getText();
	}
	public String doctorLoginPageInvalidUnPwd()
	{
		return doctorLoginPageInvalidUnPwd.getText();
	}
}
