/**
 * 
 */
package org.startupfactory.exercise1.randompass;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Petq
 *
 */
public class RandomStringsTest {
	/**
	 * Test if the random generator produces a String with the given lenght.
	 */
	@Test(expected = AssertionError.class)
	public void testEqualLength() {
		RandomStrings generaotr = new RandomStrings(6);
		assertEquals(6, generaotr.nextString());

	}
}
