package models;

import java.util.ArrayList;

public class AccidentSpeedMonitor {
	public ArrayList<Accident> accidents;
	public ArrayList<Radar> speedMonitor;
	
	public AccidentSpeedMonitor() {
		super();
		accidents = new ArrayList<Accident>();
		speedMonitor= new ArrayList<Radar>();
	}

}
