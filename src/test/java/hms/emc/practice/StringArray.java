package hms.emc.practice;

import org.testng.annotations.Test;

public class StringArray 
{
	@Test
	public void print()
	{
		String[] arr = new String[5];
		arr[0] = "practice1";
		arr[1] = "printed";
		arr[3] = "executed";
		arr[4] = "protected";
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.println(arr[i]);	
		}
	}
}
