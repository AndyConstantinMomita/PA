import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    public ClientThread(Socket socket) { this.socket = socket; }
    public void run() {
        try{
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            String request;
            while((request = input.readLine()) != null) {
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                if (request.equals("stop")){
                    System.out.println("Server stopped...");
                    socket.close();
                    System.exit(0);
                }
                else {
                    output.println("Server received the request...");
                    output.flush();
                }
            }
            socket.close();
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
