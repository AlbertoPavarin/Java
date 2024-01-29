public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] a = new int[]{ 10000, 9, 7, 9, 4, 6, 3, 1, 10};

        for (int i = 0; i < a.length; i++)
        {
            for (int j = i-1; j >= 0; j--)
            {
                if (a[j] > a[j+1])
                {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }
}