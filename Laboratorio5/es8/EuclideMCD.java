import java.util.Scanner;

public class EuclideMCD{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      double m, n, mcd = 0, max = 0, min = 0, tmp = 0;
      
      System.out.print("Inserisci m: ");
      m = input.nextInt();
      System.out.print("Inserisci n: ");
      n = input.nextInt();
      
      
      if (m == n)
      {
         mcd = n;
      }
      if (m > n)
      {
         max = m;
         min = n;
      }
      else if (m < n)
      {
         max = n;
         min = m;
      }
      
      while(true)
      {
         tmp = max % min;
         max = min;
         mcd = min;
         min = tmp;
         if (tmp == 0)
            break;
      }

      System.out.println(mcd);
      
      input.close();
   }
}
