import java.util.*;

public class ArraySum{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int[] arr = new int[10];
        int somma = 0;

        for (int i = 0; i < 10; i++)
        {
            System.out.print("Inserisci il numero: ");
            arr[i] = console.nextInt();
        }

        console.close();

        for (int i = 0; i < 10; i++)
        {
            somma += arr[i];
        }
        System.out.println("La somma è: " + somma);
    } 
}