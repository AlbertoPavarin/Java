import java.util.*;

public class SquareTester{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      int x = 0, y = 0, lato = 0, height = 0, width = 0;
      String tripla;
      boolean done = false;
      Square []sA = new Square[2];
      int i = 0;
      
      for (int j = 0; j < sA.length; j++)
      {
         while(!done)
         {
            System.out.print("Inserisci la " + (j+1) + "^ tripla: ");
            tripla = console.nextLine();
            try{
               Scanner tokenizer = new Scanner(tripla);
               while(tokenizer.hasNext())
               {
                  x = Integer.parseInt(tokenizer.next());
                  try{
                     y = Integer.parseInt(tokenizer.next());
                  }
                  catch (NoSuchElementException e){}
                  
                  try{
                     lato = Integer.parseInt(tokenizer.next());
                     if (lato <= 0)
                        throw new NumberFormatException();
                     done = true;
                     
                     sA[i++] = new Square(x, y, lato);
                  }
                  catch (NoSuchElementException e){}
                 
               }
            }
            catch (NumberFormatException e)
            {}
         }
         
         done = false;
      }
         
      Square minS;
      Square maxS;
      if (sA[0].getArea() < sA[1].getArea())
      {  
         maxS = sA[1];
         minS = sA[0];
      }
      else
      {  
         maxS = sA[0];
         minS = sA[1];
      }
      
      System.out.println("\nAree:");
      System.out.println(minS.getArea());
      System.out.println(maxS.getArea());

      i = 0;

      System.out.println();
      
      for (int j = 0; j < sA.length; j++)
      {
         while(!done)
         {
            System.out.print("Inserisci la " + (j+1) + "^ doppia: ");
            tripla = console.nextLine();
            try{
               Scanner tokenizer = new Scanner(tripla);
               while(tokenizer.hasNext())
               {
                  width = Integer.parseInt(tokenizer.next());
                  if (width < 0)
                     throw new NumberFormatException();

                  
                  try{
                     height = Integer.parseInt(tokenizer.next());
                     if (height <= 0)
                        throw new NumberFormatException();
                     done = true;
                  }
                  catch (NoSuchElementException e){}

                  try
                  {
                     sA[i++].setSize(width, height);
                  } 
                  catch (IllegalArgumentException e)
                  {
                     System.out.println("Altezza e Larghezza non coincidono");
                     System.exit(-1);
                  }
               }
            }
            catch (NumberFormatException e)
            {}
         }
         
         done = false;
      }
      
      System.out.println("\nAree dopo il resize:");
      if (sA[0].getArea() < sA[1].getArea())
      {  
         maxS = sA[1];
         minS = sA[0];
      }
      else
      {  
         maxS = sA[0];
         minS = sA[1];
      }
      
      System.out.println(minS.getArea());
      System.out.println(maxS.getArea());
   }
}
