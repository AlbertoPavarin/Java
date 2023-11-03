import java.util.Scanner;

public class Equazione{
    public static void main(String[] args)
    {
        double a, b, x;
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci a: ");
        a = input.nextDouble();

        System.out.print("Inserisci b: ");
        b = input.nextDouble();

        if (a == 0)
        {
            System.out.println("Equazione non risolubile");
            System.exit(-1);
        }

        x = b/a;

        System.out.println("x = " + x);
    }
}