public class ArrayUtilTester{
    public static void main(String[] args)
    {
        int[] arr = ArrayUtil.randomIntArray(3, 10); 
        int size = arr.length;

        System.out.print("Array 1: ");
        System.out.println(ArrayUtil.printArray(arr, size));

        ArrayUtil.remove(arr, size, 1);
        size--;
        System.out.print("Array1 dopo l'eliminazione non ordinata: ");
        System.out.println(ArrayUtil.printArray(arr, size) + "\n");

        int[] arr2 = ArrayUtil.randomIntArray(4, 10); 
        int size2 = arr2.length;

        System.out.print("Array 2: ");
        System.out.println(ArrayUtil.printArray(arr2, size2));
        arr2 = ArrayUtil.resize(arr2, size2+1);
        ArrayUtil.insert(arr2, size2, 1, 1);
        size2++;
        System.out.print("Array2 dopo l'inserimento: ");
        System.out.println(ArrayUtil.printArray(arr2, size2));
        
        ArrayUtil.removeSorted(arr2, size2, 1);
        size2--;
        System.out.print("Array2 dopo l'eliminazione ordinata: ");
        System.out.println(ArrayUtil.printArray(arr2, size2));

        arr2 = ArrayUtil.resize(arr2, size2+1);
        ArrayUtil.insert(arr2, size2, 1, 1);
        size2++;
        System.out.print("Array2 dopo l'inserimento: ");
        System.out.println(ArrayUtil.printArray(arr2, size2));

        System.out.println("Minimo dell'array2: " + ArrayUtil.findMin(arr2, size2));
        System.out.println("Massimo dell'array2: " + ArrayUtil.findMax(arr2, size2));
        System.out.println("Indice trovato: " + ArrayUtil.find(arr2, size2, 3));
    }
}