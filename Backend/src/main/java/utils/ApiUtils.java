package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

public class ApiUtils {
	
	public enum APIClass {
		accident,
		weather;
		
		public String getFormat() {
			switch (this) {
			case accident:
			case weather:
				return "yyyy-MM-dd";
				default:
					return frontDateFormat;
		}
			
		}
	}
	
	static String frontDateFormat = "MM-dd-yyyy";
	
	public static long dateToAPILong(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(frontDateFormat, Locale.forLanguageTag("pt/BR"));
		
		String dateString = date.strip();
		
		String[] horMin = "00:00".split(":");
		int hor = Integer.parseInt(horMin[0]);
		int min = Integer.parseInt(horMin[1]);
		
		long value = LocalDate.parse(dateString, formatter).toEpochSecond(LocalTime.of(hor, min), ZoneOffset.ofHours(0));
		System.out.println(value);
		return value;   
	}
	
	public static long getDate(String date, String hour, APIClass format) {
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getFormat(), Locale.forLanguageTag("pt/BR"));
		
		String dateString = date.strip();
		
		String[] horMin = hour.split(":");
		int hor = Integer.parseInt(horMin[0]);
		int min = Integer.parseInt(horMin[1]);
		
		long value = LocalDate.parse(dateString, formatter).toEpochSecond(LocalTime.of(hor, min), ZoneOffset.ofHours(0));
		System.out.println(value);
		return value;
		
	}
	
	
}
