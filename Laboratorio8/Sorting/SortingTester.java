import java.util.Random;

public class SortingTester{
    public static void main(String[] args){
        if (args.length != 1)
            System.out.println("Errore inserisci un numero come parametro");
        int n = 0;
        Random rnd = new Random();

        try
        {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e)
        {
            System.out.println("Errore inserisci un numero come parametro");
        }

        int[] a = new int[n];
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        // in modo randomico
        // for (int i = 0; i < n; i++) 
        //     a[i] = rnd.nextInt(100) + 1;
        
        // array popolato da 0 a n-1
        for (int i = 0; i < n; i++) 
            a[i] = i;

        // array popolato da n-1 a 0    
        int cnt = n;
        for (int i = 0; i < n; i++) 
            a[i] = cnt--;

        System.arraycopy(a, 0, arr1, 0, n);
        System.arraycopy(a, 0, arr2, 0, n);
        System.arraycopy(a, 0, arr3, 0, n);

        // System.out.println("Array originale: ");
        // System.out.println(arrayToString(a, n));
        // System.out.println();

        System.out.println("Array ordinato con Selection: ");
        long bT = System.nanoTime();
        ArrayAlgs.selectionSort(arr1);
        // System.out.println(arrayToString(arr1, n));
        long aT = System.nanoTime();
        System.out.println("Differenza tempo Selection: " + (double)(aT-bT)/1000000000);
        System.out.println();

        System.out.println("Array ordinato con Merge: ");
        bT = System.nanoTime();
        ArrayAlgs.mergesort(arr2);
        // System.out.println(arrayToString(arr2, n));
        aT = System.nanoTime();
        System.out.println("Differenza tempo Merge: " + (double)(aT-bT)/1000000000);
        System.out.println();

        System.out.println("Array ordinato con Insertion: ");
        bT = System.nanoTime();
        ArrayAlgs.insertionSort(arr3);
        // System.out.println(arrayToString(arr3, n));
        aT = System.nanoTime();
        System.out.println("Differenza tempo Inserition: " + (double)(aT-bT)/1000000000);
        System.out.println();
    }

    private static String arrayToString(int[] a, int l)
    {
        String arrStr = "[ ";
        for (int i = 0; i < l; i++)
        {
            arrStr += a[i] + " ";
        }
        arrStr += "]";

        return arrStr;
    }
}