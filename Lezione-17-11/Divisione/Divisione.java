/*
    Scrivere in java un programma che chieda all'utente il dividendo intero non negativo x, 
    il divisore intero positivo y ed esegua la divisione intera con resto, calcolando il quoziente q,
    il resto r.
*/

import java.util.Scanner;

public class Divisione{
    public static void main(String[] args)
    {
        int x, y, q = 0, r = 0;
        Scanner input = new Scanner(System.in);

        do
        {
            System.out.print("Inserisci il dividendo x: ");
            x = input.nextInt();
        } while(x < 0);

        do
        {
            System.out.print("Inserisci il divisore y: ");
            y = input.nextInt();
        } while(y <= 0);

        input.close();

        while (x >= y)
        {
            x -= y;
            q++;
        }

        r = x;

        System.out.println("Il quoziente è: " + q + " e il resto: " + r);
    }
}