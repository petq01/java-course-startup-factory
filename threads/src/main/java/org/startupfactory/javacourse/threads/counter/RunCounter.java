package org.startupfactory.javacourse.threads.counter;

import java.util.Scanner;

public class RunCounter {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Input max value that you want the thread to count  : ");
		CounterThread thread = new CounterThread(readInt());
		System.out.println("Counter is set to : " + thread.getValue());
		System.out.println("The thread starts counting now");
		System.out.println("To stop the thread you must type something in the console");
		thread.start();
		readLine();

		thread.stopCounter();
		System.out.println("Count is " + thread.getValue());
	}

	public static int readInt() {
		Integer input = null;
		input = inputNumber();
		if (input == null) {
			input = readInt();
		}
		return input;
	}

	private static Integer inputNumber() {
		Integer temp = null;
		try {
			temp = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("Please input number value");
		}
		return temp;
	}

	public static String readLine() {
		return scanner.nextLine();
	}
}
