package com.tyss.genericUtilities.reportUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.genericUtilities.Enums.ExcelSheet.PropertyKey;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;
import com.tyss.genericUtilities.frameworkConstant.FrameworkConstant;
import com.tyss.genericUtilities.javaUtility.JavaUtility;
import com.tyss.genericUtilities.utilityInstanceTransfer.UtilityInstanceTransfer;
/**
 * This class is used for configuring the Report
 * @author User
 *
 */
public class ReportUtility 
{
	private ExtentReports report;
	private String extentReportPath;
	public void init()
	{
		PropertyUtility propertyutility;
		propertyutility = new PropertyUtility(FrameworkConstant.TEST_PROPERTY_FILE_PATH);
		String overrideOrNot = propertyutility.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String randomName = "";
		if(overrideOrNot.equalsIgnoreCase("no"))
		{
			randomName = new JavaUtility().getCurrentDateTime();
		}
		
		extentReportPath = FrameworkConstant.TEST_EXTENT_REPORT_FILE_PATH+"extentReport"+randomName+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
		spark.config().setDocumentTitle(propertyutility.getPropertyData(PropertyKey.EXTENTREPORTTITLE));
		spark.config().setReportName(propertyutility.getPropertyData(PropertyKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", propertyutility.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}
	

	/**
	 * This method is used to create a test in the Report
	 * @param testName
	 */
		public void createTest(String testName)
		{
			ExtentTest test = report.createTest(testName);
			UtilityInstanceTransfer.setExtentTest(test);
		}
		/**
		 * This method will execute if a test is failed
		 * @param test
		 * @param message
		 * @param errorMessage
		 */
		public void fail(ExtentTest test, String message, Throwable errorMessage)
		{
			test.fail(message);
			test.fail(errorMessage);
			System.out.println(message);
		}
		/**
		 * This method is used to add Author in the Report
		 * @param test
		 * @param names
		 */
		public void addAuthor(ExtentTest test, String... names)
		{
			test.assignAuthor(names);
			
		}
		/**
		 * This method is used to add Category in the Report
		 * @param test
		 * @param names
		 */
		public void addCategory(ExtentTest test, String... names)
		{
			test.assignCategory(names);
			
		}
		/**
		 * This method will execute if a test is pass
		 * @param test
		 * @param message
		 */
		public void pass(ExtentTest test, String message)
		{
			test.pass(message);
			System.out.println(message);
		}
		public void warn(ExtentTest test, Throwable message)
		{
			test.warning(message);
			System.out.println(message);
		}
		/**
		 * This method will execute if a test is skipped
		 * @param test
		 * @param message
		 * @param errorMessage
		 */
		public void skip(ExtentTest test, String message, Throwable errorMessage)
		{
			test.skip(message);
			test.skip(errorMessage);
			System.out.println(message);
		}
		/**
		 * This method will give information of a test
		 * @param test
		 * @param message
		 */
		public void info(ExtentTest test, String message)
		{
			test.info(message);
			System.out.println(message);
		}
		/**
		 * This method is used to take a screenshot
		 * @param test
		 * @param screenshotPath
		 * @param title
		 * @param strategy
		 */
		public void attachScreenshot(ExtentTest test, String screenshotPath, String title, String strategy)
		{
			if(strategy.equalsIgnoreCase("base64"))
			{
				test.addScreenCaptureFromBase64String(screenshotPath, title);
			}
			else
			{
				test.addScreenCaptureFromPath(screenshotPath, title);
			}
		}
		/**
		 * This method is used to save a Report
		 */
		public void saveReport()
		{
			report.flush();
			try {
				Desktop.getDesktop().browse(new File("").toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
