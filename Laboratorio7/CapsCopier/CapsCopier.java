import java.util.*;
import java.io.*;

public class CapsCopier{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Inserisci il nome del file da modificare: ");
        String inputFile = console.next();

        System.out.print("Inserisci il nome del file in cui verranno scritte le modifiche: ");
        String outputFile = console.next();

        console.close();

        try(FileReader r = new FileReader(inputFile)){

            try(PrintWriter out = new PrintWriter(outputFile); Scanner scan = new Scanner(r)){
            String formatted = "";
            // Si usa lo scanner con i suoi metodi hasNext, next, nextInt, nextDouble,    
            // nextLine a seconda delle esigenze
            scan.useDelimiter("[\n'\\s]+");
            while(scan.hasNext())
            {
                String token = scan.next();
                //System.out.print(token);
                formatted += token.substring(0,1).toUpperCase() + token.substring(1).toLowerCase() + " ";
            }

            scan.close();

            System.out.println(formatted);

            out.print(formatted);

            }
            // catch(Exception e){
            //     System.out.println("Errore nella scrittura su file.");
            // //    gestisco le eccezioni
            // }
        }
        catch(IOException e){
            System.out.println("Il file non esiste");
        //    gestisco le eccezioni
        }
    }
}