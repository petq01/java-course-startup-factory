
package org.startupfactory.exercise1.maxsubarray;

/**
 * @author Petq
 * @param array
 * 
 * @return max_so_far returns a[2] + a[3] + a[4] = 2 + 3 + 8 = 13.
 * 
 */
public class MaxSubArray {
	public static int maxSumIndexes(int[] a) {

		String string = "0,-1,2,3,8,-10";
		String[] numbers = string.split(",");
		int max_so_far = 0;
		int max_ending_here = 0;
		for (int i = 0; i < numbers.length; i++) {
			max_ending_here = max_ending_here + Integer.parseInt(numbers[i]);
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}

		return max_so_far;

	}

}
