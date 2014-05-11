package com.example.proiectpdsd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

public class Client {
	final String TAG = "ClientSocket";
	
	// The address and port of the server.
	final String HOST = "127.0.0.1";
	final int PORT = 9000;
	
	public Client() {
		// Create then start the "worker" thread.
		new Thread(new Runnable() {
			@Override
			public void run() {
				// The text field that is to be updated.
				//final EditText responseGreetingField = (EditText)findViewById(R.id.response);
				String response = "";
				try {
					// Open the socket.
					Socket clientSocket = new Socket(HOST, PORT);
					// Get and wrap its input stream for reading the response.
					BufferedReader responseReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					// Do the actual reading.
					response = responseReader.readLine();
					
					// Send a request to server
					PrintWriter requestWriter = new PrintWriter(clientSocket.getOutputStream(), true);
					
					// Release the resource.
					clientSocket.close();
				} catch (UnknownHostException e) {
					Log.e(TAG, "Unknown host");
					//Toast.makeText(MainActivity.this, "Unknown host.", Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					Log.e(TAG, "Error opening client socket.");
					//Toast.makeText(MainActivity.this, "Cannot open socket..", Toast.LENGTH_SHORT).show();
				}
	
				// We need a final local variable in order to access it from an inner class.
				//final String response = responseGreeting;
	
				// Do the UI update.
//				responseGreetingField.post(new Runnable() {
//					@Override
//					public void run() {
//						if (response != null) {
//							// Set the contents of the text field to the received response.
//							responseGreetingField.setText(response);
//						} else {
//							Toast.makeText(MainActivity.this, "Your friend said nothing.", Toast.LENGTH_SHORT).show();
//						}
//					}	
//				});
			}
		}).start();
	}
}
