package com.tyss.genericUtilities.WebActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is used for scrolling action and handle disabled element 
 * @author User
 *
 */
public class JavaScriptUtility 
{
	JavascriptExecutor js;
	public JavaScriptUtility(WebDriver driver)
	{
		js = (JavascriptExecutor)driver;
	}
	/**
	 * This method is used for scroll up
	 */
	public void scrollUp()
	{
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
	}
	/**
	 * This method is used for scroll down
	 */
	public void scrollDown()
	{
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	/**
	 * This method is used for scroll to the required element
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView", element);
	}
	/**
	 * This method is used to pass the value to the element
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data)
	{
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	/**
	 * This method is used to launch the browser
	 * @param url
	 */
	public void launchApplication(String url)
	{
		js.executeScript("window.location=argument[0]", url);
	}
	/**
	 * This method is used for click action on element
	 * @param element
	 */
	public void click(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightWebElement(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style' , 'border:5px dotted red;');", element);
	}
}
