/**
 * 
 */
package org.startupfactory.exercise1.arrayreversal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Petq
 *
 */
public class ArrayReversalTest {

	@Test
	public void testReverseWithEvenLengthOfArray() {
		int[] revArray = { 1, 2, 3, 4, 5, 6 };
		ArrayReversal.reverse(revArray);
		assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 }, revArray);

	}

	@Test
	public void testReverseWithOddLengthOfArray() {
		int[] revArray = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayReversal.reverse(revArray);
		assertArrayEquals(new int[] { 7, 6, 5, 4, 3, 2, 1 }, revArray);

	}

	@Test
	public void testReverseWithEmptyArray() {
		int[] revArray = {};
		ArrayReversal.reverse(revArray);
		assertArrayEquals(new int[] {}, revArray);
	}

	@Test
	public void testReverseWithJustOneElementArray() {
		int[] revArray = { 1 };
		ArrayReversal.reverse(revArray);
		assertArrayEquals(new int[] { 1 }, revArray);
	}

}
