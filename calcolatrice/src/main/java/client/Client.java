package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public void avvia(){
        try(Socket client = new Socket("localhost", 12345)){
            System.out.println("Connesso al server!");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream());
            Scanner scan = new Scanner(System.in);

            System.out.println
        }
        catch(IOException e){

        }
    }
}
