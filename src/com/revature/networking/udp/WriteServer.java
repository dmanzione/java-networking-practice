package com.revature.networking.udp;

import java.io.IOException;
//Demonstrate datagrams
import java.net.*;

public class WriteServer {

	public static int serverPort = 998;
	public static int clientPort = 999;
	public static int buffer_size = 1024;
	public static DatagramSocket ds;
	public static byte[] buffer = new byte[buffer_size];

	
	/* open terminal, write 
	 * 				
	 * 									$ java WriterServer                     // opens client at port 998 								
	 * 
	 *   (in another terminal tab)	    $ java WriterServer 1        			// opens server at port 999   
	 * 
	 * 
	 * 					- Then, TheServer() method runs, takes input from user using InputStream (bytes)
	 *					- puts input in a byte array (the buffer),
	 *					- packs buffer in a datagram,
	 *					- sends it to client via dynamically retrieved address + port 998
	 *
	 *					result: client receives our input on their terminal tab.
	 *
	 *
	 */			
	
	public static void TheServer() {

		int pos = 0;

		try {
			while (true) {

				int c;
				c = System.in.read();
				switch (c) {

				case -1:
					System.out.println("Server Quits.");
					ds.close();
					return;
				case '\r':
					break;
				case '\n':
					ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
					pos = 0;
					break;
				default:
					buffer[pos++] = (byte) c;
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void TheClient() {

		try {
			while (true) {
				DatagramPacket p = new DatagramPacket(buffer, buffer.length);
				ds.receive(p);

				System.out.println(new String(p.getData(), 0, p.getLength()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			if(args.length==1) {

			
				ds = new DatagramSocket(serverPort);
				TheServer();
			}else {
				ds = new DatagramSocket(clientPort);
				TheClient();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
