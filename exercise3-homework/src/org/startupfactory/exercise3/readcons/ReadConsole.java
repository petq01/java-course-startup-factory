package org.startupfactory.exercise3.readcons;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Petq
 *
 */
public class ReadConsole {

	/**
	 * @param args
	 */
	public static String read() throws ConsoleReadException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int number = 0;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			number = Integer.parseInt(line);
		} catch (Exception e) {
			throw new ConsoleReadException("The input is not a valid number", e);
		}
		if (number > 100 || number < 0) {
			throw new ConsoleReadException("Number out of bounds");
		}
		return line;

	}
	public static void main(String[] args) throws ConsoleReadException {
		Scanner s=null;
		try {
			int iterator=0;
			while(iterator<=3){
			System.out.println("Enter number line");
			read();
			System.out.println("Reading successful");
			iterator++;
			}

		} catch (ConsoleReadException e) {
			System.out.println(e.getMessage());
		} finally {
			
            if (s != null) {
                s.close();
            }
		}
	}
}
