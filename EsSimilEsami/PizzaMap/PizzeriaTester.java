import java.io.*;
import java.util.Scanner;

public class PizzeriaTester {

    public static void main(String[] args)
    {
        PizzaMap pizzaMap = new PizzaMap();

        try (FileReader r = new FileReader("pizze.txt"); Scanner scan = new Scanner(r))
        {

            while(scan.hasNextLine())
                pizzaMap.put(scan.next(), scan.nextDouble());

        }
        catch (IOException e)
        {
            System.out.println("Il file pizze.txt non è stato trovato");
        }

        System.out.println("Menù non ordinato: ");
        System.out.println(pizzaMap);

        System.out.println("Menù ordinato: ");
        System.out.println(pizzaMap.printMenu());
    }
}