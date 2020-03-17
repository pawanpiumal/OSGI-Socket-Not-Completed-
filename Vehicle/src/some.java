import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class some {

	public void damn() throws UnknownHostException, IOException {
		BufferedReader in;
		PrintWriter out;
		Socket socket = new Socket("localhost", 9001);
		
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

		out.println("haha");
	}
}
