import java.util.Scanner;

public class SubstringManipulation{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String str1 = "", str2 = "";
        boolean found = false;
        System.out.print("Inserisci la prima stringa: ");
        str1 = input.nextLine();
         System.out.print("Inserisci la seconda stringa: ");
        str2 = input.nextLine();

        input.close();

        for (int i = 0; i < str1.length() && !found; i++)
        {
          for (int j = i; j < str1.length() && !found; j++)
          {
            if (str1.substring(i, j + 1).equals(str2))
            {
                found = true;
            }
          }
        }   

        if (found)
            System.out.println("La seconda stringa è una sotto stringa della prima");
        else
            System.out.println("La seconda stringa non è una sotto stringa della prima");
    }   
}
