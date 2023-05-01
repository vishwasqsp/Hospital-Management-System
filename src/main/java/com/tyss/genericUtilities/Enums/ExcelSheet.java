package com.tyss.genericUtilities.Enums;
/**
 * This Enum is used for values of respective data used in excel sheet
 * @author User
 *
 */
public enum ExcelSheet {
	USER("User"), ADMIN("Admin"), DOCTOR("Doctor"), TESTDATA("TestData"), VERIFICATION("Verification");
	
	String key;
	
	private ExcelSheet (String key) {
		this.key=key;
	}
	
	public String getSheetName(){
		return key;
	}
	/**
	 *  This Enum is used for values of respective data used in property sheet
	 * @author User
	 *
	 */
	public enum PropertyKey{
		
		BROWSER, TIMEUNIT, URL, USERUSERNAME, USERPASSWORD, DOCTORUSERNAME, DOCTORPASSWORD, ADMINUSERNAME, ADMINPASSWORD, FILEPATH, OVERRIDEREPORT, EXTENTREPORTTITLE, EXTENTREPORTNAME, VERIFICATION;
		
		
	}
}
