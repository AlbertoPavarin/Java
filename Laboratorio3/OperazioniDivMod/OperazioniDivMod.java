import java.util.Scanner;

public class OperazioniDivMod{
    public static void main(String[] args)
    {   
        int cent, dec, un = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero in base 10: ");
        int num = input.nextInt();
        System.out.print("Inserisci la base: ");
        int base = input.nextInt();

        
        cent = (num)%base;
        num /= base;

        dec = num%base;
        num /= base;
        
        un = num%base;
        System.out.println(un + "" + dec + "" + cent);
    }
}