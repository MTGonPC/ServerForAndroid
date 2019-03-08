

import java.io.*;
import java.net.*;

public class RClient {
	private Socket socket = null;
	private BufferedReader input = null;
	
	public RClient(String address, int port) {
		//Attempt connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connection Established");
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch(UnknownHostException ex) {
			System.out.println(ex);
			System.exit(-1);
		} catch(IOException ex) {
			System.out.println(ex);
			System.exit(-1);
		}
		while(true){
         try{
            System.out.println(input.readLine());
         } catch(IOException ex) {
            System.exit(-1);
         } 
      }
  	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		RClient client = new RClient("127.0.0.1",42424);
	}
	
}
