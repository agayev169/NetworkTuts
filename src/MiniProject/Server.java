package MiniProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket; // ServerSocket of the server
        Socket socket; // Socket of the server
        BufferedReader in; // BufferedReader to read a mathematical expression
        PrintWriter pw; // PrintWriter to send the result to the user

        try {
            serverSocket = new ServerSocket(3456); // Initialize ServerSocket on port #3456
            System.out.println("Server is waiting for a mathematical expression.");
            socket = serverSocket.accept(); // Initialize socket to the given ServerSocket
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Initializing BufferedReader
            // to read the expression
            String expression = in.readLine(); // Reading the expression
            int res = solveExpression(expression);
            System.out.println(expression + " = " + res); // Printing an expression and the result

            pw = new PrintWriter(socket.getOutputStream()); // Initializing PrintWriter to send the result to the user
            pw.println(res); // Sending the result
            pw.flush(); // Flush!
            System.out.println("Server has finished its work.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solveExpression(String expression) {
        int first = getNum(expression); // Get the first number
        expression = deleteNum(expression); // Delete the first number from the expression
        char oper = getOperator(expression); // Get the operator (+, -, *, /)
        int second = getNum(expression); // Get the second number

        int res = -1; // Initializing a default value of the result
        switch (oper) {
            case '+':
                res = first + second;
                break;
            case '-':
                res = first - second;
                break;
            case '*':
                res = first * second;
                break;
            case '/':
                if (second == 0) return res; // If we have division by 0 return -1
                res = first / second;
                break;
        }
        return res;
    }

    private static int getNum(String expression) {
        int res = 0; // Initializing the result
        int i = 0; // Counter
        while (expression.toCharArray()[i] < '0' || expression.toCharArray()[i] > '9') { // Skip everything till the first digit
            i++;
        }
        for (; i < expression.length() && expression.toCharArray()[i] >= '0' &&
                expression.toCharArray()[i] <= '9'; i++) { // Loop to get the number
            res = res * 10 + expression.toCharArray()[i] - '0';
        }
        return res;
    }

    private static char getOperator(String expression) {
        char res; // Initializing the result
        int i = 0; // Counter
        while (i < expression.length() && expression.toCharArray()[i] != '+' &&
                expression.toCharArray()[i] != '-' && expression.toCharArray()[i] != '/' &&
                expression.toCharArray()[i] != '*') { // Skip everything till the operator
            i++;
        }
        res = expression.toCharArray()[i]; // Save an operator as the result
        return res;
    }

    private static String deleteNum(String expression) {
        String newExpression = ""; // newExpression that will be like expression but without first number
        int i = 0; // Counter
        while (i < expression.length() && expression.toCharArray()[i] >= '0' &&
                expression.toCharArray()[i] <= '9') { // Skip everything till the end of the first number
            i++;
        }
        for (; i < expression.length(); i++) { // Loop to save expression without the first number
            newExpression += expression.toCharArray()[i];
        }
        return newExpression;
    }
}
