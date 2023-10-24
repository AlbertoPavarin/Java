public class Operatori{
   public static void main(String[] args){
      int m = 7;
      int n = 4;
      System.out.println("Risultato di 7/4: " + m/n);
      System.out.println("Resto di 7/4: " + m%n);
      // System.out.println("Risultato di m/0: " + m/0); ECCEZIONE
      
      double x = 7.0;
      double y = 0.0;
      System.out.println("Risultato di 7/0: " + x/y); // INFINITO
      System.out.println("Resto di 7/0: " + x%y); // NOT A NUMBER
      
      x = -7.0;
      y = 0.0;
      System.out.println("Risultato di -7/0: " + x/y); // - INFINITO
      System.out.println("Resto di -7/0: " + x%y); // NOT A NUMBER
      
      x = 0.0;
      y = 0.0;
      System.out.println("Risultato di 0/0: " + x/y); // NOT A NUMBER
      System.out.println("Resto di 0/0: " + x%y); // NOT A NUMBER
   }
}
