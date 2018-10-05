package ConnectComplete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        Socket socket2;
        BufferedReader in;
        try {
            socket2 = new Socket(InetAddress.getLocalHost(), 2009);
            System.out.println("Connecting...");
            in = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            String message_distant = in.readLine();
            System.out.println(message_distant);
            socket2.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}