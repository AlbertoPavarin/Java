public class Algs{

    public static void selectionSort(Comparable[] arr, int length)
    {
        if (arr.length < length)
            throw new IllegalArgumentException();

        for (int i = 0; i < length; i++)
        {
            int pos = findMin(arr, length, i);

            if (pos != i)
            {
                Comparable tmp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = tmp; 
            }
        }    
    }   

    private static int findMin(Comparable[] arr, int length, int index)
    {
        int min = index;
        for (int i = index; i < length; i++)
        {
            if (arr[min].compareTo(arr[i]) > 0)
                min = i;
        }

        return min;
    }

    public static void insertionSort(Comparable[] arr, int length)
    {
        if (arr.length < length)
            throw new IllegalArgumentException();

        for (int i = 1; i < length; i++)
        {
            for (int j = i-1; j >= 0; j--)
            {
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                else
                    break;
            }
        }
    }

    public static void mergeSort(Comparable[] arr, int length)
    {
        if (arr.length < length)
            throw new IllegalArgumentException();

        if (length == 1)
            return;

        int mid = length / 2;
        Comparable[] sx = new Comparable[mid];
        Comparable[] dx = new Comparable[length-mid];
        System.arraycopy(arr, 0, sx, 0, sx.length);
        System.arraycopy(arr, mid, dx, 0, dx.length);

        mergeSort(sx, sx.length);
        mergeSort(dx, dx.length);

        merge(arr, dx, sx);
    }

    private static void merge(Comparable[] a, Comparable[] s, Comparable[] d)
    {
        int aI = 0, sI = 0, dI = 0;

        while(s.length > sI && d.length > dI)
        {
            if (s[sI].compareTo(d[dI]) < 0)
                a[aI++] = s[sI++];
            else
                a[aI++] = d[dI++];
        } 

        while(s.length > sI)
            a[aI++] = s[sI++];

        while(d.length > dI)
            a[aI++] = d[dI++];
    }

    public static int linearSearch(Comparable[] arr, Comparable target)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].compareTo(target) == 0)
                return i;
        }

        return -1;
    }

    public static int binarySearch(Comparable[] arr, Comparable target)
    {
        return binSearch(arr, 0, arr.length, target);
    }

    private static int binSearch(Comparable[] arr, int from, int to, Comparable target)
    {
        if (from > to)
            return -1;

        int mid = (from + to) / 2;

        int compare = arr[mid].compareTo(target);

        if (compare == 0)    
            return mid;
        else if (compare > 0)
            return binSearch(arr, from, mid - 1, target);
        else if (compare < 0)
            return binSearch(arr, mid + 1, to, target);

        return -1;
    }

}