import java.util.Scanner;

public class NewLineNumberLister{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int n;
      final int COLUMN_WIDTH = 3;
      
      System.out.print("Inserisci N: ");
      n = input.nextInt();
      
      for (int i = 1; i <= n; i++)
      {
         String formattedNumber = i + "";
         for (int j = 0; j < (COLUMN_WIDTH - formattedNumber.length()); j++)
            System.out.print(" ");
         System.out.print(formattedNumber + " ");
         if (i % 10 == 0)
            System.out.print("\n");
      }
   }
}
