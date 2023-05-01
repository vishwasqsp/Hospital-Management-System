package com.tyss.genericUtilities.WebActions;

import org.openqa.selenium.WebDriver;

import com.tyss.genericUtilities.Enums.ExcelSheet.PropertyKey;




/**
 * This class is used to handle pop-up
 * @author User
 *
 */
public class PopupUtility {
	/**
	 * This method is used to accept alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to dismiss alert pop-up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to send data to alert pop-up
	 * @param driver
	 * @param data
	 */
	public void sendDataToAlert(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method is used to get data from alert pop-up
	 * @param driver
	 * @return
	 */
	public String getDataFromAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public static String getPropertyData(PropertyKey browser) {
		// TODO Auto-generated method stub
		return null;
	}

}
