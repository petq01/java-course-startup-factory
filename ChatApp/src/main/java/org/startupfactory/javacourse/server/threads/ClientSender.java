package org.startupfactory.javacourse.server.threads;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

import org.startupfactory.javacourse.server.ChatServer;
import org.startupfactory.javacourse.server.Client;

/**
 * Sends messages to the client. Messages waiting to be sent are stored in a
 * message queue. When the queue is empty, ClientSender falls in sleep until a
 * new message is arrived in the queue. When the queue is not empty,
 * ClientSender sends the messages from the queue to the client socket.
 */
public class ClientSender extends Thread {

	private Vector<String> mMessageQueue = new Vector<String>();

	private ServerDispatcher mServerDispatcher;
	private Client mClient;
	private PrintWriter mOut;

	public ClientSender(Client aClient, ServerDispatcher aServerDispatcher) throws IOException {
		mClient = aClient;
		mServerDispatcher = aServerDispatcher;
		Socket socket = aClient.mSocket;
		mOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	/**
	 * Adds given message to the message queue and notifies this thread
	 * (actually getNextMessageFromQueue method) that a message is arrived.
	 * sendMessage is always called by other threads (ServerDispatcher).
	 */
	public synchronized void sendMessage(String aMessage) {
		mMessageQueue.add(aMessage);
		notify();
	}

	/**
	 * Sends a keep-alive message to the client to check if it is still alive.
	 * This method is called when the client is inactive too long to prevent
	 * serving dead clients.
	 */
	public void sendKeepAlive() {
		sendMessage(ChatServer.KEEP_ALIVE_MESSAGE);
	}

	/**
	 * @return and deletes the next message from the message queue. If the queue
	 *         is empty, falls in sleep until notified for message arrival by
	 *         sendMessage method.
	 */
	private synchronized String getNextMessageFromQueue() throws InterruptedException {
		while (mMessageQueue.size() == 0)
			wait();
		String message = (String) mMessageQueue.get(0);
		mMessageQueue.removeElementAt(0);
		return message;
	}

	/**
	 * Sends given message to the client's socket.
	 */
	private void sendMessageToClient(String aMessage) {
		mOut.println(aMessage);
		mOut.flush();
	}

	/**
	 * Until interrupted, reads messages from the message queue and sends them
	 * to the client's socket.
	 */
	public void run() {
		try {
			while (!isInterrupted()) {
				String message = getNextMessageFromQueue();
				sendMessageToClient(message);
			}
		} catch (Exception e) {
			// Commuication problem
		}

		// Communication is broken. Interrupt both listener
		// and sender threads
		mClient.mClientListener.interrupt();
		mServerDispatcher.deleteClient(mClient);
	}
}
