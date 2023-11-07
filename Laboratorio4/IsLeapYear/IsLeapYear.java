import java.util.Scanner;

public class IsLeapYear{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      int anno = 0;
      
      System.out.print("Inserisci l'anno: ");
      anno = input.nextInt();
      
      if (anno < 0)
      {
         System.out.println("L'anno inserito non puo' essere minore di 0");
         System.exit(0);
      }
      
      if (anno % 100 == 0 && anno % 400 != 0)
      {
         System.out.println("L'anno inserito non e' bisestile");
      }
      else if (anno % 4 == 0 || anno % 400 == 0)
      {
         System.out.println("L'anno inserito e' bisestile");
      }  
      else
      {
         System.out.println("L'anno inserito non e' bisestile");
      }
      
      input.close();
   }
}
