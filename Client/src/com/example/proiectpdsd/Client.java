package com.example.proiectpdsd;

import gameplay.Question;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import utils.GameInfo;
import utils.MessageType;
import android.content.Intent;
import android.util.Log;
import core.PlayerSocket;

public class Client extends Thread {
	final String TAG = "ClientSocket";
	
	// The address and port of the server.
	final String HOST = "10.6.4.153";
	final int PORT = 9999;
	public static PlayerSocket player;
	private boolean keepAlive;
	static public GameInfo gInfoInitial;
	public Client() {
		keepAlive = true;
				// Get and wrap its input stream for reading the response.
	}
	void StartPlayActivity() {
		Intent intent = new Intent(MainActivity.interfaceHandler.activity.getBaseContext(),PlayActivity.class);
		MainActivity.interfaceHandler.activity.startActivity(intent);

	}
	public void run() {
		String msg;
		Random rand = new Random();
		Log.d("run", "run");
		
		try {
			Log.d("run", "aici");
			player = new PlayerSocket(new Socket(HOST, PORT));
			Log.d("run", "aici2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

		if (player == null) {
			Log.d("nasol","Failed to connect to server");
			System.exit(1);
		}
		
		//TODO 01: authentication
		//TODO 01.1 send a message with AUTH header and a random user name
		//player.writeMessage(MessageType.AUTH + "Claudiu" + rand.nextInt(100));
		player.writeMessage(MessageType.AUTH + MainActivity.interfaceHandler.GetUserName());
		System.out.println("AUTH message sent");
		//TODO 01.2 read the response
		msg = player.readMessage();
		System.out.println("new message received");
		//TODO 01.3 check if user name is good
		if (msg.equals(MessageType.ACK)) {
			System.out.println("Valid username. Waiting for the START_GAME message");
		//	MainActivity.interfaceHandler.StopProgressBar();
			msg = player.readMessage();
			//TODO 01.4: receive a message with START_GAME and game info
			if (msg.startsWith(MessageType.START_GAME)) {
				System.out.println("START GAME! Game info:");
				gInfoInitial = GameInfo.generateObject(msg.substring(MessageType.START_GAME.length()));
				StartPlayActivity();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(PlayActivity.ih == null)
					Log.d("null","ih null");
				if(gInfoInitial == null)
					Log.d("null","gi null");
				
				System.out.println(gInfoInitial);
			}
			else {
				System.out.println("Expecting for START_GAME message but received : " + msg);
				return;
			}
		} else if (msg.equals(MessageType.NACK)){
			System.out.println("Invalid username! Search for a new one");
			//TODO try with a new user
			return;
		} else {
			System.out.println("Expecting for the message to contain ACK or NACK but received : " + msg);
			return;
		}
		
		//TODO
		while(keepAlive) {
			//TODO 02: announce the player that the game will start in 5 seconds
						
			//TODO 03: receive a message with a QUESTION
			msg = player.readMessage();
			//sanity check
			if (msg.equals(MessageType.END_GAME) || msg.equals(MessageType.STOP_GAME)) {
				stopProcess();
				System.out.println("The game stopped");
				continue;
			}
			System.out.println("----------");
			System.out.println(msg);
			Question q;
			if (msg.startsWith(MessageType.QUESTION)) {
				System.out.println("Question received");
				q = Question.generateObject(msg.substring(MessageType.QUESTION.length()));
				PlayActivity.ih.UpdateQuestion(q);
				System.out.println(q.toString());
			} else {
				System.out.println("Failed! Expecting a question and received: " + msg);
				break;
			}
			//TODO 03: send the response to the server
			//simulate a random answer
	//		String response = MessageType.QUESTION_ANSWER + q.getVariants().get(rand.nextInt(4));
		//	player.writeMessage(response);
			
			//TODO 03.1: simultate the timeout
			
			//TODO 04: receive the response
			msg = player.readMessage();
			//sanity check
			if (msg.equals(MessageType.END_GAME) || msg.equals(MessageType.STOP_GAME)) {
				stopProcess();
				System.out.println("The game stopped");
				continue;
			}
			
			//TODO 05: read the game info and print the result
			if (msg.startsWith(MessageType.QUESTION_RESPONSE)) {
				System.out.println("Received game info " + msg.substring(MessageType.QUESTION_RESPONSE.length()));
				GameInfo gameInfo = GameInfo.generateObject(msg.substring(MessageType.QUESTION_RESPONSE.length()));
				PlayActivity.ih.UpdateScore(gameInfo);
				System.out.println(gameInfo.toString());
			} else {
				System.out.println("Failed! Expecting game info and received: " + msg);
				break;
			}
			
			//TODO 06: prepare the player for the next Question
			System.out.println("-------- NEXT QUESTION -----------");
		}
	}
	
	public void stopProcess() {
		keepAlive = false;
		player.close();
	}
	
	public static void main(String[] args) {
		Client player = new Client();
		player.start();
	}
}
