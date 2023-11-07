import java.util.Scanner;

public class SortThreeStrings{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
         
      String strUno, strDue, strTre, strMax, strMin, strMed = "";
      
      System.out.print("Inserisci la prima stringa: ");
      strUno = input.nextLine();
      
      System.out.print("Inserisci la seconda stringa: ");
      strDue = input.nextLine();
      
      System.out.print("Inserisci la terza stringa: ");
      strTre = input.nextLine();
      
      if (strUno.charAt(0) > strDue.charAt(0))
      {
         strMax = strUno;
         strMin = strDue;
      }
      else
      {
         strMax = strDue;
         strMin = strUno;
      }
      
      if (strMin.charAt(0) > strTre.charAt(0))
         strMin = strTre;
      
      if (strMax.charAt(0) < strTre.charAt(0))
         strMax = strTre;
         
      if (strMax != strTre && strMax != strTre)
         strMed = strTre;
         
      if (strMax != strUno && strMin != strUno)
         strMed = strUno;
         
      if (strMax != strDue && strMin != strDue)
         strMed = strDue;
            
      System.out.println(strMin);
      System.out.println(strMed);
      System.out.println(strMax);
      
      input.close();
   }
}
