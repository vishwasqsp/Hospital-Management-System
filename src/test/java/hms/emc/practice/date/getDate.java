package hms.emc.practice.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {

	public static void main(String[] args) {
		SimpleDateFormat properDateFormat = new SimpleDateFormat("dd_MM_yyyy");
		String date = properDateFormat.format(new Date());
		System.out.println(date);
		System.out.println(date);
	}
}
