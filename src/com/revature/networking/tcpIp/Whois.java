package com.revature.networking.tcpIp;

import java.io.*;
import java.net.Socket;

//Trying out only client socket

public class Whois {

	public static void main(String[] args) {

		int c;

		// creates a socket that is connected to the internic.net, port 43
		try (Socket s = new Socket("whois.internic.net", 43)) {

			// obtain input and output streams
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();

			// construct a request string
			String str = (args.length == 0 ? "bookmarks.com" : args[0]) + "\n";

			// convert to bytes
			byte[] buf = str.getBytes();

			// send request
			out.write(buf);

			// read and display respone
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
