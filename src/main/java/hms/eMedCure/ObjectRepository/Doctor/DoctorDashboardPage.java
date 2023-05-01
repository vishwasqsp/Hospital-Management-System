package hms.eMedCure.ObjectRepository.Doctor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DoctorDashboardPage 
{
	private WebDriver driver;
	//declartion
	private String doctorDashboardPartialXpath = "//span[. = '%s']";
	@FindBy(xpath = "//h1[. = 'Doctor | Dashboard']") private WebElement doctorDashboardPageVerify;
	
		
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
		
		//initialization
		public DoctorDashboardPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void clickUserDashboardTab(DoctorDashboardTabNames tabNames)
		{
			convertToWebElement(doctorDashboardPartialXpath, tabNames.getTab()).click();
		}
		public String doctorDashboardPageVerification()
		{
			return doctorDashboardPageVerify.getText();
		}
}
