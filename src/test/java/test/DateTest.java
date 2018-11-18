package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		String string = "2018-11-11 00:03:00";
		Date date = Str2Date(string);
		System.out.println(date);
	}
	public static Date Str2Date(String date) throws ParseException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dateFormat.parse(date);
	}
}
