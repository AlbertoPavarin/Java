/*
    Supponiamo di disporre di un sistema di calcolo privo della sottrazione, moltiplicazione, addizzione
    e divisione, dotato solo delle operazioni di successore (++), e di predecessore (--) e dei cicli.
    In tale contesto si desidera scrivere un programma in linguaggio Java che chieda in input i due addendi interi
    non negativi x, y ed esegua l'operazione di addizione, producendo in output la somma.
*/

import java.util.Scanner;

public class Operazioni{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x, y, somma = 0;

        do {
            System.out.print("Inserisci un numero intero x maggiore di 0: ");
            x = input.nextInt();
        } while(x < 0);

        do {
            System.out.print("Inserisci un numero intero y maggiore di 0: ");
            y = input.nextInt();
        } while(y < 0);

        input.close();

        // for (int i = 0; i < x; i++)
        // {
        //     somma++;
        // }

        // for (int i = 0; i < y; i++)
        // {
        //     somma++;
        // }
        // System.out.println("La somma tra " + x + " e " + y + " è: " + somma);
        // Un altro modo

        while(y > 0)
        {
            y--;
            x++;
        }
        System.out.println("La somma tra è: " + x);
    }
}