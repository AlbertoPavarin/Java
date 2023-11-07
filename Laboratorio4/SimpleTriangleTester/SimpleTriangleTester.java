import java.util.Scanner;

public class SimpleTriangleTester{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int latoUno, latoDue, latoTre, angoloEq = 0;
        String latiInfo = "";
        String angoliInfo = "";

        System.out.print("Inserisci il lato 1 del triangolo: ");
        latoUno = input.nextInt();
        System.out.print("Inserisci il lato 2 del triangolo: ");
        latoDue = input.nextInt();
        System.out.print("Inserisci il lato 3 del triangolo: ");
        latoTre = input.nextInt();

        if ((latoUno < Math.abs(latoDue - latoTre) || latoDue < Math.abs(latoUno - latoTre) || latoTre < Math.abs(latoDue - latoUno)) && (latoUno > latoDue + latoTre || latoDue > latoUno + latoTre || latoTre > latoDue + latoUno))
        {
            System.out.println("Inserisci lati validi");
            System.exit(1);
        }

        if (latoUno == latoDue && latoDue == latoTre)
            latiInfo = "Equilatero";
        else if ((latoUno == latoDue) || (latoUno == latoTre) || (latoDue == latoTre))
            latiInfo = "Isoscele";
        else if (latoUno != latoDue && latoDue != latoTre)
            latiInfo = "Scaleno";

        angoloEq = (latoTre * latoTre) - (latoUno * latoUno) - (latoDue * latoDue);

        if (angoloEq < 0)
            angoliInfo = "Acutangolo";
        else if(angoloEq == 0)
            angoliInfo = "Rettangolo";
        else if (angoloEq > 0)
            angoliInfo = "Ottusangolo";

        System.out.println("Triangolo " + latiInfo + " " + angoliInfo);

        input.close();
    }
}