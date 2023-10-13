import java.util.Scanner;
import java.math.*;

public class ipotenusa {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        double cat1, cat2, ipo = 0;
        System.out.print("Primo cateto: ");
        cat1 = input.nextDouble();
        if (cat1 <= 0)
        {
            System.out.print("Il primo cateto deve essere maggiore di 0");
            System.exit(0);
        }
        System.out.print("Secondo cateto: ");
        cat2 = input.nextDouble();
        if (cat2 <= 0)
        {
            System.out.print("Il secondo cateto deve essere maggiore di 0");
            System.exit(0);
        }

        if (cat1 >= 0 && cat2 >= 0)
        {
            ipo = Math.sqrt(cat1 * cat1 + cat2 * cat2);
            System.out.println("\nIpotenusa: " + ipo);
        }
    }
}