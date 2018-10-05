package NotConnect;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        InetAddress addr;
        try {
            addr = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = "Bonjour".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, addr, 4666);
            buf = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(buf, buf.length, addr, 4666);
            socket.send(sendPacket);
            socket.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
