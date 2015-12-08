/**
 * 
 */
package org.startupfactory.exercise1.randompass;

/**
 * @author Petq
 *
 */

public class Runner {

	private Runner() {
		/**
		 * Prevents instantiation.
		 */
	}

	public static void main(String[] args) {
		RandomStrings randomLength = new RandomStrings(6);
		System.out.println(randomLength.nextString());
	}

}
