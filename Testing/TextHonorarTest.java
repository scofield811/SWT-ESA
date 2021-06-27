package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextHonorarTest {
	Honorar h;

	@BeforeEach
	void setUp() throws Exception {
		h = new Honorar();
	}

	@Test
	@DisplayName("Test String zu Euro")
	void testStringtoEuro() {
		assertEquals(6,h.toEuro("Das ist ein sehr langer Text zum testen und hat 60 Zeichen!!"));
	}
	
	
	@Test
	@DisplayName("Test Leerer String")
	void testTextEmptyString() {
		assertEquals(0,h.toEuro(""));
	}
	
	@Test
	@DisplayName("Test Text Null")
	void testTextNull() {
		Assertions.assertThrows(NullPointerException.class,() -> {
			assertEquals(0,h.toEuro(null));
		});
	}
	
	@Test
	@DisplayName("Test von mehreren Leerzeichen")
	//mehrere Leerzeichen hintereinander sollen entfernt und nicht mitgezählt werden
	void testTextSpaces() {
		assertEquals(3.8,h.toEuro("String mit   Leerzeichen und 40 Zeichen!"));
	}
	

}
