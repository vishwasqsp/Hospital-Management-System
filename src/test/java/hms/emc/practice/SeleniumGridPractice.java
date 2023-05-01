package hms.emc.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridPractice {
	@Test
	public void seleniumGrid() throws MalformedURLException
	{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(Platform.WINDOWS);
		String browser = "chrome";
		if(browser.equals("chrome"))
		{
			capability.setBrowserName("chrome");
		}
		else if
		(browser.equals("firefox"))
		{
			capability.setBrowserName("firefox");
		}
		URL url = new URL("http://192.168.100.1:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, capability);
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
}
