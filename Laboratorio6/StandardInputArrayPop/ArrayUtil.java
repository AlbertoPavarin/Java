public class ArrayUtil{
    public static void main(String args[])
    {
        int [] arrI = {1, 2, 3};
        arrI = resize(arrI, 4);

        System.out.println("Array Int");
        for (int i = 0; i < arrI.length; i++)
            System.out.println(arrI[i]);

        double [] arrD = {1.2, 2.3, 3.4};
        arrD = resize(arrD, 4);

        System.out.println("\nArray Double");
        for (int i = 0; i < arrD.length; i++)
            System.out.println(arrD[i]);
    }

    public static int[] resize(int[] arr, int newLen)
    {
        int [] newArr = new int[newLen];
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
}