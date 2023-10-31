import java.util.Scanner;

public class PrintEasterDayForYear{
    public static void main(String[] args)
    {   
        int year, easterDay, a, b, c, d, e, g, h, j, k, m, r, n = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci l'anno desiderato: ");
        year = input.nextInt();

        a = year%19;

        b = year/100;
        c = year%100;

        d = b/4;
        e = b%4;

        g = (8 * b + 13)/25;

        h = (19 * a + b - d - g + 15)%30;

        j = c/4;
        k = c%4;

        m = (a + 11 * h)/319;

        r = (2 * e + 2 * j - k - h + m + 32)%7;

        n = (h - m + r + 90)/25;

        easterDay = (h - m + r + n + 19)%32;

        System.out.println("Il giorno di pasqua è: " + easterDay + '/' + n + '/' + year);
    }
}