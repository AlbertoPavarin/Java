import java.util.Scanner;

public class Piastrelle{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double lMuro, lPiastrella = 0;
        int nCoppiePiastrelle, nPiastrelle;

        System.out.print("Inserisci la lunghezza del muro: ");
        lMuro = input.nextDouble();

        System.out.print("Inserisci la lunghezza della piastrella: ");
        lPiastrella = input.nextDouble();

        input.close();

        nPiastrelle = (int)(lMuro/lPiastrella);
        if (nPiastrelle % 2 == 0)
            nPiastrelle -= 1;

        nCoppiePiastrelle = (int)((nPiastrelle)/(2));
        System.out.println(nCoppiePiastrelle);
        System.out.println("Gap: " + ((lMuro - (nPiastrelle * lPiastrella))/nCoppiePiastrelle));
    }
}