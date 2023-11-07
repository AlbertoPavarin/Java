import java.util.Scanner;

public class PrintTimeInterval2{
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
      
      if (oreInizio >= oreFine)
         diffOre = (oreFine - oreInizio) + 24;
      else
         diffOre = oreFine - oreInizio;
         
      diffMin = Math.abs(minutiFine - minutiInizio);
      
      if (diffMin > 0)
         diffOre -= 1;
      
      System.out.println("Tempo trascorso: " + diffOre + " ore e " + diffMin + " minuti");
         
      input.close();
   }
}
