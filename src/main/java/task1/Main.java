package task1;

import task1.client.Client;
import task1.server.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        new Thread(() -> {
            try (Server server = new Server()) {
                server.start(8080);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Client client = new Client();
            client.connectClient("netology.homework", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

