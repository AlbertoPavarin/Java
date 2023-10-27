import java.util.Scanner;

public class Trapezio {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        double bMin, bMag, h, area = 0;
        System.out.print("Base minore: ");
        bMin = input.nextDouble();
        System.out.print("Base maggiore: ");
        bMag = input.nextDouble();
        System.out.print("Altezza: ");
        h = input.nextDouble();
        
        area = ((bMin + bMag) * h)/2;

        System.out.println("L'area è: " + area);

        input.close();
    }
}