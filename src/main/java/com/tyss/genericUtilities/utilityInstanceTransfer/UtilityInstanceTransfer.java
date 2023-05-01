package com.tyss.genericUtilities.utilityInstanceTransfer;

import com.aventstack.extentreports.ExtentTest;
/**
 * This class is used to transfer  utility to all the scripts
 * @author User
 *
 */
public class UtilityInstanceTransfer 
{
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}
}
