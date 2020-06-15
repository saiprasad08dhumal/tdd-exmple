package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void testEmpty() {
		assertEquals(0, calculator.add(null));
	}
	
	@Test
	void testMoreArgs() {
		assertEquals(6, calculator.add("1,2,3"));
	}
	
	@Test
	void testMoreDelimiters() {
		assertEquals(6, calculator.add("1\n2,3"));
	}
	@Test
	void testCustomDelimiter() {
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	@Test
	void negativeNotAllowedtest() {
		 RuntimeException thrown =	Assertions.assertThrows(
		           RuntimeException.class,
		           ()->calculator.add("1,-2,-3")
		    );
		    assertTrue(thrown.getMessage().contains("negatives not allowed: -2,-3"));		
	}
	@Test
	void longerDelimiterTest() {		
		assertEquals(6, calculator.add("//***\n1***2***3"));
	}

}
