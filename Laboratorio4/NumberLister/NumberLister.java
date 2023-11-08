import java.util.Scanner;

public class NumberLister{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci un numero >= 0: ");
        int n = input.nextInt();

        if (n <= 0)
        {
            System.out.println("Ingresso non ammesso");
            System.exit(0);
        }

        for (int i = 1; i <= n; i++)
            System.out.println(i);

        input.close();
    }
}