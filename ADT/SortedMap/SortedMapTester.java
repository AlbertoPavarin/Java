import java.util.*;

public class SortedMapTester{

   public static void main(String[] args){
   
      ArraySortedMap m = new ArraySortedMap();
      
      String s = "Una stringa di prova per testare la mappa con una stringa con duplicati";
      Scanner scan = new Scanner(s);
      
      while(scan.hasNext()){
         String str = scan.next();
         System.out.println("Inserisco ("+str+","+str.length()+")");
         Object dup = m.put(str,str.length());
         if(dup != null){
            System.out.println("Duplicato!");
         }
      }
      
      System.out.println("Numero di elementi introdotti "+m.size());
     
      System.out.println("Cerco la lunghezza associata alla parola \"prova\"");
      Object obj = m.get("prova");
      if(obj == null){
         System.out.println("La parola cercata non esiste nella mappa");
      }
      else{
         System.out.println("la lunghezza e' "+(Integer)obj);
      }
      
      System.out.println("Rimuovo l'associazione con chiave \"prova\"");
      m.remove("prova");
      
      System.out.println("Cerco la lunghezza associata alla parola \"prova\"");
      obj = m.get("prova");
      if(obj == null){
         System.out.println("La parola cercata non esiste nella mappa");
      }
      else{
         System.out.println("la lunghezza e' "+(Integer)obj);
      }
      
      Comparable[] k = m.sortedKeys();
      System.out.println("Stampo le chiavi (che saranno in ordine)");
      for(int i=0;i<k.length;i++){
         System.out.println(k[i]);
      }
      
      scan.close();
   
   }


}