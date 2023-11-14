import java.util.Scanner;

public class SomeNumbers{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      double x, prod = 1, absSum = 0, avg = 0, cnt = 0, sum = 0;
      System.out.print("Inserisci un numero: ");

      while(input.hasNextInt()){
         x = input.nextInt();

         sum += x;  
         absSum += Math.abs(x); 
         prod *= x;
             
         System.out.print("Inserisci un numero: ");
         cnt++;
      }
      
      if (cnt < 2)
      {
         System.out.println("Inserisci almeno 2 numeri");
         System.exit(-1);
      }
      
      System.out.println("Somma: " +sum);
      System.out.println("Somma in valore assoluto: " + absSum);
      System.out.println("Prodotto: " + prod);
      System.out.println("Media: " + (sum/cnt));
      
      input.close();
   }
}
