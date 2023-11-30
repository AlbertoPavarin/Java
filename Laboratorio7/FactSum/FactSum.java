import java.util.*;

public class FactSum{
    public static void main(String[] args)
    {
        int n = 0, somma = 0;
        if (args.length >= 2 || args.length == 0)
        {
            System.out.println("Errore nei parametri inseriti");
            System.exit(-1);
        }

        try{
            n = Integer.parseInt(args[0]);
            if (n <= 0)
                throw new IllegalArgumentException();

            System.out.println(somma(n));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Inserisci un numero positivo");
        }

    }

    public static int somma(int n)
    {
        if (n <= 0)
            return 0;

        return n + somma(n-1);
    }
}