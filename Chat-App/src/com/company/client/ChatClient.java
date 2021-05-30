package com.company.client;

import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        System.out.println("Client finished the execution...");

    }

}
