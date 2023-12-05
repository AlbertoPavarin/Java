public class ArrayUtil{

    public static Student[] resize(Student[] arr, int newLen)
    {
        Student [] newArr = new Student[newLen];
        if (newLen >= arr.length)
        {
            for (int i = 0; i < arr.length; i++)
            {
                newArr[i] = arr[i];
            }
        }
        else
        {
            for (int i = 0; i < newLen; i++)
            {
                newArr[i] = arr[i];
            }
        }

        return newArr;
    }

    public static double[] resize(double[] arr, int newLen)
    {
        double [] newArr = new double[newLen];
        if (newLen >= arr.length)
        {
            for (int i = 0; i < arr.length; i++)
            {
                newArr[i] = arr[i];
            }
        }
        else
        {
            for (int i = 0; i < newLen; i++)
            {
                newArr[i] = arr[i];
            }
        }

        return newArr;
    }

    public static int[] randomIntArray(int length, int n)
    {
        int[] array = new int[length]; 
        for (int i = 0; i < length; i++)
            array[i] = (int)(n * Math.random());
        
        return array;
    }

    public static String printArray(int[] v, int vSize)
    {
        String arrayStr = "[ ";
        for (int i = 0; i < vSize; i++)
            arrayStr += v[i] + " ";
        arrayStr += "]";

        return arrayStr;
    }

    public static void remove(int[] v, int vSize, int index)
    {
        if (index <= vSize)
            v[index] = v[vSize - 1];
    }

    public static void removeSorted(int[] v, int vSize, int index)
    {
        if (index <= vSize)
        {
            for (int i = index; i < vSize - 1; i++)
            {
                v[i] = v[i+1];
            }
        }
    }

    public static void insert(int[] v, int vSize, int index, int value)
    {
        
        for (int i = vSize-1; i > index; i--)
        {
            v[i] = v[i-1];
        }
        v[index] = value;
    }

    public static int findMin(int[] v, int vSize)
    {
        int min = v[0];
        for (int i = 1; i < vSize; i++)
        {
            if (v[i] < min)
                min = v[i];
        }

        return min;
    }

    public static int findMax(int[] v, int vSize)
    {
        int max = v[0];
        for (int i = 1; i < vSize; i++)
        {
            if (v[i] > max)
                max = v[i];
        }

        return max;
    }

    public static int find(int[] v, int vSize, int target)
    {
        for (int i = 0; i < vSize; i++)
        {
            if (v[i] == target)
                return i;
        }

        return -1;
    }
}