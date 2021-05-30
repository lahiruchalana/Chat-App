package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket;

        Socket socket = null;
        serverSocket = new ServerSocket(9000);
        System.out.println("Server is running..");
        Scanner scanner = new Scanner(System.in);////////////////////////


        while (true) {

            try {

                socket = serverSocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter (socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true) {

                    String messageFromClient = bufferedReader.readLine();
                    System.out.println("Client:- " + messageFromClient);

                    messageFromClient = scanner.nextLine();///////////////////
                    bufferedWriter.write(messageFromClient);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (messageFromClient.equalsIgnoreCase("Good Bye"))
                        break;
                }

                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedWriter.close();
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
