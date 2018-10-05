package ConnectComplete;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket1;
        PrintWriter out;

        try {
            serverSocket = new ServerSocket(2009);
            System.out.println("Le serveur est � l'�coute du port " + serverSocket.getLocalPort());
            socket1 = serverSocket.accept();
            System.out.println("Un client s'est connect�");
            out = new PrintWriter(socket1.getOutputStream());
            out.println("Vous �tes connect� !");
            out.flush();
            socket1.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}