package ConnectThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Accepter_clients implements Runnable {

    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 0;

    public Accepter_clients(ServerSocket s) {
        socketserver = s;
    }

    public void run() {
        try {
            while (true) {
                nbrclient++;
                socket = socketserver.accept(); // Un client se connecte on l'accepte
                System.out.println("Le client num�ro " + nbrclient + " est connect� !");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

