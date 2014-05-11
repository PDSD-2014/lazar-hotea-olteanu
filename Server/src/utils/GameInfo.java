package utils;

import org.json.simple.*;


public class GameInfo {
	private int roomId;
	private String playerOne;
	private String playerTwo;
	
	public GameInfo(int roomId, String playerOne, String playerTwo) {
		this.setRoomId(roomId);
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerOne);
	}
	
	public static GameInfo generateObject(String json) {
		int roomId;
		String playerOne;
		String playerTwo;
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
		
		return result.toString();
	}
	
	public String JSONToString() {
		JSONObject obj = new JSONObject();
		obj.put("roomId", roomId);
		obj.put("playerOne", playerOne);
		obj.put("playerTwo", playerTwo);
		
		return obj.toString();
	}
}
