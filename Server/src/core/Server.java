package core;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import db.*;
import gameplay.*;

public class Server {
	private ServerSocket serverSocket;
	private int port;
	
	public Server(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("Started to listen on port:" + port);
		serverSocket = new ServerSocket(port);

		//Listen for clients. Block till one connects
		System.out.println("Waiting for players...");
		ArrayList<GameRoom> gameRooms = new ArrayList<GameRoom>();
		gameRooms.add(new GameRoom()); //create the first room
		while(true) {
			Socket client  = serverSocket.accept();
			PlayerSocket player = new PlayerSocket(client);
			GameRoom lastRoom = gameRooms.get(gameRooms.size() - 1);
			if (!lastRoom.isFull()) {
				lastRoom.addPlayer(new Player("N/A", "N/A", player));
				if (lastRoom.isFull())
					lastRoom.startGame();
			} else {
				GameRoom newRoom = new GameRoom();
				newRoom.addPlayer(new Player("N/A", "N/A", player));
				gameRooms.add(newRoom);
			}
		}
	}
	
	private void populateCountryInformation(String url, String user, String password) {
		DBConnection db = new DBConnection(url, user, password);
		ArrayList<CountryInformation> countriesInfo = 
				(ArrayList<CountryInformation>) db.getCountriesInformation();
		QuestionGenerator.getInstance().setInfo(countriesInfo);
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
