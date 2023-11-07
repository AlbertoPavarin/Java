import java.util.Scanner;

public class SimpleTriangleTester{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int latoUno, latoDue, latoTre = 0;
        String latiInfo = "";
        String angoliInfo = "";

        System.out.print("Inserisci il lato 1 del triangolo: ");
        latoUno = input.nextInt();
        System.out.print("Inserisci il lato 2 del triangolo: ");
        latoDue = input.nextInt();
        System.out.print("Inserisci il lato 3 del triangolo: ");
        latoTre = input.nextInt();

        if (latoUno == latoDue && latoDue == latoTre)
        {
            latiInfo = "Equilatero";
        }
        else if ((latoUno == latoDue && latoDue != latoTre) || (latoUno == latoTre && latoDue != latoTre))
        {
            latiInfo = "Isoscele";
        }
        else if (latoUno != latoDue && latoDue != latoTre)
        {
            latiInfo = "Scaleno";
        }

        System.out.println(latiInfo);

        input.close();
    }
}