package hms.emc.practice.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getFutureDate 
{

	public static void main(String[] args) throws ParseException 
	{
		String dateString = "24_09_2024";
		SimpleDateFormat properDateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		calendar.setTime(properDateFormat.parse(dateString));
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		String date = properDateFormat.format(calendar.getTime());
		System.out.println(date);
	}
}
