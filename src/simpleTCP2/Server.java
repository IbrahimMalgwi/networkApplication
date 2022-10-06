package simpleTCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Port 2020 is open.");

        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        outSocket.println("Welcome!");
        String message = inSocket.readLine();
        System.out.println("Client says: " + message);

        socket.close();
        System.out.println("Socket is closed.");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
