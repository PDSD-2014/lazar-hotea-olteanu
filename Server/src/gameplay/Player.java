package gameplay;

import java.net.Socket;

import core.PlayerSocket;

public class Player {
	private String name;
	private String uuid;
	private PlayerSocket connection;
	
	public Player(String name, String uuid, PlayerSocket connection) {
		this.setName(name);
		this.setUuid(uuid);
		this.setConnection(connection);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public PlayerSocket getConnection() {
		return connection;
	}

	public void setConnection(PlayerSocket connection) {
		this.connection = connection;
	}
}
