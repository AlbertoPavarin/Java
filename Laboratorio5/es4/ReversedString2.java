import java.util.Scanner;

public class ReversedString2{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      String str;
      String revStrs = "";
      String reversedStr = "";

      System.out.print("Inserisci una stringa o ! per fermare: ");

      while(input.hasNext()){
            str = input.next();
            if (str.equals("!"))
               break;

            for (int i = 0; i < str.length(); i++)
               reversedStr = str.charAt(i) + reversedStr;      
                 
            revStrs += reversedStr + " ";
            reversedStr = "";
            System.out.print("Inserisci una stringa o ! per fermare: ");

      }
      
      System.out.println(revStrs);
   }
}
