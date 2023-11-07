import java.util.Scanner;

public class EvenNumber{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      int number = 0;
      
      System.out.print("Inserisci un numero pari: ");
      number = input.nextInt();
      
      if (number % 2 == 0)
      {
         System.out.println("Bravo! Il numero " + number + " e' pari");
         System.exit(0);
      }
      
      System.out.println("Il numero inserito non e' pari");
      System.out.print("Inserisci un numero pari: ");
      number = input.nextInt();
      
      if (number % 2 == 0)
      {
         System.out.println("Bravo! Il numero " + number + " e' pari");
         System.exit(0);
      }
      
      
      System.out.println("Bro...");
      
      input.close();
   }
}
