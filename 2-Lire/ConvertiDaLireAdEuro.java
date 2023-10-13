import java.util.Scanner;

public class ConvertiDaLireAdEuro{
    public static void main(String args[])
    {
        double impLire, impEuro = 0;
        Scanner t = new Scanner(System.in);
        System.out.print("Importo in lire: ");
        impLire = t.nextDouble();
        impEuro = impLire / 1936.27;
        System.out.println("Importo in euro: " + impEuro);
    }
}