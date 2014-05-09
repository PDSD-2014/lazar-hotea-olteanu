package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PlayerSocket {
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public PlayerSocket(Socket socket) {
		this.setSocket(socket);
		try {
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String readMessage() throws IOException {
		StringBuffer message = new StringBuffer();
        String input;
		while ((input = reader.readLine()) != null) {
            message.append(input);
        }
		return message.toString();
	}
	
    public void writeMessage(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
