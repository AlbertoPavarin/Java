public class SortedArraySortedMap implements SortedMap {
	private Pair[] p; // sempre ordinato per chiave	
	private int pSize; 

	public SortedArraySortedMap(){ 	
	   p = new Pair[1]; // qualsiasi dimensione > 0  
		makeEmpty(); 
	}
	
	//metodo specifico di SortedMap
	public Comparable[] sortedKeys(){
	   Comparable[] keys = new Comparable[pSize]; 
		for (int i = 0; i < pSize; i++){ 
			keys[i] = (Comparable) p[i].getKey();  
		}	
		return keys; 
	}
	
	// metodo di utilita'
	public int size(){ 
	   return pSize; 
	}

	//metodi definiti in Map
	public Object[] keys(){ // non è richiesto che siano 	
	   return sortedKeys(); // "disordinate", quindi posso
	}                       // restituirle ordinate
	
	public Object put(Object key, Object value)
	{	if (key==null || value==null || !(key instanceof Comparable)) 
			throw new IllegalArgumentException(); 

		//verifico se esiste gia' un'associazione con la stessa chiave	
		int pos = binSearch(key); // ricerca binaria 
		if (pos >= 0){	
		   Object old = p[pos].getValue(); 
			p[pos] = new Pair((Comparable)key, value); // nuova associazione 
			return old;		// non si incrementa pSize 
		}
		// se non c'e', controllo se la mappa e' piena
		// e in caso affermativo, ridimensiono
		if (pSize == p.length){
			p = resize(p, 2*p.length);	
		}
		// inserimento nell’array ordinato
		int i = pSize - 1;
		while (i>=0 && ((Comparable)key).compareTo(p[i].getKey())< 0){	
		   p[i+1] = p[i]; 
			i--; 
		} 
		p[i+1] = new Pair((Comparable)key, value); // inserisco nell’array
		pSize++; // si incrementa pSize 
		return null; 
	} 

	// i metodi get e remove usano la ricerca binaria 
	public Object get(Object key)   // il controllo su Comparable lo fa
	{	int pos = binSearch(key); 	  // binSearch	
		if (pos == -1) {
			return null; // non c’è 
		}	
		return p[pos].getValue(); 
	} 

	public Object remove(Object key)
	{	int pos = binSearch(key); 
		if (pos == -1){
			return null; // non c’è 
		}	
		Object obj = p[pos].getValue(); 
		for (int i = pos; i < pSize-1; i++){
			p[i] = p[i+1]; // mantengo l’ordinamento
		}	
		pSize--;
		return obj;
	} 

	private int binSearch(Object key){ 	
	   // NON statico così non si devono passare 
		// p e pSize come parametri 
		if (!(key instanceof Comparable)){
			return -1; 
		}	
		return binarySearch(0, pSize-1, (Comparable)key);
	}
	
	private int binarySearch(int left, int right, Comparable target){
	   if(right<left){
	      return -1;
	   }	   
	   int m = (left+right)/2;
	   int comp = p[m].getKey().compareTo(target);
	   if(comp==0){
	      return m;
	   }
	   if(comp<0){
	      return binarySearch(m+1,right,target);
	   }
	   else{
	      return binarySearch(left,m-1,target);
	   }
	  
	}
	
	private Pair[] resize(Pair[] oldv, int newsize){
         Pair[] newV = new Pair[newsize];
         System.arraycopy(oldv,0,newV,0,oldv.length);
         return newV;
   }
	
	//metodi definiti in Container
	public void makeEmpty(){
	   pSize = 0;
	}
	public boolean isEmpty() { 
	   return (pSize == 0); 
	}
	
	private class Pair{ // interna alla classe ArrayMap  
      private Comparable key;
      private Object value;
      
      public Pair(Comparable k, Object v){  
         setKey(k); 
         setValue(v); 
      }
   
      public Comparable getKey(){  
         return key;
      }
      public Object getValue(){  
         return value;
      }
      public void setKey(Comparable k){  
         key = k;
      }
      public void setValue(Object v){
         value = v;
      }
	}
}	