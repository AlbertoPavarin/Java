import java.util.*;

public class ArrayReverseStraight{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Inserisci la dimensione: ");
        int dim = console.nextInt();
        int[] arr = new int[dim];

        for (int i = 0; i < dim; i++)
        {
            System.out.print("Inserisci il numero: ");
            arr[i] = console.nextInt();
        }

        console.close();

        for (int i = 0; i < dim; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = dim-1; i >= 0; i--)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
    } 
}