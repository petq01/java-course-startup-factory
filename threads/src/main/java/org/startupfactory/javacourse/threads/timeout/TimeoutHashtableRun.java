package org.startupfactory.javacourse.threads.timeout;

import org.startupfactory.javacourse.threads.counter.RunCounter;

public class TimeoutHashtableRun {

	public static void main(String[] args) {

		TimeoutHashtable timeoutTable = new TimeoutHashtable(10000);
		boolean checker = true;
		String key;
		String value;

		do {
			System.out.println(" P(ut) / G(et) / S(how) / R(emove) / E(xit)");
			String choice = RunCounter.readLine();

			switch (choice) {
			case "P":
				System.out.println("Enter key: ");
				key = RunCounter.readLine();
				System.out.println("Enter value: ");
				value = RunCounter.readLine();
				timeoutTable.put(key, value);
				break;
			case "G":
				System.out.println("Enter key: ");
				key = RunCounter.readLine();
				System.out.println(timeoutTable.get(key));
				break;
			case "S":
				timeoutTable.showElements();
				break;
			case "R":
				System.out.println("Enter key: ");
				key = RunCounter.readLine();
				timeoutTable.remove(key);
				break;
			case "E":
				checker = false;
				break;
			default:
				System.out.println(" Invalid option ");
				break;
			}
		} while (checker);
	}
}
