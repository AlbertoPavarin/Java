import java.util.Scanner;

public class TwoNumbers{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      double x, y, diff = 0;
      
      System.out.print("Inserire x: ");
      x = input.nextDouble();
      
      System.out.print("Inserire y: ");
      y = input.nextDouble();
      
      System.out.println("Somma: " + (x+y));
      System.out.println("Prodotto: " + (x*y));
      System.out.println("Media: " + ((x+y)/2));
      
      if (x > y)
      {
         System.out.println("Il valore massimo e': " + x);
         System.out.println("Il valore minimo e': " + y);
      }
      else if (x < y)
      {
         System.out.println("Il valore massimo e': " + y);
         System.out.println("Il valore minimo e': " + x);
      }
      else
      {
         System.out.println("x e y sono uguali");
      }
      
      diff = x - y;
      
      if (diff < 0)
         diff *= -1;
         
      System.out.println("Valore assoluto della differenza: " + diff);
      
      input.close();
   }
}
