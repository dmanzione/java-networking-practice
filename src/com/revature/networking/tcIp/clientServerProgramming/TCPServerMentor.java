package com.revature.networking.tcIp.clientServerProgramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.revature.networking.utils.HttpUtil;

public class TCPServerMentor {
	// local storage of advice
	private String[] adviceList = HttpUtil.getAllAdvice();
	
	public void go(String[] args) {




		// set up a socket to wait for clients to
		// open connection, using try-with-resources so the
		// connection will close automatically after
		try (ServerSocket serverSocket = new ServerSocket(4242)) {

			while (true) {

				//after accepting, the server will listen for
				//requests
				Socket socket = serverSocket.accept();

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
