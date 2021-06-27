package testing;

import java.util.ArrayList;

public class TelefonListeDatabase {

	public ArrayList<TelefonEintrag> leseDatenbank() {
		System.out.println("db");
		ArrayList<TelefonEintrag> telefoneintraege = new ArrayList<>();
		
		telefoneintraege.add(new TelefonEintrag("Database Test 1","12345"));
		

		
		return telefoneintraege;
		
	}
}
