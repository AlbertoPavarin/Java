
import java.util.Scanner;

public class HelloWorld {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String name = getName(scanner);
        System.out.println("Hello, " + name + "!");
        int total = sum(scanner);
        System.out.println("Totale: " + total);
    }

    public static String getName(Scanner scanner)
    {
        System.out.println("Inserisci il tuo nome");
        return scanner.nextLine();
    }

    public static int sum(Scanner scanner)
    {
        System.out.println("\nInserisci x");
        int x = scanner.nextInt();

        System.out.println("\nInserisci y");
        int y = scanner.nextInt();
        return x + y;
    }
}