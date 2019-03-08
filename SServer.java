import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SServer {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataOutputStream out;
    public SServer(int port) {
        try{
            server = new ServerSocket(port);
            server.setSoTimeout(30000);
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }

        try {
            socket = server.accept();
            out = new DataOutputStream(socket.getOutputStream());
        }catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }

    }

    public void send() {
        try{
            out.writeUTF("OK");
        } catch(IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }

    public void closeServer() {
        try{
            out.flush();
            out.close();
            socket.close();
            server.close();
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(-1);
        }
    }
    public static void main(String[] hoovy) {
      SServer s = new SServer(42424);
      s.send();
      s.closeServer();
    }
}


