package hms.emc.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dATAprovider1 {
	@Test(dataProvider = "dataProvider_bookTicketTest") 
	public void bookingTicketTest(String src, String dst) {
		System.out.println("book ticket from" +src+ "to "+dst);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest () {
		Object[][] objArr = new Object[5][2];
		objArr[0][0] ="Bangalore";
		objArr[0][1] ="Goa";
		
		objArr[1][0] ="Bangalore";
		objArr[1][1] ="Mysore";
		
		objArr[2][0] ="Bangalore";
		objArr[2][1] ="Mangalore";
		
		objArr[3][0] ="Bangalore";
		objArr[3][1] ="Hyderabad";
		
		objArr[4][0] ="Bangalore";
		objArr[4][1] ="Mumbai";
		return objArr;
	}
}
