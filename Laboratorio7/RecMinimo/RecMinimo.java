import java.util.*;

public class RecMinimo{
    public static void main(String[] args){
        String nmb;
        Scanner console = new Scanner(System.in);
        int n = 0, dim = 0;

        if (args.length != 2)
        {
            System.out.println("Errore. Inserisci 2 parametri interi");
            System.exit(-1);
        }

        try{
            dim = Integer.parseInt(args[0]);
            if (dim <= 0)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Inserisci una dimensione positiva intera");
        }

        try{
            n = Integer.parseInt(args[1]);
            if (n <= 0)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Inserisci un numero n positivo intero");
        }

        Random rnd = new Random();
        int[] arr = new int[dim];
        for (int i = 0; i < dim; i++)
            arr[i] = rnd.nextInt(n) + 1;

        System.out.println("Il minimo all'interno dell'array è: " + minimo(arr, arr[0], 1));
    }

    public static int minimo(int[] arr, int min, int pos)
    {
        if (arr.length == 1)
            return min;
             
        if (arr.length == pos + 1)
        {
            if (arr[pos] < min)
                return arr[pos];
            
            return min;
        }

        if (arr[pos] < min)
            min = arr[pos];

        pos++;
        return minimo(arr, min, pos);
    }
}