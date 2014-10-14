package com.forg.java.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateKest {

	public static void main(String[] args) {
		Date d = new Date();
		String date = "2015-03-01";
		// SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println(f.format(addDay(d,1*3*30)));
		// System.out.println(f.format(addMonth(d,3)));

		// System.out.println(convertDate2String(d,"yyyy-MM-dd"));
		// System.out.println(getMonth(d));
		// System.out.println( getMonth(convertString2Date(date,"yyyy-MM-dd"))
		// );

		d = convertString2Date(date, "yyyy-MM-dd");
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(d);
		System.out.println(localCalendar.get(2) + 1);

	}

	public static Date addDay(Date date, int day) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	public static Date addMonth(Date date, int month) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	public static String getMonth(Date paramDate) {
		if (paramDate == null) {
			return "";
		}
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(paramDate);
		return String.valueOf(localCalendar.get(2) + 1);
	}

	public static String convertDate2String(Date paramDate, String paramString) {
		if (paramDate == null) {
			return null;
		}
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				paramString);
		return localSimpleDateFormat.format(paramDate);
	}

	public static Date convertString2Date(String paramString1,
			String paramString2) {
		if ((paramString1 == null) || ("".equals(paramString1))) {
			return null;
		}
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				paramString2);
		Calendar localCalendar = Calendar.getInstance();
		try {
			localCalendar.setTime(localSimpleDateFormat.parse(paramString1
					.trim()));
		} catch (ParseException localParseException) {
			throw new RuntimeException(localParseException);
		}
		return localCalendar.getTime();
	}

}
