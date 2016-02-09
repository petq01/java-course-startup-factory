package org.startupfactory.javacourse.threads.timeout;

import java.util.TimerTask;

public class HashtableTimer extends TimerTask {

	// class private members
	private String key;
	private TimeoutHashtable table;

	/**
	 * Constructor. Initialize variables.
	 * 
	 * @param table
	 *            - TimeoutHashtable
	 * @param key
	 *            - element to remove key
	 */
	public HashtableTimer(TimeoutHashtable table, String key) {
		this.key = key;
		this.table = table;
	}

	public void run() {
		table.remove(key);
	}

}
