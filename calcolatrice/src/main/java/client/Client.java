package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public void avvia(){
        // Creazione del socket e connessione al server
        try(Socket client = new Socket("localhost", 12345)){
            System.out.println("Connesso al server!");
            // Creazione dei flussi di input e output
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            // Creazione dello scanner per leggere l'input dell'utente
            Scanner scan = new Scanner(System.in);
            
            // Ciclo per leggere l'input dell'utente e inviarlo al server
            System.out.println("Benvenuto nella calcolatrice! Inserisci un'operazione, dividi tutto con uno spazio o 'exit' per uscire:");
            String input;
            while(!(input = scan.nextLine()).equals("exit")){
                // Invio dell'input al server
                out.println(input);
                out.flush();
                System.out.println( in.readLine());
            }

        }
        // Gestione delle eccezioni
        catch(IOException e){
            System.out.println("Errore di connessione: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
