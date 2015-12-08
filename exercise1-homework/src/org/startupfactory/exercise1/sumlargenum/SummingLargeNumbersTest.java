package org.startupfactory.exercise1.sumlargenum;

import static org.junit.Assert.*;

import org.junit.Test;
import org.startupfactory.exercise1.randompass.RandomStrings;

public class SummingLargeNumbersTest {

	/** Test when number 1 is longer than number 2 */
	/**
	 * Tests the string generator. Considering the generator generates random values the function is
	 * called 5000 times and each time the length and if the string is generated only using lower
	 * and upper case letters and numbers
	 */
	@Test
	public void testSumStrings() {
		SummingLargeNumbers calculator = new SummingLargeNumbers();

		assertEquals("10000", calculator.sum("1", "9999"));
	}
	/**
	 * Testing the addClass method from the NumberAddition class. The tests should return the
	 * expected sum.
	 */
	@Test
	public void testSum() {
		SummingLargeNumbers addClass = new SummingLargeNumbers();
		assertEquals("67868778555572961", addClass.sum("91686886861", "67868686868686100"));
		assertEquals("2", addClass.sum("1", "1"));
		assertEquals("1998", addClass.sum("999", "999"));
		assertEquals("9968", addClass.sum("9753", "215"));
	}

	/**
	 * Testing the addClass method from the NumberAddition class for NumberFormatException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSumException() {
		SummingLargeNumbers addClass = new SummingLargeNumbers();
		addClass.sum("a21", "211");
		addClass.sum("", "211");
	}

	/**
	 * Testing the addClass method from the NumberAddition class for NullPointerException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSumNullPointerException() {
		SummingLargeNumbers addClass = new SummingLargeNumbers();
		addClass.sum(null, "2");
	}

}
