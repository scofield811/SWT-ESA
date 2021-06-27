package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BildzaehlungTest {

	Bildzaehlung b;
	
	@BeforeEach
	void setUp() throws Exception {
		b = new Bildzaehlung();
	}

	@Test
	@DisplayName("Test Anzahl Bilder zaehlen")
	void testBilderZaehlen() {
		assertEquals(2,b.zaehleBilder("Das sind Pictures eines Waldes. Das erste Picture zeigt ein Ahornbaum, das zweite Picture eine Eiche."));
	}
	
	@Test
	@DisplayName("Test keine Bilder im Text")
	void testKeineBilder() {
		assertEquals(0,b.zaehleBilder("In diesem Text kommt kein Bild vor!"));
	}
	
	@Test
	@DisplayName("Test auf Leeren String")
	void testLeererString() {
		Assertions.assertThrows(NullPointerException.class,() -> {
			assertEquals(0,b.zaehleBilder(null));
		});
	}
	
	@Test
	@DisplayName("Test Falsche Schreibweise")
	void testFalscheSchreibweise() {
		assertEquals(0,b.zaehleBilder("Das ist ein Picturee"));
	}
	
	@Test
	@DisplayName("Test Gross und Kleinschreibung")
	void testGrossKleinschreibung() {
		assertEquals(2,b.zaehleBilder("Picture picture"));
	}

}
