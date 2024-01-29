public class SelectionSort
{
    public static void main(String[] args)
    {
        int[] a = new int[]{ 10000, 9, 7, 9, 4, 6, 3, 1, 10};

        for (int i = 0; i < a.length; i++)
        {
            int min = i;

            for (int j = i + 1; j < a.length; j++)
            {
                if (a[j] < a[min])
                    min = j;
            }

            if (min != i)
            {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }
}