package com.company.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private OutputStreamWriter outputStreamWriter;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public void start() throws IOException {

        System.out.println("Client is running");
        System.out.println("Type the message");
        Socket socket=new Socket("localhost",9000);

        this.outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        this.inputStreamReader = new InputStreamReader(socket.getInputStream());

        this.bufferedReader = new BufferedReader(inputStreamReader);
        this.bufferedWriter = new BufferedWriter(outputStreamWriter);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String messageToSend = scanner.nextLine();
            bufferedWriter.write(messageToSend);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println("server:- " + bufferedReader.readLine());

            if (messageToSend.equalsIgnoreCase("Good Bye"))
                break;

        }
    }
}
