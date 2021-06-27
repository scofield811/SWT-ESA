package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TelefonlisteTest {
	Telefonliste t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new Telefonliste(null);
		t.addEntry("Maxi", "030234567");
	}

	@Test
	@DisplayName("Test auf Eintrag hinzufügen")
	void testAddEntry() {
		t.addEntry("Susi", "030123456");
		assertEquals(2, t.size());
	}

	@Test
	@DisplayName("Test auf komplette Liste löschen")
	void testClear() {
		t.clear();
		assertEquals(0,t.size());
	}

	@Test
	@DisplayName("Test auf modifiziere Eintrag")
	void testModifyEntry() {
		assertTrue(t.modifyEntry("Maxi", "030234567", "Maxi", "040232323"));
		assertEquals("Name: Maxi Nummer: 040232323", t.searchByName("Maxi"));
	}

	@Test
	@DisplayName("Test auf Eintrag entfernen")
	void testRemoveEntry() throws Exception {
		t.removeEntry("Maxi", "030234567");
		assertEquals(0, t.size());
	}
	
	@Test
	@DisplayName("Test auf Exception")
	void testRemoveEntry2() {
		Assertions.assertThrows(Exception.class,() -> {
			t.removeEntry("Max", "030234567"); 
		});
	}

	@Test
	@DisplayName("Test Eintrag Suchen")
	void testSearchByName() {
			assertEquals("Name: Maxi Nummer: 030234567", t.searchByName("Maxi"));
	}
	
	@Test
	void testMock() throws Exception{
		ArrayList<TelefonEintrag> telefoneintragDB = new ArrayList<>();
		TelefonEintrag neuerEintrag = new TelefonEintrag("MOCKITO", "123123123");
		telefoneintragDB.add(neuerEintrag);
		
		TelefonListeDatabase dbtest = mock(TelefonListeDatabase.class);
		when(dbtest.leseDatenbank()).thenReturn(telefoneintragDB);
		
		//System.out.println(dbtest.leseDatenbank());
		Telefonliste t = new Telefonliste(dbtest);
		
		assertEquals("Name: MOCKITO Nummer: 123123123",t.searchByName("MOCKITO"));
		
	}

	
}
