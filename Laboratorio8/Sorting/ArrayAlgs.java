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

    public static void mergesort(int[] arr )
    {
        if (arr == null)
            throw new IllegalArgumentException();

        if (arr.length == 1)
        {
            return;
        }
        int mid = arr.length / 2;
        int[] sinistra = new int[mid];
        int[] destra = new int[arr.length - mid];

        System.arraycopy(arr, 0, sinistra, 0, mid);
        System.arraycopy(arr, mid, destra, 0, arr.length-mid);

        mergesort(sinistra);
        mergesort(destra);

        merge(arr, sinistra, destra);
    }

    private static void merge(int[] a, int[] b, int[] c)
    {
        int ia = 0, ib = 0, ic = 0;
        while (ib < b.length && ic < c.length)
            if (b[ib] < c[ic])
                a[ia++] = b[ib++];
            else
                a[ia++] = c[ic++];

        while(ib < b.length)
            a[ia++] = b[ib++];
        while(ic < c.length)
            a[ia++] = c[ic++];   
    }
}