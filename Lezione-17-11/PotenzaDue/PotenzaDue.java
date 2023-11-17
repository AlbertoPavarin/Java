/* 
    Scrivere un programma in Java che chieda all'utente un numero intero positivo x e stabilisca se x è una potenza di 2 oppure no
*/

import java.util.Scanner;

public class PotenzaDue{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x, p = 1;

        do
        {
            System.out.print("Inserisci un numero naturale: ");
            x = input.nextInt();
        } while(x <= 0);

        input.close();

        while (p < x)
        {
            p *= 2;
        }

        if (p == x)
            System.out.println(x + " è una potenza di 2");
        else
            System.out.println(x + " NON è una potenza di 2");
    }
}