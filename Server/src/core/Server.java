package core;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

import utils.MessageType;
import db.*;
import gameplay.*;

public class Server {
	private ServerSocket serverSocket;
	private HashMap<String, Score> scores;
	private List<String> users;
	private List<GameRoom> gameRooms;
	private int port;
	
	public Server(int port) {
		this.port = port;
		scores = new HashMap<String, Score>();
		users = new ArrayList<String>();
		gameRooms = new ArrayList<GameRoom>();
	}

	public void start() throws IOException {
		System.out.println("Started to listen on port:" + port);
		serverSocket = new ServerSocket(port);

		//Listen for clients. Block till one connects
		System.out.println("Waiting for players...");		
		gameRooms.add(new GameRoom(0)); //create the first room
		while(true) {
			PlayerSocket playerSocket = new PlayerSocket(serverSocket.accept());
			String authMessage = playerSocket.readMessage();
			if (authMessage.startsWith(MessageType.AUTH)) {
				String userName = authMessage.substring(MessageType.AUTH.length());
				if (users.contains(userName)) {
					playerSocket.writeMessage(MessageType.NACK);
					//playerSocket.close(); //FIXME not sure if I should close the connection. 
				}
				playerSocket.writeMessage(MessageType.ACK);
				users.add(userName);
				Score userScore;
				if (scores.containsKey(userName)) {
					userScore = scores.get(userName);
				} else {
					userScore = new Score(userName);
					scores.put(userName, userScore);
				}
				GameRoom lastRoom = gameRooms.get(gameRooms.size() - 1);
				if (!lastRoom.isFull()) {
					Player player = new Player(playerSocket, userName, userScore);
					lastRoom.addPlayer(player);
					player.setGameRoom(lastRoom);
					if (lastRoom.isFull()) {
						if (player == lastRoom.getPlayerOne())
							player.setOpponent(lastRoom.getPlayerTwo());
						else
							player.setOpponent(lastRoom.getPlayerOne());
						lastRoom.startGame();
					}
				} else {
					GameRoom newRoom = new GameRoom(gameRooms.size());
					newRoom.addPlayer(new Player(playerSocket, userName, userScore));
					gameRooms.add(newRoom);
				}
			}
		}
	}
	
	private void populateCountryInformation(String url, String user, String password) {
		DBConnection db = new DBConnection(url, user, password);
		ArrayList<CountryInformation> countriesInfo = 
				(ArrayList<CountryInformation>) db.getCountriesInformation();
		QuestionGenerator.getInstance().setInfo(countriesInfo);	
	}
	
	public void closeConnection() {
		try {
			if (serverSocket != null)
				serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream input = null;
		Server server = null;
		try {
			input = new FileInputStream("config.properties");
			
			// load a properties file
			prop.load(input);
			
			server = new Server(Integer.parseInt(prop.getProperty("listening_port")));
			
			server.populateCountryInformation(prop.getProperty("dburl"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			server.start();
		} catch (Exception e) {
			server.closeConnection();
			e.printStackTrace();
			if (input != null) {
				try {
					input.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	    } 
		
	}

}
