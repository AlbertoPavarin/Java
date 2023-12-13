import java.util.Scanner;

public class RicercaLineare
{
    public static void main(String[] args)
    {
        int[] a = { 10, 5, 6, 2, 3, 4, 9, 7, 8, 1, 10};
        boolean done = false;
        int num = 0, pos = 0;
        int[] poss;
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

        if ((pos = ricerca(a, num)) >= 0)
            System.out.println("Il numero " + num + " è in posizione " + pos);
        else
            System.out.println("Il numero " + num + " non è all'interno dell'array");

        System.out.println();

        if ((poss = ricercaConDoppioni(a, num)).length > 0)
            for (int i = 0; i < poss.length; i++)
                System.out.println("Il numero " + num + " è in posizione " + poss[i]);
        else
            System.out.println("Il numero " + num + " non è all'interno dell'array");
    }

    public static int ricerca(int[] arr, int num)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == num)
                return i + 1;
        }

        return -1;
    }

    public static int[] ricercaConDoppioni(int[] arr, int num)
    {
        int cnt = 0;
        int[] pos = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == num)
                pos[cnt++] = i+1;
        }

        return resize(pos, cnt);
    }

    private static int[] resize(int[] arr, int newLength)
    {
        int[] newA = new int[newLength];
        System.arraycopy(arr, 0, newA, 0, newLength);
        return newA;
    }
}