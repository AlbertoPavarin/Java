import java.util.Scanner;

public class Concatenazione
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = "";

        System.out.print("Inserisci una stringa: ");
        s = scan.next();
        scan.close();

        System.out.println("Le vocali sono: " + concatenaVocali(s));
        System.out.println("Le vocali al contrario sono: " + concatenaVocaliReversed(s));
        System.out.println("Le consonanti sono: " + concatenaConsonanti(s));
        System.out.println("I numeri sono: " + concatenaNumeri(s));
    }

    public static String concatenaVocali(String s)
    {
        if (s.length() == 0)
            return "";

        char c = s.charAt(0);

        if (Character.toUpperCase(c) == 'A' || Character.toUpperCase(c) == 'E' || Character.toUpperCase(c) == 'I' || Character.toUpperCase(c) == 'O' || Character.toUpperCase(c) == 'U')
            return c + concatenaVocali(s.substring(1, s.length()));

        return "" + concatenaVocali(s.substring(1, s.length()));
    }

    public static String concatenaVocaliReversed(String s)
    {
        if (s.length() == 0)
            return "";

        char c = s.charAt(s.length() - 1);

        if (Character.toUpperCase(c) == 'A' || Character.toUpperCase(c) == 'E' || Character.toUpperCase(c) == 'I' || Character.toUpperCase(c) == 'O' || Character.toUpperCase(c) == 'U')
            return c + concatenaVocaliReversed(s.substring(0, s.length() - 1));

        return "" + concatenaVocaliReversed(s.substring(0, s.length() -1));
    }

    public static String concatenaConsonanti(String s)
    {
        if (s.length() == 0)
            return "";

        char c = s.charAt(0);
        
        if ((Character.toUpperCase(c) != 'A' && Character.toUpperCase(c) != 'E' && Character.toUpperCase(c) != 'I' && Character.toUpperCase(c) != 'O' && Character.toUpperCase(c) != 'U') && Character.isLetter(c))
            return c + concatenaConsonanti(s.substring(1, s.length()));

        return "" + concatenaConsonanti(s.substring(1, s.length()));
    }

    public static String concatenaNumeri(String s)
    {
        if (s.length() == 0)
            return "";

        char c = s.charAt(0);
        
        if (Character.isDigit(c))
            return c + concatenaNumeri(s.substring(1, s.length()));

        return "" + concatenaNumeri(s.substring(1, s.length()));
    }
}