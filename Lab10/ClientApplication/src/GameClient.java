import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException{
        String serverAddress = "127.0.0.1";
        int PORT = 7373;
            try {
                Socket socket = new Socket(serverAddress, PORT);

                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String request = scanner.nextLine();
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    if (request.equals("exit")) {
                        System.out.println("Client stopped...");
                        socket.close();
                        System.exit(0);
                    } else {
                        output.println(request);
                    }

                    String response = input.readLine();
                    System.out.println(response);
                }
            }catch(UnknownHostException e){
                System.err.println("No server listening... " + e);
            }

    }
}
