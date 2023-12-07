public class SortingTester{
    public static void main(String[] args){
        int [] arr = {1, 3, 2, 4, 5};
        ArrayAlgs.selectionSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        System.out.println("\n");

        int [] arr2 = {1, 3, 2, 4, 5};
        ArrayAlgs.insertionSort(arr2);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr2[i]);
    }
}