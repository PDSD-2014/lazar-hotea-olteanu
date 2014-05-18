package com.example.proiectpdsd;

import java.util.Random;

import gameplay.Question;
import utils.GameInfo;
import utils.MessageType;
import android.R.bool;

public class ClientPlay extends Thread{
	Boolean keepAlive;
	public ClientPlay() {
		keepAlive = true;
				// Get and wrap its input stream for reading the response.
	}
	public void run() {
		String msg;
		Random rand = new Random();
		//TODO
		while(keepAlive) {
			//TODO 02: announce the player that the game will start in 5 seconds
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//TODO 03: receive a message with a QUESTION
			msg = Client.player.readMessage();
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
			String response = MessageType.QUESTION_ANSWER + q.getVariants().get(rand.nextInt(4));
			Client.player.writeMessage(response);
			
			//TODO 03.1: simultate the timeout
			
			//TODO 04: receive the response
			msg = Client.player.readMessage();
			//sanity check
			if (msg.equals(MessageType.END_GAME) || msg.equals(MessageType.STOP_GAME)) {
				stopProcess();
				System.out.println("The game stopped");
				continue;
			}
			if (msg.equals(MessageType.TIMEOUT)) {
				System.out.println("The time exceeded");
				//TODO 04.1 read the message with game info
				msg = Client.player.readMessage();
				//sanity check
				if (msg.equals(MessageType.END_GAME) || msg.equals(MessageType.STOP_GAME)) {
					stopProcess();
					System.out.println("The game stopped");
					continue;
				}
			}
			//TODO 05: read the game info and print the result
			if (msg.startsWith(MessageType.QUESTION_RESPONSE)) {
				System.out.println("Received game info " + msg.substring(MessageType.QUESTION_RESPONSE.length()));
				GameInfo gameInfo = GameInfo.generateObject(msg.substring(MessageType.QUESTION_RESPONSE.length()));
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
		Client.player.close();
	}
}
