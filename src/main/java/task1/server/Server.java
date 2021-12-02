package task1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements AutoCloseable {

    public void start(int port) {

        try (ServerSocket serverSocket = new ServerSocket(port); Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("Starting server");

            out.println("Write your name?");
            final String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d. Are you child? (yes/no)", name, clientSocket.getPort()));
            final String answer = in.readLine();

            out.println("success");

            if (answer.equals("yes")) {
                out.printf("Welcome to the kids area, %s! Let's play!\n", name);
            } else if (answer.equals("no")) {
                out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!\n", name);
            } else {
                out.println("The server did not understand your answer.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        System.out.println("Server is closed");
    }
}
