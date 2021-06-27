package testing;

public class Honorar {

	public double toEuro(String text) {
		double wert = 0;
		
		text = text.replaceAll(" +"," ");
		wert = Double.valueOf(text.length())/10;
		return wert;
	}
}
