package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void testEmpty() {
		assertEquals(0, calculator.add(""));
	}

}
