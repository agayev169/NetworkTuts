package Multicast;

import java.io.IOException;
import java.net.*;

public class Serveur {

    public static void main(String[] args) {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            byte[] buf = "Hello".getBytes();
            InetAddress group = InetAddress.getByName("230.0.0.2");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4666);
            socket.send(packet);
            System.out.println("paquets envoyes");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
