import java.util.*;

public class RecMCD{
    public static void main(String[] args)
    {
        int n = 0, m = 0;
        if (args.length != 2)
        {
            System.out.println("Errore nei parametri inseriti");
            System.exit(-1);
        }

        try{
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
            if (n <= 0 || m <= 0)
                throw new IllegalArgumentException();

            if (m < n)
            {
                int tmp = m;
                m = n;
                n = tmp;
            }
            System.out.println(recursiveMCD(n, m));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Inserisci un numero positivo");
        }

    }

    public static int recursiveMCD(int n, int m)
    {
        if (m%n == 0)
            return n;

        return recursiveMCD(m%n, n);
    }
}