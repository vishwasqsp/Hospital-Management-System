package hms.emc.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shadowElementPractice 
{
	@Test
	public void shadowElement()
	{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("chrome://downloads/");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement ele = (WebElement)js.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput')");
			System.out.println(ele.getAttribute("id"));
	}
}