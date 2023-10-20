import java.util.Scanner;

public class TassoInteresse{
    public static void main(String argv[]){
        /*  
            Tasso Interesse = i
            Importo = imp
            N.Anni = a
            Capitale Finale = capF = imp + (1 + a * i)
        */

       Scanner scanner = new Scanner(System.in);
       double tassoInteresse, importo, anni, capF = 0;

       System.out.print("Inserisci l'importo: ");
       importo = scanner.nextDouble();

       System.out.print("Inserisci l'interesse: ");
       tassoInteresse = scanner.nextDouble();
       
       System.out.print("Inserisci il numero di anni: ");
       anni = scanner.nextDouble();

       capF = importo + (1 + anni * tassoInteresse);
       System.out.println("Il capitale finale dopo " + anni + " sarà: " + capF);
    }
}