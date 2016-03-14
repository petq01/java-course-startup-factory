package org.startupfactory.javacourse.server;

import java.net.Socket;

import org.startupfactory.javacourse.server.threads.ClientListener;
import org.startupfactory.javacourse.server.threads.ClientSender;

public class Client {

	public Socket mSocket = null;
	public ClientListener mClientListener = null;
	public ClientSender mClientSender = null;

}
