package utils;

import org.json.simple.*;


public class GameInfo {
	private int roomId;
	private String playerOne;
	private String playerTwo;
	private int playerOneScore;
	private int playerTwoScore;
	
	public GameInfo(int roomId, String playerOne, String playerTwo) {
		this.setRoomId(roomId);
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerOne);
		this.setPlayerOneScore(0);
		this.setPlayerTwoScore(0);
	}
	
	public static GameInfo generateObject(String json) {
		int roomId;
		String playerOne;
		String playerTwo;
		String playerOneScore;
		String playerTwoScore;
		JSONObject obj = (JSONObject)JSONValue.parse(json);
		
		if (!obj.containsKey("roomId") || !obj.containsKey("playerOne") || !obj.containsKey("playerTwo"))
			return null;
		
		roomId = (int)obj.get("roomId");
		playerOne = (String)obj.get("playerOne");
		playerTwo = (String)obj.get("playerTwo");
		
		return new GameInfo(roomId, playerOne, playerTwo);
	}
	
	public int getRoomId() {
		return roomId;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String getPlayerOne() {
		return playerOne;
	}
	
	public void setPlayerOne(String playerOne) {
		this.playerOne = playerOne;
	}
	
	public String getPlayerTwo() {
		return playerTwo;
	}
	
	public void setPlayerTwo(String playerTwo) {
		this.playerTwo = playerTwo;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Room: ");
		result.append(roomId);
		result.append(" | ");
		result.append("Player one: ");
		result.append(playerOne);
		result.append(" | ");
		result.append("Player two: ");
		result.append(playerTwo);
		result.append(" | ");
		result.append("Score player one : ");
		result.append(playerOneScore);
		result.append(" | ");
		result.append("Score player two: ");
		result.append(playerTwoScore);
		
		return result.toString();
	}
	
	public String JSONToString() {
		JSONObject obj = new JSONObject();
		obj.put("roomId", roomId);
		obj.put("playerOne", playerOne);
		obj.put("playerTwo", playerTwo);
		obj.put("playerOneScore", playerOneScore);
		obj.put("playerTwoScore", playerTwoScore);
		
		return obj.toString();
	}

	public int getPlayerOneScore() {
		return playerOneScore;
	}

	public void setPlayerOneScore(int playerOneScore) {
		this.playerOneScore = playerOneScore;
	}

	public int getPlayerTwoScore() {
		return playerTwoScore;
	}

	public void setPlayerTwoScore(int playerTwoScore) {
		this.playerTwoScore = playerTwoScore;
	}
	
	public void incPlayerOneScore() {
		this.playerOneScore += 1;
	}
	
	public void incPlayerTwoScore() {
		this.playerTwoScore += 1;
	}
	
	public void incScoreOfPlayer(String playerName) {
		if (this.playerOne.equals(playerName)) {
			this.playerOneScore += 1;
		} else if (this.playerTwo.equals(playerName)) {
			this.playerTwoScore += 1;
		}
	}
}
