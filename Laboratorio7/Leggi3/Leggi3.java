import java.util.*;
import java.io.*;

public class Leggi3{
    public static void main(String[] args)
    {
        try(FileReader r = new FileReader("input.txt"); Scanner scan = new Scanner(r)){

        // Si usa lo scanner con i suoi metodi hasNext, next, nextInt, nextDouble,    
        // nextLine a seconda delle esigenze
        scan.useDelimiter("[,?\\s]+");
        while(scan.hasNext())
            System.out.println(scan.next());

        }
        catch(IOException e){
            System.out.println("Il file non esiste");
        //    gestisco le eccezioni
        }
    }
}