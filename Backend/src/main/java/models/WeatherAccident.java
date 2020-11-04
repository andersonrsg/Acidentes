package models;

import java.util.ArrayList;

public class WeatherAccident {
	public ArrayList<Clima> weathers;
	public ArrayList<WeatherAccidentAccidents> accidents;
	public ArrayList<DateCount> dateCount;
	
	public WeatherAccident() {
		super();
		weathers = new ArrayList<Clima>();
		accidents = new ArrayList<WeatherAccidentAccidents>();
		dateCount = new ArrayList<DateCount>();
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

