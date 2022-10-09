package com.revature.networking.tcIp.clientServerProgramming;

import java.net.Socket;
import java.io.*;
import java.net.*;



//This class encapsulates client in a client-server TCP connection 
//where advice is sent from a server to a client
//upon request
public class TCPClientMentee {


	//this method will open the socket and close it before it's done
	public void go() {
		try {

			
			// this is how a client socket connects to a 
			// server socket, but since they're both me... i think 
			//it's fine if they have the same ip?
			
			// get localhost ip address like 
			//I learned in com.revature.networking.dotNet.NetAddress
		
			int port = 4242;
			InetAddress address = InetAddress.getLocalHost();

			//use try-with-resources in order to close the socket automatically
			try (Socket s = new Socket(address, port)) {
				
				//set up a connection at that socket at that ip 
				// that will receive my requests
				InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
				
				
				//filter stream through buffer so we only have
				//to store value after a new line I think
				BufferedReader br = new BufferedReader(streamReader);
			
				String advice = br.readLine(); // only reads when there's a new line
				
				//print advice you received from server
				System.out.println("Today's advice is: " + advice);
			
			
			}
			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	
	
}
