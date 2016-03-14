package org.startupfactory.javacourse.server.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.startupfactory.javacourse.server.ChatServer;
import org.startupfactory.javacourse.server.Client;

public class ClientListener extends Thread {
	private ServerDispatcher mServerDispatcher;
	private Client mClient;
	private BufferedReader mSocketReader;

	public ClientListener(Client aClient, ServerDispatcher aSrvDispatcher) throws IOException {
		mClient = aClient;
		mServerDispatcher = aSrvDispatcher;
		Socket socket = aClient.mSocket;
		socket.setSoTimeout(ChatServer.CLIENT_READ_TIMEOUT);
		mSocketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	/**
	 * Until interrupted, reads messages from the client socket, forwards them
	 * to the server dispatcher's queue and notifies the server dispatcher.
	 */
	public void run() {
		try {
			while (!isInterrupted()) {
				try {
					String message = mSocketReader.readLine();
					if (message == null)
						break;
					mServerDispatcher.dispatchMessage(mClient, message);
				} catch (SocketTimeoutException ste) {
					mClient.mClientSender.sendKeepAlive();
				}
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
			// Problem reading from socket (broken connection)
		}

		// Communication is broken. Interrupt both listener and
		// sender threads
		mClient.mClientSender.interrupt();
		mServerDispatcher.deleteClient(mClient);
	}
}