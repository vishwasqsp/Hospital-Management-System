package com.tyss.genericUtilities.frameworkConstant;
/**
 * This class is used for storing path of a files which having data useful for testscripts
 * @author User
 *
 */
public interface FrameworkConstant {
	/**
	 * This method is used for storing excel file path
	 */
	String TEST_EXCEL_FILE_PATH = "./src/main/resources/testData/TestData.xlsx";
	/**
	 * This method is used for storing property file path
	 */
	String TEST_PROPERTY_FILE_PATH = "./src\\test\\resources\\commonData\\commonData.properties";
	/**
	 * This method is used for storing extent report file path
	 */
	String TEST_EXTENT_REPORT_FILE_PATH = System.getProperty("user.dir")+"/ExtentReport/";
}
