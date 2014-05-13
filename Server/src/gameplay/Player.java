package gameplay;

import utils.GameInfo;

import java.io.IOException;

import utils.MessageType;
import core.PlayerSocket;

public class Player extends Thread {
	private String userName;
	private PlayerSocket connection;
	private Player opponent;
	private Score score;
	private GameRoom gameRoom;
	private GameInfo gameInfo;
	private int TIMEOUT = 10000;
	private int INF = 0;
	private PlayerState state;
	private boolean keepAlive;
	
	public Player(PlayerSocket connection, String name, Score score) {
		this.setConnection(connection);
		this.setUserName(name);
		this.setScore(score);
		this.gameInfo = new GameInfo(0, name, null);
		this.state = PlayerState.START_GAME;
		this.keepAlive = true;
	}
	
	public void run() {
		int qCounter = 0;
		
        try {        	
        	//TODO Repeatedly get commands from the client and process them
            while (keepAlive) {
            	switch (this.state) {
            	case START_GAME:
            		if (connection.getSocket().isOutputShutdown()) {
            			System.err.println("START_GAME ERROR");
            			stopProcess();
            			return;
            		}
            		//TODO 01: send a message with START_GAME and game info
                	connection.writeMessage(MessageType.START_GAME + gameInfo.JSONToString());
                	state = PlayerState.QUESTION_STATE;
            		break;
            	case QUESTION_STATE:
                	//check if we send all the questions
            		if (qCounter >= gameRoom.getNumberOfQuestions()) {
            			System.out.println("END of game");
            			keepAlive = false;
            			connection.writeMessage(MessageType.END_GAME);
            			connection.close();
            			return;
            		}
            		
            		//TODO 02: send a message with a QUESTION
                	if (connection.getSocket().isOutputShutdown()) {
                		System.err.println("QUESTION ERROR");
                		stopProcess();
                		return;
                	} else {
                		connection.writeMessage(MessageType.QUESTION + gameRoom.getCurrentQuestion().JSONToString());
                		gameRoom.incQuestionNumber(); //go to the next question
                		qCounter += 1;
                	}
                	
                	state = PlayerState.RESPONSE_STATE;
                	break;
            	case RESPONSE_STATE:
            		//TODO 03: wait for playerResponse for X seconds
                	connection.getSocket().setSoTimeout(TIMEOUT);
                	
					if (connection.getSocket().isInputShutdown()) {
						System.err.println("RESPONSE_STATE ERROR");
                		stopProcess();
                		return;
					}
            		String response = connection.readMessage();
            		//remove the timer
                	connection.getSocket().setSoTimeout(INF);
                	
                	if (response.equals("TIMEOUT")) {
                		//TODO 03.1: if the timer expired send a TIMEOUT
                		if (connection.getSocket().isOutputShutdown()) {
                			stopProcess();
                    		return;
                		} else {
                			connection.writeMessage(MessageType.TIMEOUT);
                		}
                	} else {
                		//TODO 03.2: else check the answer
                		if (!response.startsWith(MessageType.QUESTION_ANSWER)) {
                    		if (connection.getSocket().isOutputShutdown()) {
                    			System.err.println("QUESTION_ANSWER ERROR");
                    			stopProcess();
                    			return;
                    		}
                			connection.writeMessage(MessageType.WRONG_TYPE);
                			state = PlayerState.RESPONSE_STATE;
                		} else {
                			//TODO 04: update the score
                			if (gameRoom.getCurrentQuestion().getSolution().equals(response.substring(MessageType.QUESTION_ANSWER.length()))) {
                				gameInfo.incScoreOfPlayer(userName);
                				score.addScore(1);
                			}
                		}
                		state = PlayerState.RESULT_STATE;
                	}
            		break;
            	case RESULT_STATE:
            		//TODO 05: send the result
            		if (connection.getSocket().isOutputShutdown()) {
            			System.err.println("START_GAME ERROR");
            			stopProcess();
            			return;
            		}
            		connection.writeMessage(MessageType.QUESTION_RESPONSE + gameInfo.JSONToString());
            		//TODO 06: getNextQuestion
            		gameRoom.incQuestionNumber();
            		state = PlayerState.QUESTION_STATE;
            		break;
				default:
					break;
            	}
            }
        } catch (IOException e) {
        } finally {
            opponent.announceStop();
        	this.connection.close();
        }
        
        connection.close();
    }
	
	public void announceStop() {
		System.out.println("Player " + userName + " exited");
		keepAlive = false;
		connection.writeMessage(MessageType.STOP_GAME);
	}
	
	public void stopProcess() {
		System.out.println("Player " + userName + " exited");
		opponent.announceStop();
		keepAlive = false;
		connection.close();
	}
	
	public void setOpponent(Player opponent) {
        this.opponent = opponent;
        this.gameInfo.setPlayerTwo(opponent.getUserName());
    }

	public PlayerSocket getConnection() {
		return connection;
	}

	public void setConnection(PlayerSocket connection) {
		this.connection = connection;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public GameRoom getGameRoom() {
		return gameRoom;
	}

	public void setGameRoom(GameRoom gameRoom) {
		this.gameRoom = gameRoom;
		this.gameInfo.setRoomId(gameRoom.getRoomId());
	}

}

enum PlayerState {
	START_GAME, QUESTION_STATE, TIMEOUT_STATE,
	RESPONSE_STATE, RESULT_STATE, STOP_GAME;
}
