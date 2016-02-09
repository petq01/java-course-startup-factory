package org.startupfactory.javacourse.designpatters.pool;

import java.util.Scanner;

public class PoolRun {
	public static void main(String[] args) {
		Pool pool = new Pool(10);
		String repeat;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println(" 1-Acquire / 2-Release / 3-Exit");
			repeat = input.next();

			switch (repeat) {

			case "1":
				try {
					pool.acquire();
				} catch (PoolException e) {
					System.err.println(e.getMessage());
				}
				break;
			case "2":
				try {
					pool.release(new DataClass());
				} catch (PoolException e) {
					System.err.println(e.getMessage());
				}
				break;
			default:
				break;
			}

		} while (!"3".equals(repeat));

	}
}
