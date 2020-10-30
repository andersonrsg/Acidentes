package models;

import java.util.ArrayList;

public class WeatherAccident {
	public ArrayList<Clima> weathers;
	public ArrayList<Accident> accidents;
	
	public WeatherAccident() {
		super();
		weathers = new ArrayList<Clima>();
		accidents = new ArrayList<Accident>();
	}
	
}
