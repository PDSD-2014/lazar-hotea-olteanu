package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

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
			close();
			System.exit(1);
		}
	}
	
	public String readMessage() {
		String response = null;
		try {
			response = reader.readLine();
		} catch (SocketTimeoutException se) {
			response = "TIMEOUT";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("________" + "IOException: null response" + "_________________" + e);
		}
		return response;
	}
	
    public void writeMessage(String message) {
        try {
			writer.write(message);
			writer.write('\n');
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    }

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void close() {	
		try {
			this.reader.close();
			this.writer.close();
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
