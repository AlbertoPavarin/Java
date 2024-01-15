import java.util.Scanner;
import java.io.*;

public class BilanciaParentesi{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Errore. Uso: BilanciaParentesi input.txt");
            System.exit(-1);
        }

        String s = "";
        // String s = "((()))" +
        //             "())";

        try(FileReader f = new FileReader(args[0]); Scanner scan = new Scanner(f))
        {
            while(scan.hasNextLine())
            {
                s += scan.nextLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("Errore nell'apertura del file.");
            System.exit(-1);
        }

        System.out.println(s);

        if (bilancia(s) == 0)
            System.out.println("La stringa è bilanciata");
        else
            System.out.println("La stringa non è bilanciata");
        
    }

    public static int bilancia(String s)
    {
        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == '(')
            return 1 + bilancia(s.substring(1, s.length()));
        else if (s.charAt(0) == ')');
            return -1 + bilancia(s.substring(1, s.length()));
    }
}