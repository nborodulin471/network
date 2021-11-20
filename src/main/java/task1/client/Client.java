package task1.client;

import task1.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void connectClient(String host, int port) throws IOException {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String resp = in.readLine();
                    if(resp.equals("success")){
                       break;
                    }
                    System.out.println(resp);
                    String s = scanner.nextLine();
                    out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                String resp = in.readLine();
                System.out.println(resp);
            }
        }
    }
}
