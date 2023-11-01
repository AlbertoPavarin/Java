import java.util.Scanner;

public class Stringhe{
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci l'aggettivo: ");

        String diminutivo, assoluto = "";
        String aggettivo = input.next();

        String radice = aggettivo.substring(0, aggettivo.length() - 1);
        System.out.println(aggettivo.substring(aggettivo.length() - 1));
        if (aggettivo.substring(aggettivo.length() - 1).equals("a"))
        {
            diminutivo = radice + "ina";
            assoluto = radice + "issima";
        }
        else
        {
            diminutivo = radice + "ino";
            assoluto = radice + "issimo";
        }

        System.out.println("Aggettivo inserito: " + aggettivo.substring(0, 1).toUpperCase() + aggettivo.substring(1).toLowerCase());
        System.out.println("Diminutivo inserito: " + diminutivo.substring(0, 1).toUpperCase() + diminutivo.substring(1).toLowerCase());
        System.out.println("Assoluto inserito: " + assoluto.substring(0, 1).toUpperCase() + assoluto.substring(1).toLowerCase());
        input.close();
    }
}