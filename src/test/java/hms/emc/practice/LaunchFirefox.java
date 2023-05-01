package hms.emc.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchFirefox 
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("vishwas");
		ArrayList<String> a = new ArrayList<String>();
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']/li"));
		for(WebElement result:suggestions) {
			a.add(result.getText());
		}
		Collections.sort(a);
		for(String suggestion:a) {
			String thirdSuggestion = suggestion.valueOf(2);
			System.out.println("Third suggestion is ------> "+thirdSuggestion);
		}
		
		String thirdSuggestion = a.get(2);
		System.out.println("Third suggestion is ------> "+thirdSuggestion);
		driver.quit();
		
		
//		WebElement country = driver.findElement(By.cssSelector("[name='Montana']"));
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].scrollIntoView", country);
//		country.click();
		
		
		
//		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("test170423@yopmail.com");
//		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Test@1234");
//		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
//		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Select Status...']"));
//		for(WebElement eles:elements) {
//			eles.click();
//		}
		
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.findElement(By.xpath("//span[text()='Samsung Galaxy M14 5G (Smoky Teal, 4GB, 128GB Storage) | 50MP Triple Cam | 6000 mAh Battery | 5nm Octa-Core Processor | Android 13 | Without Charger']")).click();
//		String parentWindow = driver.getWindowHandle();
//		Set<String> windows = driver.getWindowHandles();
//		for(String tab:windows) {
//			if(!parentWindow.equals(windows)) {
//				driver.switchTo().window(tab);
//			}
//		}
//		
//		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
//		driver.switchTo().window(parentWindow);
//		driver.quit();
	}
}
