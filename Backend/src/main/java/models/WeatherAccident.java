package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import utils.ApiUtils;
import utils.ApiUtils.APIClass;

public class WeatherAccident {
	public ArrayList<Clima> weathers;
	public ArrayList<WeatherAccidentAccidents> accidents;
	public ArrayList<DateCount> dateCount;
	
	public WeatherAccident(String startDate, String endDate) {
		super();
		weathers = new ArrayList<Clima>();
		accidents = new ArrayList<WeatherAccidentAccidents>();
		dateCount = new ArrayList<DateCount>();
		
		LocalDate _startDate = ApiUtils.getDate(startDate, APIClass.front);
		LocalDate  _endDate = ApiUtils.getDate(endDate, APIClass.front);	
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		
		int i = 0;
		LocalDate nextDay = _startDate;
		while (!nextDay.isEqual(_endDate)) {
			nextDay = _startDate.plusDays(i); 
			
			String newDate = _startDate.plusDays(i).format(formatter);
			dateCount.add(new DateCount(newDate, 0));
			i += 1;
		}
			

	}
	
	public void insertDate(String s) {
		for (DateCount d: dateCount) {
			if (s.equals(d.date)) {
				d.count += 1;
				return;
			}
		}
		dateCount.add(new DateCount(s, 1));
	}
	
	
}

