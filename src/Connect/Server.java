package Connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket socketserver;
        Socket socket1;

        try {
            socketserver = new ServerSocket(2009);
            socket1 = socketserver.accept();
            System.out.println("ConnectComplete.ConnectThreads.Multicast.NotConnect.Client is connected!");
            socketserver.close();
            socket1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

