import java.util.Scanner;

public class EncodeCesare{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String str, encodedStr = "";

        System.out.print("Inserisci una stringa: ");
        str = input.nextLine().toUpperCase();

        System.out.print("Inserisci un numero tra 1 e 25: ");
        int n = input.nextInt();

        
        if (n > 25 || n < 1)
        {
            System.out.println("Errore, inserire un numero tra 1 e 25");
            System.exit(0);
        }

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != ' ')
            {
                String encoded = Character.toString(str.charAt(i) + n);
                if (encoded.compareTo("Z") > 0)
                {
                    encoded = Character.toString(encoded.charAt(0) % 26 + 52);
                }
                
                encodedStr += encoded;
            }
            else
            {
                encodedStr += " ";
            }
        }

        System.out.println(encodedStr);

        input.close();
    }
}