package gameplay;

import utils.GameInfo;

import java.io.IOException;
import java.net.SocketTimeoutException;

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
	private boolean waitForOpponent;
	
	public Player(PlayerSocket connection, String name, Score score) {
		this.setConnection(connection);
		this.setUserName(name);
		this.setScore(score);
		this.state = PlayerState.START_GAME;
		this.keepAlive = true;
		this.waitForOpponent = true;
	}
	
	public void run() {
		int qCounter = 0;
		Question question = null;
		
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
                		question = gameRoom.getQuestionNumber(qCounter);
                		connection.writeMessage(MessageType.QUESTION + question.JSONToString());
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
                			System.out.println("TIMEOUT: Counter value: " + qCounter);
                			connection.writeMessage(MessageType.TIMEOUT);
                		}
                		// FIXME: After TIMEOUT, we should send a RESULT_STATE?
                		state = PlayerState.RESULT_STATE;
                	} else {
                		//TODO 03.2: else check the answer
                		System.out.println("____________ Counter value: " + qCounter);
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
                			System.out.println("Solution : " + question.getSolution() + " Answer " + response.substring(MessageType.QUESTION_ANSWER.length()) + " Player " + userName);
                			if (question.getSolution().equals(response.substring(MessageType.QUESTION_ANSWER.length()))) {
                				gameInfo.incScoreOfPlayer(userName);
                				score.addScore(1);
                			}
                		}
                		state = PlayerState.RESULT_STATE;
                	}
            		break;
            	case RESULT_STATE:
            		//TODO 05.1: announce the opponent that you reached this point
            		opponent.stopWaiting();
            		//TODO 05.2: wait for opponent's answer
            		while(waitForOpponent){	//WORST SYNCHRONIZATION EVER:))))
            			opponent.stopWaiting();
            		};
            
            		//TODO 05.3: send the result
            		if (connection.getSocket().isOutputShutdown()) {
            			System.err.println("START_GAME ERROR");
            			stopProcess();
            			return;
            		}
            		System.out.println("--- " + gameInfo);
            		connection.writeMessage(MessageType.QUESTION_RESPONSE + gameInfo.JSONToString());
            		System.out.println(gameInfo.JSONToString());
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
		System.out.println("Player " + userName + " exited _test?_");
		opponent.announceStop();
		keepAlive = false;
		connection.close();
	}
	
	public void setOpponent(Player opponent) {
        this.opponent = opponent;
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
	}
	
	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}

	public boolean isWaitForOpponent() {
		return waitForOpponent;
	}

	public void setWaitForOpponent(boolean waitForOpponent) {
		this.waitForOpponent = waitForOpponent;
	}
	
	public void stopWaiting() {
		this.waitForOpponent = false;
	}

}

enum PlayerState {
	START_GAME, QUESTION_STATE, TIMEOUT_STATE,
	RESPONSE_STATE, RESULT_STATE, STOP_GAME;
}
