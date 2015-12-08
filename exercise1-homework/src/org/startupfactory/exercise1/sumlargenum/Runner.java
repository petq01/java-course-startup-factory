/**
 * 
 */
package org.startupfactory.exercise1.sumlargenum;

/**
 * @author Petq
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

	private Runner() {
		/**
		 * Prevents instantiation.
		 */
	}

	/**
	 * Main method for SummingLargeNumbers class.
	 * 
	 */
	public static void main(String[] args) {

		SummingLargeNumbers summing = new SummingLargeNumbers();
		String num1 = "111111111111111111111111111111111111111111111111111111111111111111111";
		String num2 = "111111111111111111111111111111111111111111111111111111111111111111111";

		String answer = summing.sum(num1, num2);
		String sum = answer.toString();
		System.out.println(num1 + " summed with");
		System.out.println(num2 + " equals:");
		System.out.println(sum);

	}

}
