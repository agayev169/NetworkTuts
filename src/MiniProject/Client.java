package MiniProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket; // Socket of the client
        PrintWriter pw; // PrintWriter to send data to server
        Scanner sc = new Scanner(System.in); // Scanner to read data from user
        BufferedReader in; // BufferedReader to read the result of the mathematical expression from server

        try {
            socket = new Socket(InetAddress.getLocalHost(), 3456); // Connect to port # 3456
            pw = new PrintWriter(socket.getOutputStream()); // Initialize PrintWriter to send data to server
            System.out.print("Mathematical expression: "); // Asking the user to write down the mathematical expression
            String expression = sc.nextLine();
            pw.println(expression); // Sending the expression to the server
            pw.flush();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Initializing BufferedReader
            // to read the result
            int res = Integer.parseInt(in.readLine()); // Saving the result into res variable
            System.out.println(expression + " = " + res); // Printing the result
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
