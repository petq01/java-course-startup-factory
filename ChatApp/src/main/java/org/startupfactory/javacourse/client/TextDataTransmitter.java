package org.startupfactory.javacourse.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transmits text data from the given reader to given writer and runs as a
 * separate thread.
 */
public class TextDataTransmitter extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(TextDataTransmitter.class);
	private BufferedReader mReader;
	private PrintWriter mWriter;

	public TextDataTransmitter(BufferedReader aReader, PrintWriter aWriter) {
		mReader = aReader;
		mWriter = aWriter;
	}

	/**
	 * Until interrupted reads a text line from the reader and sends it to the
	 * writer.
	 */
	public void run() {
		try {
			while (!isInterrupted()) {
				String data = mReader.readLine();
				if (!data.equals(ChatClient.KEEP_ALIVE_MESSAGE)) {
					mWriter.println(data);
					mWriter.flush();
				}
			}
		} catch (IOException ioe) {
			LOGGER.error("Lost connection to server.");
			System.exit(-1);
		}
	}
}