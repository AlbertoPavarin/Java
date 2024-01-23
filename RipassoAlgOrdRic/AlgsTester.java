public class AlgsTester{
    public static void main(String[] args)
    {
        Comparable[] arr1 = {1, 2, 6, 4, 3};

        Algs.selectionSort(arr1, arr1.length);

        System.out.println("Selection Sort:");

        for(int i = 0; i < arr1.length; i++)
        {
            System.out.println(arr1[i]);
        }

        System.out.println("\nInsertion Sort:");

        Comparable[] arr2 = {1, 2, 6, 4, 3};

        Algs.insertionSort(arr2, arr2.length);

        for(int i = 0; i < arr2.length; i++)
        {
            System.out.println(arr2[i]);
        }

        System.out.println("\nMerge Sort:");

        Comparable[] arr3 = {1, 2, 6, 4, 3};

        Algs.mergeSort(arr3, arr3.length);

        for(int i = 0; i < arr3.length; i++)
        {
            System.out.println(arr3[i]);
        }

        System.out.println("\n Il numero 3 è in posizione: " + Algs.linearSearch(arr1, 3));
        System.out.println("\n Il numero 4 è in posizione: " + Algs.binarySearch(arr1, 4));
    }
}