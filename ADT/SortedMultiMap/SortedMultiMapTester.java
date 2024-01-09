import java.util.*;

public class SortedMultiMapTester{

   public static void main(String[] args){
   
      SortedArrayMultiMap m = new SortedArrayMultiMap();
      
      String s = "Una stringa di prova per testare la multimappa con una stringa con duplicati";
      Scanner scan = new Scanner(s);
      
      while(scan.hasNext()){
         String str = scan.next();
         System.out.println("Inserisco ("+str+","+str.length()+")");       
         m.insert(str,str.length());
      }
      
      System.out.println("Numero di elementi introdotti "+m.size());
     
      System.out.println("Cerco la lunghezza associata alla parola \"prova\"");
      Object obj = m.find("prova");
      if(obj == null){
         System.out.println("La parola cercata non esiste nella mappa");
      }
      else{
         System.out.println("la lunghezza e' "+(Integer)obj);
      }
      
      System.out.println("Rimuovo l'associazione con chiave \"prova\"");
      m.remove("prova");
      
      System.out.println("Cerco la lunghezza associata alla parola \"prova\"");
      obj = m.find("prova");
      if(obj == null){
         System.out.println("La parola cercata non esiste nella mappa");
      }
      else{
         System.out.println("la lunghezza e' "+(Integer)obj);
      }
      
      Object[] k = m.keys();
      System.out.println("Stampo le chiavi (che saranno in ordine)");
      for(int i=0;i<k.length;i++){
         System.out.println(k[i]);
      }
      
      Object[] valK = m.findAll("stringa");
      System.out.println("Stampo le associazioni di stringa");
      for(int i=0;i<valK.length;i++){
         System.out.println(valK[i]);
      }
      
      valK = m.removeAll("stringa");
      System.out.println("Rimuovo le associazioni di stringa");
      for(int i=0;i<valK.length;i++){
         System.out.println(valK[i]);
      }
      
      
      k = m.keys();
      System.out.println("Stampo le chiavi (stringa non ci sara' piu')");
      for(int i=0;i<k.length;i++){
         System.out.println(k[i]);
      }
      
      
      System.out.println("Rimuovo una associazione di con");
      System.out.println(m.remove("con"));
      
      k = m.keys();
      System.out.println("Stampo le chiavi (con avra' una sola occorrenza)");
      for(int i=0;i<k.length;i++){
         System.out.println(k[i]);
      }
      
      scan.close();
   
   }
}