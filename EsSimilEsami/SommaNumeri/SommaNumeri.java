import java.util.Scanner;

public class SommaNumeri{
    public static void main(String[] main){
        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String s = scan.next();

        System.out.println("La somma dei numeri all'interno della stringa è: " + somma(s));
    }

    public static int somma(String s)
    {
        if (s.length() == 0)
            return 0;

        char c = s.charAt(0);

        if (Character.isDigit(c))
            return Integer.parseInt(c + "")  + somma(s.substring(1, s.length()));
        else
            return 0 + somma(s.substring(1, s.length()));
    } 
}