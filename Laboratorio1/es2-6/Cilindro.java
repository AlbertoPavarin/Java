import java.lang.Math;

public class Cilindro{
   public static void main(String[] args){ 
      double raggio = 10.12;
      double altezza = 10.87;
      double circ = 2 * raggio * Math.PI;
     
      double areaBase = Math.PI*raggio*raggio;
      double volume = areaBase * altezza;
      
      System.out.println("***Il volume del cilindro di raggio" + raggio +     "e altezza " + altezza + " e' pari a " + volume + "***");
   }
}
