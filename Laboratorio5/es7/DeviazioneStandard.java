import java.util.Scanner;

public class DeviazioneStandard{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      double x, n = 0, a = 0, b = 0, dev = 0;
      System.out.print("Inserisci un numero: ");

      while(input.hasNextInt()){
         x = input.nextInt();

         b += x;
         a += x*x;
             
         System.out.print("Inserisci un numero: ");
         n++;
      }
      
      if (n < 2)
      {
         System.out.println("Inserisci almeno 2 numeri");
         System.exit(-1);
      }
      
      System.out.println(a + " " + b*b/n + " " + n);
      
      dev = Math.sqrt((a - b*b/n)/(n-1));
      
      System.out.println("Deviazione standard: " + dev);
      
      input.close();
   }
}
