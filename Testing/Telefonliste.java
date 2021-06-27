package testing;

import java.util.ArrayList;


public class Telefonliste {
	private ArrayList<TelefonEintrag> telefoneintrag;
	private TelefonListeDatabase db = new TelefonListeDatabase();
	
	public Telefonliste(TelefonListeDatabase d) {
		telefoneintrag = new ArrayList<>();
		this.db = d;
		
	}

	
	public void readDatabase() {
				
		telefoneintrag = db.leseDatenbank();
	}
	
	public void addEntry(String name, String nummer) {
		TelefonEintrag neuerEintrag = new TelefonEintrag(name, nummer);
		this.telefoneintrag.add(neuerEintrag);
	}

	public void clear() {
		this.telefoneintrag.clear();
	}
	
	public int size() {
		return this.telefoneintrag.size();
	}
	
	public boolean modifyEntry(String name, String nummer, String neuername, String neuenummer) {
		for(int i = 0; i < telefoneintrag.size(); i++) {
			if (telefoneintrag.get(i).getName().equals(name) && telefoneintrag.get(i).getNumber().equals(nummer)) {
				telefoneintrag.get(i).setName(neuername);
				telefoneintrag.get(i).setNumber(neuenummer);
				return true;
			} 
		}
		return false;
	}
	
	public boolean removeEntry(String name, String nummer) throws Exception {
		for(int i = 0; i < telefoneintrag.size(); i++) {
			if (telefoneintrag.get(i).getName().equals(name) && telefoneintrag.get(i).getNumber().equals(nummer)) {
				telefoneintrag.remove(i);
				
				printEntrys();
				return true;				
			} 
		}
		
		printEntrys();
		
		//System.out.println("Der angegebene Name "+name+" und Telefonnummer "+nummer+" wurde nicht gefunden!");
		throw new Exception("Kein Wert gefunden");
		
	}

	private void printEntrys() {
		for(int j = 0; j < telefoneintrag.size(); j++) {
			System.out.println(telefoneintrag.get(j));
		}
	}
	
	public String searchByName(String name) {
		for (TelefonEintrag eintrag: this.telefoneintrag) {
			if (eintrag.getName().equals(name)) {
				return eintrag.toString();
			}
		}
		return ("Der angegebene Name " +name+" wurde nicht gefunden!");
	}
	
	public String searchNameByNumber(String nummer) {
		for (TelefonEintrag eintrag: this.telefoneintrag) {
			if (eintrag.getNumber().equals(nummer)) {
				return eintrag.toString();
			}
		}
		return ("Zu der Angegebenen Nummer " +nummer+" wurde kein Name gefunden!");
	}
	
}
