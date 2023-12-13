import java.util.Scanner;

public class RicercaBinaria
{
    public static void main(String[] args)
    {
        int[] a = { 11, 12, 17, 5, 9, 21};
        boolean done = false;
        int num = 0, pos = 0;
        Scanner console = new Scanner(System.in);

        while(!done)
        {
            System.out.print("Inserisci un numero da ricercare: ");
            try
            {
                num = Integer.parseInt(console.next());
                done = true;
            }
            catch(NumberFormatException e)
            {
            }
        }   

        console.close();

        mergesort(a);

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        if ((pos = ricerca(a, num, 0, a.length - 1)) >= 0)
            System.out.println("Il numero " + num + " è in posizione " + pos);
        else
            System.out.println("Il numero " + num + " non è all'interno dell'array");
    }

    public static void mergesort(int[] a)
    {
        if (a == null || a.length == 1)
        {
            return;
        }

        int mid = (int)a.length / 2;
        int[] sx = new int[mid];
        int[] dx = new int[a.length - mid];
        System.arraycopy(a, 0, sx, 0, sx.length);
        System.arraycopy(a, mid, dx, 0, dx.length);

        mergesort(sx);
        mergesort(dx);

        merge(a, sx, dx);
    }

    private static void merge(int[] src, int[] sx, int[] dx)
    {
        int srcI = 0, sxI = 0, dxI = 0;
        while(sxI < sx.length && dxI < dx.length)
        {
            if (sx[sxI] > dx[dxI])
                src[srcI++] = dx[dxI++];
            else
                src[srcI++] = sx[sxI++];
        }

        while(sxI < sx.length)
            src[srcI++] = sx[sxI++];
        while(dxI < dx.length)
            src[srcI++] = dx[dxI++];
    } 

    public static int ricerca(int[] arr, int num, int from, int to)
    {
        if (from > to)
            return -1;

        int mid = (from + to)/2;
        System.out.println("mid: " + from + "val: " + to);
        int arrMid = arr[mid]; 
        if (arrMid == num)
            return mid + 1;


        if (num < arrMid) // ricerca a sinistra
            return ricerca(arr, num, from, mid - 1);
        else // ricerca a destra
            return ricerca(arr, num, mid + 1, to);
    }
}