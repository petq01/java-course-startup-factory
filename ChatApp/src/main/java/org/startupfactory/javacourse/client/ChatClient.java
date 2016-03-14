package org.startupfactory.javacourse.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ChatClient is a client for Chat Server. After creating a socket connection to
 * the chat server it starts two threads. The first one listens for data coming
 * from the socket and transmits it to the console and the second one listens
 * for data coming from the console and transmits it to the socket. After
 * creating the two threads the main program's thread finishes its execution,
 * but the two data transmitting threads stay running as long as the socket
 * connection is not closed. When the socket connection is closed, the thread
 * that reads it terminates the program execution. Keep-alive messages are
 * ignored when received.
 */
public class ChatClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatClient.class);
	public static final String SERVER_HOSTNAME = "localhost";
	public static String KEEP_ALIVE_MESSAGE = "!keep-alive";
	public static final int SERVER_PORT = 2002;

	private static BufferedReader mSocketReader;
	private static PrintWriter mSocketWriter;

	public static void main(String[] args) {
		// Connect to the chat server
		Socket socket = null;
		try {
			socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
			mSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			mSocketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			LOGGER.info("Connected to server : >> {} : {} >>> please add message", SERVER_HOSTNAME, SERVER_PORT);
		} catch (IOException ioe) {
			LOGGER.error("Can not connect to {} : {} ", SERVER_HOSTNAME, SERVER_PORT);
			ioe.printStackTrace();
			System.exit(-1);
		}

		// Start socket --> console transmitter thread
		PrintWriter consoleWriter = new PrintWriter(System.out);
		TextDataTransmitter socketToConsoleTransmitter = new TextDataTransmitter(mSocketReader, consoleWriter);
		socketToConsoleTransmitter.setDaemon(false);
		socketToConsoleTransmitter.start();

		// Start console --> socket transmitter thread
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		TextDataTransmitter consoleToSocketTransmitter = new TextDataTransmitter(consoleReader, mSocketWriter);
		consoleToSocketTransmitter.setDaemon(false);
		consoleToSocketTransmitter.start();
	}
}
