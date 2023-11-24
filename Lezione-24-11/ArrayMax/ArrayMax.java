import java.util.*;

public class ArrayMax{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            System.out.print("Inserisci il numero: ");
            arr[i] = console.nextInt();
        }

        console.close();

        int max = arr[0];

        for (int i = 1; i < 10; i++)
        {
            if (arr[i] > max)
                max = arr[i];
        }

        int min = arr[0];

        for (int i = 1; i < 10; i++)
        {
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println("Il massimo è: " + max);
        System.out.println("Il massimo è: " + min);
    } 
}