package parkingprovider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Handler implements Runnable {
	private String name;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public Handler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				String input = in.readLine();

				System.out.println(input);

			}
		} 
		catch (IOException e) {
			System.out.println(e);
			
		} finally {

			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}