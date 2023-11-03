import java.util.Scanner;

public class VerificaPeso{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double peso, altezza, pesoIdeale;
        
        System.out.print("Inserisci l'altezza in cm: ");
        altezza = input.nextDouble();
        System.out.print("Inserisci il tuo peso in kg: ");
        peso = input.nextDouble();

        pesoIdeale = altezza - 105;

        if (peso < pesoIdeale)
        {
            System.out.println("Sottopeso");
        }
        if (peso > pesoIdeale)
        {
            System.out.println("Sovrappeso");
        }
        if (peso == pesoIdeale)
        {
            System.out.println("Normopeso");
        }
    }
}