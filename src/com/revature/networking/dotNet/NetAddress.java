package com.revature.networking.dotNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

//get the ip address for localhost and the hostname for my
//computer using the ietaddress class

public class NetAddress {
	
	public static void main(String[] args) {
		try {
			InetAddress myAddress = InetAddress.getLocalHost();
			System.out.println("My IP Address: " + myAddress);
			
			System.out.println("My Hostname: " + myAddress.getHostName());
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}
}
