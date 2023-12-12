import java.util.*;

public class QuadraticEquationTester{
    public static void main(String[] args)
    {
        QuadraticEquation eq;
        double a = 0, b = 0, c = 0;
        boolean done = false;
        Scanner console = new Scanner(System.in);

        while(!done)
        {
            System.out.print("Inserisci a: ");
            try
            {
                a = Double.parseDouble(console.next());
                done = true;
            }
            catch (NumberFormatException e)
            {
            }
        }

        done = false;

        while(!done)
        {
            System.out.print("Inserisci b: ");
            try
            {
                b = Double.parseDouble(console.next());
                done = true;
            }
            catch (NumberFormatException e)
            {
            }
        }

        done = false;

        while(!done)
        {
            System.out.print("Inserisci c: ");
            try
            {
                c = Double.parseDouble(console.next());
                done = true;
            }
            catch (NumberFormatException e)
            {
            }
        }

        try
        {
            eq = new QuadraticEquation(a, b, c);
            if (!eq.hasSolutions())
            {
                System.out.println("L'equazione non ha soluzioni");
                System.exit(-1);
            }

            double x1 = eq.getSolution1();
            double x2 = eq.getSolution2();
            if (x1 == x2)
                System.out.println("Soluzione: " + x1);
            else
                System.out.println("Le due soluzioni sono: " + x1 + ", " + x2);
        }
        catch (IllegalArgumentException e)
        {
            if (e.getMessage() == "0")
                System.out.println("L'equazione non ha soluzioni");
            else
                System.out.println("L'equazione ha infinite soluzioni");
        }
    }
}