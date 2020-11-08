package models;

public class APIAge {

	public int ageMenor18 = 0;
	public int age18_24 = 0;
	public int age25_34 = 0;
	public int age35_44 = 0;
	public int age45_54 = 0;
	public int age55_64 = 0;
	public int ageTerceira = 0;
	
	public void insertValue(String value) {
		if (value.equals(">60")) {
			ageTerceira += 1;
		} else {
		
			int intValue = (int)Float.parseFloat(value);
			
			if (intValue < 18) {
				ageMenor18 += 1;
			} else if (intValue < 25) {
				age18_24 += 1;
			} else if (intValue < 35) {
				age25_34 += 1;
			} else if (intValue < 45) {
				age35_44 += 1;
			} else if (intValue < 55) {
				age45_54 += 1;
			} else if (intValue < 65) {
				age55_64 += 1;
			} else {
				ageTerceira += 1;
			}
		}
	}
}
