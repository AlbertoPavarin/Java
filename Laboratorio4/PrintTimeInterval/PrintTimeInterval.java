import java.util.Scanner;

public class PrintTimeInterval{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      String inizio, fine = "";
      int oreInizio, minutiInizio, oreFine, minutiFine, diffMin, diffOre = 0;
      
      System.out.print("Inserire il primo orario: ");
      inizio = input.next();
      
      oreInizio = Integer.parseInt(inizio.substring(0,2));
      minutiInizio = Integer.parseInt(inizio.substring(2));
      
      System.out.print("Inserire il secondo orario: ");
      fine = input.next();
      
      oreFine = Integer.parseInt(fine.substring(0,2));
      minutiFine = Integer.parseInt(fine.substring(2));
      
      //System.out.println(oreInizio + " " + oreFine + " " + minutiInizio + " " + minutiFine);
      
      diffOre = Math.abs(oreInizio - oreFine);
         
      diffMin = Math.abs(minutiFine - minutiInizio);
      
      System.out.println("Tempo trascorso: " + diffOre + " ore e " + diffMin + " minuti");
         
      input.close();
   }
}
