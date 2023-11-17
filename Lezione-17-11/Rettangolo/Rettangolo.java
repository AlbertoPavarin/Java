import java.util.Scanner;

public class Rettangolo{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double b, h, area = 0, perimetro = 0;

        do 
        {
            System.out.print("Inserisci la base, maggiore di 0: ");
            b = input.nextDouble();
            if (b < 0)
                System.out.println("La base deve essere maggiore di 0!");
        } while(b < 0);

        do 
        {
            System.out.print("Inserisci l'altezza, maggiore di 0: ");
            h = input.nextDouble();
            if (h < 0)
                System.out.println("L'altezza deve essere maggiore di 0!");
        } while(h < 0);

        input.close();

        area = b * h;
        perimetro = (b + h) * 2;

        System.out.println("L'area del rettangolo è: " + area + " e il perimetro è: " + perimetro );
    }
}