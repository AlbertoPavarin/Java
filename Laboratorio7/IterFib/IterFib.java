import java.util.*;

public class IterFib{
    public static void main(String[] args){
        String nmb;
        Scanner console = new Scanner(System.in);
        int n = 0;

        if (args.length < 1)
        {
            System.out.print("Inserisci un numero intero: ");
            nmb = console.next();
        }
        else
            nmb = args[0];

        try
        {   
            n = Integer.parseInt(nmb);
            if (n <= 0)
                throw new IllegalArgumentException();

            long bT = System.nanoTime();
            System.out.println(fibonacci(n));
            long aT = System.nanoTime();

            System.out.println("Differenza: " + (aT-bT));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Errore, non hai inserito un numero intero");
        }
    }

    public static long fibonacci(int n)
    {
        if (n == 0)
            return 0;
            
        if (n < 2)
            return n;

        int somma = 0, f1 = 0, f2 = 1;

        for (int i = 2; i <= n; i++)
        {
            somma = f1 + f2;
            f1 = f2;
            f2 = somma;
        }

        return f2;
    }
}