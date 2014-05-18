package core;
import gameplay.CountryInformation;
import gameplay.GameRoom;
import gameplay.Player;
import gameplay.QuestionGenerator;
import gameplay.Score;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import utils.GameInfo;
import utils.MessageType;
import db.DBConnection;

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
			System.out.println("Player added");
			String authMessage = playerSocket.readMessage();
			System.out.println("AUTH message received");
			if (authMessage.startsWith(MessageType.AUTH)) {
				String userName = authMessage.substring(MessageType.AUTH.length());
				if (users.contains(userName)) {
					playerSocket.writeMessage(MessageType.NACK);
					playerSocket.close(); //FIXME not sure if I should close the connection.
					//FIXME it should wait for another message of AUTH or generate a valid username
					continue;
				}
				playerSocket.writeMessage(MessageType.ACK);
				users.add(userName);
				System.out.println ("User " + userName + " connected");
				Score userScore;
				if (scores.containsKey(userName)) {
					userScore = scores.get(userName);
				} else {
					userScore = new Score(userName);
					scores.put(userName, userScore);
				}
				GameRoom lastRoom = gameRooms.get(gameRooms.size() - 1);
				System.out.println("_____Last Room____" + lastRoom.getNumberOfQuestions());
				System.out.println("_______________Check Room_________" + gameRooms.size());
				if (!lastRoom.isFull()) {
					Player player = new Player(playerSocket, userName, userScore);
					lastRoom.addPlayer(player);
					player.setGameRoom(lastRoom);
					if (lastRoom.isFull()) {
						System.out.println("_____Last Room 22____" + lastRoom.getNumberOfQuestions() + " " +
								lastRoom.getPlayerOne().getUserName() + " " + lastRoom.getPlayerTwo().getUserName());
						GameInfo gameInfo = new GameInfo(lastRoom.getRoomId(), 
								lastRoom.getPlayerOne().getUserName(),
								lastRoom.getPlayerTwo().getUserName());
						if (player == lastRoom.getPlayerOne()) {
							player.setOpponent(lastRoom.getPlayerTwo());
							lastRoom.getPlayerTwo().setOpponent(player);
						} else {
							player.setOpponent(lastRoom.getPlayerOne());
							lastRoom.getPlayerOne().setOpponent(player);
						}
						lastRoom.getPlayerOne().setGameInfo(gameInfo);
						lastRoom.getPlayerTwo().setGameInfo(gameInfo);
						lastRoom.startGame();
					}
				} else {
					System.out.println("_______________New Room_________" + gameRooms.size());
					GameRoom newRoom = new GameRoom(gameRooms.size());
					
					Player newPlayer = new Player(playerSocket, userName, userScore);
					newRoom.addPlayer(newPlayer);
					newPlayer.setGameRoom(newRoom);
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
			PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
			input = new FileInputStream("config.properties");
			System.out.println("wadawdwad");
			if(input == null)
				writer.println("da sigur");
			// load a properties file
			if(prop == null)
				writer.println("da sigur1");

			prop.load(input);
			
			server = new Server(Integer.parseInt(prop.getProperty("listening_port")));
			if(server == null) {
				writer.println("da sigur2");

			}
			writer.close();
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
