package Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.tyss.genericUtilities.WebActions.SeleniumUtility;
import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;
import com.tyss.genericUtilities.externalFileUtility.PropertyUtility;
import com.tyss.genericUtilities.frameworkConstant.FrameworkConstant;
import com.tyss.genericUtilities.javaUtility.JavaUtility;
import com.tyss.genericUtilities.reportUtility.ReportUtility;
import com.tyss.genericUtilities.utilityInstanceTransfer.UtilityInstanceTransfer;

import annotations.Report;

public class ExtentReportListener implements ITestListener, ISuiteListener
{
	private ReportUtility report;
	public static ReportUtility sreport;
	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("onStart ----> Suite");
		report = new ReportUtility();
		sreport = report;
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		System.out.println("onFinish ----> Suite");
		//report.saveReport();
	}


	
	@Override
	public void onTestStart(ITestResult result) //BM
	{

		System.out.println("onTestStart");

		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}


	@Override
	public void onTestSuccess(ITestResult result) { //AM
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) { //AM
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());

		String screenshotPath = null;
		screenshotPath = AnnotationConfiguration.class.cast(result.getMethod().getInstance()).seleniumutility.takeScreenshotOfPage();
		//screenshotPath = AnnotationConfiguration.class.cast(result.getMethod().getInstance()).seleniumutility.takeScreenshotOfPage();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(), screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) { //AM
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { //AM
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) { //AM
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context)  //BT
	{
		System.out.println("onStart---> Test");
	}

	@Override
	public void onFinish(ITestContext context) { //AT
		System.out.println("onFinish ---> Test");
		report.saveReport();
	}

}
