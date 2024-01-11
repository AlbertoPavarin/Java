import java.util.Scanner;
import java.util.Random;

public class LinkedListTester{
    public static void main(String [] args)
    {
        LinkedList list = new LinkedList();
        int n = 0;
        Scanner console = new Scanner(System.in);
        boolean done = false;
        Random rnd = new Random();

        while(!done)
        {
            try
            {
                System.out.print("Inserisci un numero intero: ");
                n = Integer.parseInt(console.next());
                if (n > 0)
                    done = true;
            }
            catch(NumberFormatException e)
            {}
        }

        for (int i = 0; i < n; i++)
        {
            int rndNmb = rnd.nextInt(100) + 1;
            System.out.println("Numero da inserire: " + rndNmb);
            if (i % 2 == 0)
                list.addFirst(rndNmb);
            else
                list.addLast(rndNmb);

            System.out.println(list);
            System.out.println("\n");
        }

        done = false;

        while(!done)
        {
            try
            {
                System.out.print("Inserisci dopo quale numero vuoi inserire il numero 1000: ");
                n = Integer.parseInt(console.next());
                if (n > 0)
                    done = true;
            }
            catch(NumberFormatException e)
            {}
        }

        done = false;

        ListIterator iter = list.getIterator();

        while (iter.hasNext() && !done)
        {
            if (iter.next().equals(n))
            {
                iter.add(1000);
                done = true;
            }
        }

        System.out.println(list);

        done = false;

        while(!done)
        {
            try
            {
                System.out.print("Inserisci quale numero vuoi eliminare: ");
                n = Integer.parseInt(console.next());
                if (n > 0)
                    done = true;
            }
            catch(NumberFormatException e)
            {}
        }

        console.close();

        done = false;

        iter = list.getIterator();

        while (iter.hasNext() && !done)
        {
            if (iter.next().equals(n))
            {
                iter.remove();
                done = true;
            }
        }

        System.out.println(list);

        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }
}