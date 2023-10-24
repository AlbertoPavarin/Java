public class Swap{
   public static void main(String[] args){
      int x = 10;
      int y = 5;
      
      x += y;
      y = x-y;
      x -= y;  
       
      
      System.out.println("X: " + x);
      System.out.println("y: " + y);
   }
}
