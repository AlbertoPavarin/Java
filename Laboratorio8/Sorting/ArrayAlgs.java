public class ArrayAlgs{

    public static void selectionSort(int[] arr)
    {
        if (arr == null)
            throw new IllegalArgumentException();

        selectionSort(arr, arr.length);
    }

    public static void selectionSort(int[] arr, int length)
    {
        if (arr == null || arr.length < length)
            throw new IllegalArgumentException();

        for (int i = 0; i < length - 1; i++)
        {
            int posMin = searchPosMin(arr, length, i);

            if (posMin != i)
                swap(arr, posMin, i);
        }
    }

    private static int searchPosMin(int[] a, int length, int pos)
    {
        int tmpMinPos = pos;
        for (int i = tmpMinPos + 1; i < length; i++)
        {
            if (a[i] < a[tmpMinPos])
                tmpMinPos = i; 
        }

        return tmpMinPos;
    }

    private static void swap(int[] a, int posMin, int prevPosMin)
    {
        int tmp = a[posMin];
        a[posMin] = a[prevPosMin];
        a[prevPosMin] = tmp;
    }

    public static void insertionSort(int[] arr)
    {
        if (arr == null)
            throw new IllegalArgumentException();

        for (int i = 1; i < arr.length; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
                else
                    break;
            }
        }
    }
}