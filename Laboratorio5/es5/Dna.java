import java.util.Scanner;

public class Dna{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      String str;
      String replaced = "";

      System.out.print("Inserisci una sequenza DNA: ");

      str = input.next().toUpperCase();
      
      for (int i = 0; i < str.length(); i++)
      {
         if (str.charAt(i) != 'A' && str.charAt(i) != 'C' && str.charAt(i) != 'T' && str.charAt(i) != 'G')
         {
            System.out.println("Sequenza non valida!");
            System.exit(-1);
         }
         
         
         if (str.charAt(i) == 'A')
            replaced = 'T' + replaced;
            
        if (str.charAt(i) == 'T')
            replaced = 'A' + replaced;
            
        if (str.charAt(i) == 'C')
            replaced = 'G' + replaced;
            
        if (str.charAt(i) == 'G')
            replaced = 'C' + replaced;
         
      }
      System.out.println(replaced);   
      input.close();
   }   
}
