package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public void avvia(){
        try(Socket client = new Socket("localhost", 12345)){
            System.out.println("Connesso al server!");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner scan = new Scanner(System.in);

            System.out.println("Benvenuto nella calcolatrice! Inserisci un'operazione (es. 2 + 2) o 'exit' per uscire:");
            String input;
            while(!(input = scan.nextLine()).equals("exit")){
                out.println(input);
                out.flush();
                System.out.println("Risultato: " + in.readLine());
            }

        }
        catch(IOException e){
            System.out.println("Errore di connessione: " + e.getMessage());
        }
    }
}
