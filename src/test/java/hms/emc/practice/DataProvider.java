package hms.emc.practice;


import org.testng.annotations.Test;

public class DataProvider extends testNGPractice
{
	@Test(dataProvider = "tro")
	public void example(String doctorSpecialisation, String doctorName, String doctorAddress, String doctorFees, String doctorContact, String doctorEmail, String doctorPassword)
	{
		System.out.println(doctorSpecialisation+"  "+ doctorName+" "+doctorAddress+"  "+ doctorFees+" "+doctorContact+"  "+ doctorEmail+" "+doctorPassword);
	}
	@org.testng.annotations.DataProvider
	public String[][] tro()
	{
		return excelutility.getData("Sheet2");
	}
}
