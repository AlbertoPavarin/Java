import java.util.*;

public class RecPalindroma{
    public static void main(String[] args){
        String nmb;
        Scanner console = new Scanner(System.in);
        int n = 0;

        if (args.length < 1)
        {
            System.out.println("Errore. Inserisci una stringa da riga di comando");
            System.exit(-1);
        }

        if (palindroma(args[0], 0))
            System.out.println("La stringa " + args[0] + " è palindroma");
        else
            System.out.println("La stringa " + args[0] + " non è palindroma");
    }

    public static boolean palindroma(String str, int start)
    {
        if (str.length() == 0 || str.length() == 1 || start == str.length())
            return true;

        if (str.length() == 3)
        {
            if (str.charAt(0) != str.charAt(str.length()-1))
                return false;

            return true;
        }

        if (str.charAt(0) != str.charAt(str.length()-1))
            return false;

        start++;
        return palindroma(str.substring(1, str.length()-1), start);
    }
}