package com.revature.networking.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

//just using a random string array generator api
public class HttpUtil {

	private HttpUtil() {

	}

	public static String[] getAllAdvice() {
		URI uri = URI.create("https://www.random.org/strings/?num=150&len=10&upperalpha=on&loweralpha=on&unique=on&format=JSON&rnd=new");
		String[] adviceBank = new String[150];
		HttpURLConnection client = null;
		try {
			client = (HttpURLConnection) uri.toURL().openConnection();

			adviceBank = (String[]) client.getContent();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return adviceBank;
	}

}
