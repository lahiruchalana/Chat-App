package com.company.client;

import java.io.IOException;

public class ChatClient2 {
    public static void main(String[] args) throws IOException {


        Client client = new Client();
        client.start();

        System.out.println("Client finished the execution...");

    }
}
