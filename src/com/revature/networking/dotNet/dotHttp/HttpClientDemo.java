package com.revature.networking.dotNet.dotHttp;

import java.net.http.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class HttpClientDemo {
	
	/* 
	 
	 
	 you put in the webpage you want to submit a request to
	 from the command line, or 
	 
	 
	 comment out the String object called you could also type it directly below and comment 
	 out the Scanner
	 
	 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Type the web address: ");
		Scanner sc = new Scanner(System.in);
		
		
		String	userInput=sc.nextLine();
		sc.close();
		
		HttpClient myHC = HttpClient.newHttpClient();
		
	
		
		try {
			
			//Create a request
			
			HttpRequest myReq = HttpRequest.newBuilder(new URI(userInput)).build();

			
			//SEND REQUEST and GET RESPONSE using input stream for the body
			
			HttpResponse<InputStream> myResp = myHC.send(myReq, HttpResponse.BodyHandlers.ofInputStream());
			
			
			
			//Display response code and response method
			System.out.println("Response code is " + myResp.statusCode());
			
			System.out.println("Request method is " + myReq.method());
			
			//Get headers from the response
			
			HttpHeaders hdrs = myResp.headers();
			
			
			//Get a map of the headers
			
			Map<String, List<String>> hdrMap = hdrs.map();
			Set<String> hdrField = hdrMap.keySet();
			
			System.out.println("\nHere is the header:");
			
			//Display all header keys and values
			for(String k : hdrField)
				System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
			
			
			// Display the body
			System.out.println("\nHere is the body:" );
			
			InputStream input = myResp.body();
			int c1;
			while((c1= input.read()) != -1) {
				System.out.print((char)c1);
			}
			
			Thread.sleep(750);
			
			System.out.println("...But let's catch that pokemon!...");
			
			
		} catch (IOException | InterruptedException e) {
		
			e.printStackTrace();
		}catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		
				
				
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		
		
		
	}
}
