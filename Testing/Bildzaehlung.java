package testing;

public class Bildzaehlung {

	public Integer zaehleBilder(String text) {
		int anzahl=0;
		
		String[] words = text.split(" ");
		for(String w : words) {
			if (w.equals("Picture") || w.equals("picture")) {
				anzahl ++;
			}
		}

        return anzahl;
	}

	
}
