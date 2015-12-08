/**
 * 
 */
package org.startupfactory.exercise1.arrayreversal;

/**
 * @author Petq
 *
 */

public class ArrayReversal {

	/**
	 * @param reversalArray
	 *            input array
	 *
	 * @param temp
	 *            give temporary value of iterating loop(usually
	 *            revArray.length-1)
	 * @return the reversed array
	 */
	public static void reverse(int[] revArray) {
		try {
			for (int i = 0; i < revArray.length / 2; i++) {

				int temp = revArray[revArray.length - 1 - i];

				revArray[revArray.length - 1 - i] = revArray[i];

				revArray[i] = temp;

			}
		} catch (NullPointerException e) {

			e.printStackTrace();
		}

	}
}
