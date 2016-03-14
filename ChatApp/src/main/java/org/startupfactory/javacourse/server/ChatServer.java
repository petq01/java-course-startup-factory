package org.startupfactory.javacourse.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.startupfactory.javacourse.server.threads.ClientListener;
import org.startupfactory.javacourse.server.threads.ClientSender;
import org.startupfactory.javacourse.server.threads.ServerDispatcher;

/**
 * Chat Server is multithreaded chat server. It accepts multiple clients
 * simultaneously and serves them. Clients are able to send messages to the
 * server. When some client sends a message to the server, the message is
 * dispatched to all the clients connected to the server.
 *
 * The server consists of two components - "server core" and "client handlers".
 *
 * The "server core" consists of two threads: - ChatServer - accepts client
 * connections, creates client threads to handle them and starts these threads -
 * ServerDispatcher - waits for messages and when some message arrive sends it
 * to all the clients connected to the server
 *
 * The "client handlers" consist of two threads: - ClientListener - listens for
 * message arrivals from the socket and forwards them to the ServerDispatcher
 * thread - ClientSender - sends messages to the client
 *
 * For each accepted client, a ClientListener and ClientSender threads are
 * created and started. A Client object is also created to maintain the
 * information about the client and is added to the ServerDispatcher's clients
 * list. When some client is disconnected, is it removed from the clients list
 * and both its ClientListener and ClientSender threads are interrupted.
 */
public class ChatServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatServer.class);
	public static final int LISTENING_PORT = 2002;
	public static String KEEP_ALIVE_MESSAGE = "!keep-alive";
	public static int CLIENT_READ_TIMEOUT = 5 * 60 * 1000;
	private static ServerSocket mServerSocket;

	private static ServerDispatcher mServerDispatcher;

	public static void main(String[] args) {
		// Start listening on the server socket
		bindServerSocket();

		// Start the ServerDispatcher thread
		mServerDispatcher = new ServerDispatcher();
		mServerDispatcher.start();

		// Infinitely accept and handle client connections
		handleClientConnections();
	}

	private static void bindServerSocket() {
		try {
			mServerSocket = new ServerSocket(LISTENING_PORT);
			LOGGER.info("ChatServer started on port {} ", LISTENING_PORT);
		} catch (IOException ioe) {
			LOGGER.error("Can not start listening on port {} ", LISTENING_PORT);
			ioe.printStackTrace();
			System.exit(-1);
		}
	}

	private static void handleClientConnections() {
		while (true) {
			try {
				Socket socket = mServerSocket.accept();
				Client client = new Client();
				client.mSocket = socket;
				ClientListener clientListener = new ClientListener(client, mServerDispatcher);
				ClientSender clientSender = new ClientSender(client, mServerDispatcher);
				client.mClientListener = clientListener;
				clientListener.start();
				client.mClientSender = clientSender;
				clientSender.start();
				mServerDispatcher.addClient(client);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}