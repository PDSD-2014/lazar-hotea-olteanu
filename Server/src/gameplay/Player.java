package gameplay;

import java.io.IOException;

import core.PlayerSocket;

public class Player extends Thread {
	private String userName;
	private PlayerSocket connection;
	private Player opponent;
	private Score score;
	private GameRoom gameRoom;
	
	public Player(PlayerSocket connection, String name, Score score) {
		this.setConnection(connection);
		this.setName(name);
		this.setScore(score);
	}
	
	public void run() {
        try {
        	//TODO Repeatedly get commands from the client and process them.
            while (true) {
            	//TODO 01: send a message with START_GAME and game info
            	//TODO 02: send a message with a QUESTION
            	//TODO 03: wait for playerResponse for X seconds
            	//TODO 03.1: if the timer expired send a TIMEOUT question
            	//TODO 03.2: else check the answer
            	//TODO 04: update the score
            	//TODO 05: send the result
            	//TODO 06: goto 02
            	connection.readMessage();
            }
        } catch (IOException e) {
        } finally {
            this.connection.close();
        }
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

}
