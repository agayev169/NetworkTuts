package ConnectThreads;

import java.io.IOException;
import java.net.*;

public class Serveur {

    public static void main(String[] args) {

        ServerSocket socket;

        try {
            socket = new ServerSocket(2009);
            Thread t = new Thread(new Accepter_clients(socket));
            t.start();
            System.out.println("ConnectThreads.Multicast.NotConnect.Server pr�t pour servir plusieurs clients !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


