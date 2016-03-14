package org.startupfactory.javacourse.server.threads;

import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.startupfactory.javacourse.server.Client;

/**
 * ServerDispatcher class is purposed to listen for messages received from the
 * clients and to dispatch them to all the clients connected to the chat server.
 */
public class ServerDispatcher extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerDispatcher.class);
	private Vector<String> mMessageQueue = new Vector<String>();
	private Vector<Client> mClients = new Vector<Client>();

	/**
	 * Adds given client to the server's client list.
	 */
	public synchronized void addClient(Client aClient) {
		mClients.add(aClient);

	}

	/**
	 * Deletes given client from the server's client list if the client is in
	 * the list.
	 */
	public synchronized void deleteClient(Client aClient) {
		int clientIndex = mClients.indexOf(aClient);
		if (clientIndex != -1)
			mClients.removeElementAt(clientIndex);
	}

	/**
	 * Adds given message to the dispatcher's message queue and notifies this
	 * thread to wake up the message queue reader (getNextMessageFromQueue
	 * method). dispatchMessage method is called by other threads
	 * (ClientListener) when a message is arrived.
	 */
	public synchronized void dispatchMessage(Client aClient, String aMessage) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		new Date();
		Calendar cal = Calendar.getInstance();

		Socket socket = aClient.mSocket;
		String senderIP = socket.getInetAddress().getHostAddress();
		String senderPort = "" + socket.getPort();
		aMessage = senderIP + ":" + senderPort + " : " + dateFormat.format(cal.getTime()) + "  >> " + aMessage;
		mMessageQueue.add(aMessage);
		notify();
	}

	/**
	 * @return and deletes the next message from the message queue. If there is
	 *         no messages in the queue, falls in sleep until notified by
	 *         dispatchMessage method.
	 */
	private synchronized String getNextMessageFromQueue() throws InterruptedException {
		while (mMessageQueue.size() == 0)
			wait();
		String message = (String) mMessageQueue.get(0);
		mMessageQueue.removeElementAt(0);
		return message;
	}

	/**
	 * Sends given message to all clients in the client list. Actually the
	 * message is added to the client sender thread's message queue and this
	 * client sender thread is notified to process it.
	 */
	private void sendMessageToAllClients(String aMessage) {
		for (int i = 0; i < mClients.size(); i++) {
			Client client = (Client) mClients.get(i);
			client.mClientSender.sendMessage(aMessage);
		}
	}

	/**
	 * Infinitely reads messages from the queue and dispatches them to all
	 * clients connected to the server.
	 */
	public void run() {
		try {
			while (true) {
				String message = getNextMessageFromQueue();
				sendMessageToAllClients(message);
			}
		} catch (InterruptedException ie) {
			LOGGER.error("Interrupted!");
			// Thread interrupted. Stop its execution
		}
	}
}