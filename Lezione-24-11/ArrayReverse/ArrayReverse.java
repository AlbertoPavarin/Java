import java.util.*;

public class ArrayReverse{
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

        for (int i = 9; i >= 0; i--)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    } 
}