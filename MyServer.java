package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;


    public static void main(String[] args) {
        try{
            try{
                serverSocket = new ServerSocket(4004);
                System.out.println("Сервер запущен");
                clientSocket = serverSocket.accept();

                try{
                    BufferedReader in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    while (true){
                        String text = in.readLine();
                        if (text.equals("end")) break;
                        System.out.println("Сообщение от сервера. Вы написали " + out);
                        out.flush();
                    }
                }finally {
                    System.out.println("Чат закрыт");
                    clientSocket.close();
                }
            } finally {
                System.out.println("Сокет для общения закрыт ");
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
