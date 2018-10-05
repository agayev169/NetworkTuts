package Multicast;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {

        try {
            InetAddress addr = InetAddress.getByName("230.0.0.2");
            MulticastSocket socket = new MulticastSocket(4666);
            socket.joinGroup(addr);
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
