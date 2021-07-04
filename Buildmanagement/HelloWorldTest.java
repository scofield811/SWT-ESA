package ESA9;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
	Helloworld h;

	@BeforeEach
	public void setUp() throws Exception {
		h = new Helloworld();
	}

	@Test
	public void test() {
		assertEquals("JUNIT - HelloWorldTest",h.printMessage("JUNIT"));
	}


}
