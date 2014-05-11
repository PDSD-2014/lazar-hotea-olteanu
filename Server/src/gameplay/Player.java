package gameplay;

import java.io.IOException;

import utils.GameInfo;
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
	
	public Player(PlayerSocket connection, String name, Score score) {
		this.setConnection(connection);
		this.setName(name);
		this.setScore(score);
		this.gameInfo = new GameInfo(0, null, null);
		this.state = PlayerState.START_GAME;
	}
	
	public void run() {
        try {        	
        	//TODO Repeatedly get commands from the client and process them
            while (true) {
            	switch (this.state) {
            	case START_GAME:
            		//TODO 01: send a message with START_GAME and game info
                	connection.writeMessage(MessageType.START_GAME + gameInfo.JSONToString());
                	state = PlayerState.QUESTION_STATE;
            		break;
            	case QUESTION_STATE:
                	//TODO 02: send a message with a QUESTION
                	connection.writeMessage(MessageType.QUESTION + gameRoom.getCurrentQuestion().JSONToString());
                	//TODO 03: wait for playerResponse for X seconds
                	connection.getSocket().setSoTimeout(TIMEOUT);
                	state = PlayerState.RESPONSE_STATE;
                	break;
            	case RESPONSE_STATE:
            		String response = connection.readMessage();  	
                	if (response.equals("TIMEOUT")) {
                		//TODO 03.1: if the timer expired send a TIMEOUT
                		connection.writeMessage(MessageType.TIMEOUT);
                	} else {
                		//TODO 03.2: else check the answer
                		if (!response.startsWith(MessageType.QUESTION_ANSWER)) {
                			connection.writeMessage(MessageType.WRONG_TYPE);
                			state = PlayerState.RESPONSE_STATE;
                		} else {
                			//TODO 04: update the score
                			if (gameRoom.getCurrentQuestion().getSolution().equals(response.substring(MessageType.QUESTION_ANSWER.length()))) {
                				gameInfo.incScoreOfPlayer(userName);
                				score.addScore(1);
                			}
                		}
                		//remove the timer
                    	connection.getSocket().setSoTimeout(INF);
                		state = PlayerState.RESULT_STATE;
                	}
            		break;
            	case RESULT_STATE:
            		//TODO 05: send the result
            		connection.writeMessage(MessageType.QUESTION_RESPONSE + gameInfo.JSONToString());
            		//TODO 06: getNextQuestion
            		gameRoom.incQuestionNumber();
            		state = PlayerState.QUESTION_STATE;
            		break;
            	case STOP_GAME:
            		//TODO 07: implement it
				default:
					break;
            	}
            }
        } catch (IOException e) {
        } finally {
            this.connection.close();
        }
    }

	
	public void setOpponent(Player opponent) {
        this.opponent = opponent;
        this.gameInfo.setPlayerTwo(opponent.getName());
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
