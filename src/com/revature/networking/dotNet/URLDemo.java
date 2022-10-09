package com.revature.networking.dotNet;
// Demonstrate URL
import java.net.*;
public class URLDemo {

	public static void main(String[] args) {
		try {
			URL hp = new URL("http://www.HerbSchildt.com/WhatsNew");
			
			System.out.println("Protocol: " + hp.getProtocol());
			
			System.out.println("Port: " + hp.getPort());
			
			System.out.println("Host: " + hp.getHost());
			
			System.out.println("File: "+ hp.getFile());
			
			System.out.println("Ext: " + hp.toExternalForm());
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
	
}
