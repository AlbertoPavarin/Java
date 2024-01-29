public class MergeSort
{
    public static void main(String[] args)
    {
        int[] a = new int[]{ 10000, 9, 7, 9, 4, 6, 3, 1, 10};
        mergesort(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void mergesort(int[] a)
    {
        if (a.length == 1)
            return;

        int[] sx = new int[a.length/2];
        int[] dx = new int[a.length - a.length/2];
        System.arraycopy(a, 0, sx, 0, sx.length);
        System.arraycopy(a, a.length/2, dx, 0, dx.length);

        mergesort(sx);
        mergesort(dx);

        merge(a, sx, dx);

    }

    public static void merge(int[] a, int[] sx, int[] dx)
    {
        int aI = 0; int sxI = 0; int dxI = 0;

        while (sxI < sx.length && dxI < dx.length)
        {
            if (sx[sxI] < dx[dxI])
                a[aI++] = sx[sxI++];
            else
                a[aI++] = dx[dxI++];
        }

        while (sxI < sx.length)
            a[aI++] = sx[sxI++];

        while (dxI < dx.length)
           a[aI++] = dx[dxI++];   
    }
}