package NotConnect;

import java.io.IOException;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(4666);
            byte[] sendbuffer;
            byte[] receivebuf = new byte[256];

            DatagramPacket receivepacket = new DatagramPacket(receivebuf, receivebuf.length);
            DatagramPacket sendPacket;
            System.out.println("NotConnect.Server pr�t");
            boolean estActif = true;
            while (estActif) {
                socket.receive(receivepacket);
                System.out.println(new String(receivepacket.getData()));
                InetAddress addr = receivepacket.getAddress();
                int port = receivepacket.getPort();
                sendbuffer = ("Vous �tes connect� depuis la machine " + addr + " et sur le port " + port).getBytes();
                sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, addr, port);
                socket.send(sendPacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
