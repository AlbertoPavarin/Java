import java.util.*;

public class FactorGeneratorTester
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int n = 0;

        do{
            System.out.print("Inserire un numero intero > 1: ");
            try
            {
                n = console.nextInt();
            }
            catch (InputMismatchException e)
            {
                n = 0;
                console.nextLine();
            }
        } while(n < 2);

        console.close();

        FactorGenerator f = new FactorGenerator(n);
        System.out.println("Fattori primi del numero " + n);
        while(f.hasMoreFactors())
            System.out.println(f.nextFactor());
    }
}