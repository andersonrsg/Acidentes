package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiUtils {
	
	public enum APIClass {
		accident,
		weather;
	}
	
	static String frontDateFormat = "mm-dd-yyyy";
	
	public static String dateToAPIString(APIClass destination, String date) {
		
		Date parsedDate = null; 
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(frontDateFormat);
			parsedDate = formatter.parse(date);	
		} catch (ParseException e) {
			System.out.println("Failed to convert String " + date + " to Date.");
			return "";
		}
		
		if (parsedDate == null) {
			System.out.println("Failed to convert String " + date + " to Date.");
			return "";
		}
		
		String format = "";
		switch (destination) {
			case accident:
			case weather:
				format = "yyyy-mm-dd"; 
				break;
		}
		
        DateFormat dateFormat = new SimpleDateFormat(format);  
        return dateFormat.format(parsedDate);  
        
	}
}
