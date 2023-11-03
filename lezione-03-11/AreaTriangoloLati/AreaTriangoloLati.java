import java.util.Scanner;

/*
    a, b, c lati triangolo
    p = (a + b + c) / 2;
    s = sqrt(p * (p - a) * (p - b) * ( p - c));
*/

public class AreaTriangoloLati{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double a, b, c, p, s;

        System.out.print("Inserisci il lato a: ");
        a = input.nextDouble();
        System.out.print("Inserisci il lato b: ");
        b = input.nextDouble();
        System.out.print("Inserisci il lato c: ");
        c = input.nextDouble();

        if ((a < 0 || b < 0 || c < 0))
        {
            System.out.println("Inserisci solo lati maggiori di 0");
            System.exit(1);
        }
        if ((a < Math.abs(b - c) || b < Math.abs(a - c) || c < Math.abs(b - a)) && (a > b + c || b > a + c || c > b + c))
        {
            System.out.println("Inserisci lati validi");
            System.exit(1);
        }
        

        p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Perimetro: " + p + "\nArea: " + s);
        input.close();
    }
}