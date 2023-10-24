public class Cerchio{
   public static void main(String[] args){ 
      double raggio = 10.12;
      final double PI = 3.14159265358979;
      double circ = 2 * raggio * PI;
      
      System.out.println("***La circonferenza di un cerchio di raggio "                         +raggio + "e' pari a " + circ + "***");
     
      double area = PI*raggio*raggio;
      System.out.println("***L'area di un cerchio di raggio "                         + raggio + "e' pari a " + area + "***");
   }
}
