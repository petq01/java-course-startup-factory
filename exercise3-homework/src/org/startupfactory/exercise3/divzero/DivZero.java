package org.startupfactory.exercise3.divzero;
/**
 * 
 */

/**
 * @author Petq
 *
 */
public class DivZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		      int bad = 10/0; // ArithmeticException occurs

		      // Rest of the try section is not executed.
		      System.out.println("Line after error."); 
		    }
		    catch(ArithmeticException e) {
		      System.out.println("Division by zero is not allowed");
		    }
finally{
	System.out.println("Goodbye!"); 
}
		    // After catch, the program execution continues.
		    
	}
	

}
