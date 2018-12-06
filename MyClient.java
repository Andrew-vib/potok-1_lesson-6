package lesson6;

import java.io.*;
import java.net.Socket;

public class MyClient {

    private static Socket clientSocket = null;
    private static BufferedReader readerConsol;
    private static BufferedReader in;
    private static BufferedWriter out;


    public static void main(String[] args) {
        try{
            try{
                clientSocket = new Socket("localhost",4004);

                readerConsol = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                System.out.println("Введите текст");
                while (true){
                    String text = readerConsol.readLine();
                    if(text.equals("end")) break;
                    out.write(text + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    System.out.println(serverWord);
                }
            } finally {
                System.out.println("Клиент был закрыт ");
                clientSocket.close();

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
