// nome e cognome del candidato, matricola, data, numero della postazione


public class StudentSetTester
{   public static void main(String[] args)
    {
        StudentSet ss = new StudentSet();
        Student s1 = new Student("A", "A", 1235);
        Student s2 = new Student("P", "A", 1233);
        Student s3 = new Student("P", "A", 1234);

        ss.add(s1);
        ss.add(s2);
        ss.add(s3);

        System.out.print("Studenti: ");
        System.out.println(ss);
    }
}


class StudentSet implements SortedSet
{
    //costruttori e metodi pubblici 
    // verifica se l'insieme contiene almeno un elemento
    public boolean isEmpty()
    {
        return this.size == 0;
    }

    // svuota l'insieme
    public void makeEmpty()
    {
        this.size = 0;
    }
  
    // restituisce il numero di elementi nell'insieme
    public int size()
    {
        return this.size;
    }
  
    /*
        Inserisce l'oggetto comparabile obj nell'insieme se non e` gia` 
        presente, altrimenti fallisce silenziosamente.
    */
    public void add(Comparable obj)
    {
        if (this.contains(obj))
            return;

        if (this.s.length == this.size)
            this.s = this.resize();

        int i = this.size - 1;
        while (i >= 0 && ((Student)obj).compareTo(this.s[i]) < 0)
        {
            this.s[i+1] = this.s[i];
            i--;
        }

        this.s[i+1] = (Student)obj;
        this.size++;
    }
  
    /*
        Restituisce true se e solo se l'oggetto comparabile obj appartiene  
        all'insieme. Verranno considerate ottime le soluzioni per cui questo 
        metodo ha prestazioni O(log n) 
    */
    public boolean contains(Comparable obj)
    {
        if (this.isEmpty())
            return false;

        return binarySearch(0, this.size - 1, obj);
    }

    private boolean binarySearch(int from, int to, Object target)
    {
        if (this.isEmpty() || from > to)
            return false;
        
        int mid = (from + to) / 2;
        Student midStu = this.s[mid];

        if (midStu.compareTo(target) == 0)
            return true;
        else if (midStu.compareTo(target) > 0)
            return binarySearch(mid + 1, to, target);
        else
            return binarySearch(from, mid - 1, target);
    }
  
    /*
        Restituisce un array di oggetti comparabili contenente i riferimenti a 
        tutti gli elementi presenti nell'insieme
    */
    public Comparable[] toArray()
    {
        Comparable[] array = new Comparable[this.size];
        for (int i = 0; i < this.size; i++)
            array[i] = this.s[i];

        return array;
    }

    /*
        Riceve due riferimenti ad oggetti comparabili e restituisce un
        riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
        dell'insieme di partenza (cioe` il parametro implicito del metodo) 
        compresi tra fromObj (incluso) e toObj (escluso). 
        Se fromObj non appartiene all'insieme di partenza, il primo elemento 
        del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
        nell'insieme di partenza.
        Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
        il nuovo insieme sara` vuoto
    */
    public SortedSet subSet(Comparable fromObj, Comparable toObj)
    {
        SortedSet set = new StudentSet();
        if (fromObj.equals(toObj) || fromObj.compareTo(toObj) < 0)
            return set;

        for (int i = 0; i < this.size; i++)
        {
            if (fromObj.compareTo(this.s[i]) >= 0 && toObj.compareTo(this.s[i]) < 0)
                set.add(this.s[i]);
        }

        return set;
    }

    public String toString()
    { 
        String str = "";
        for (int i = 0; i < this.size; i++)
            str += "\n" + this.s[i];
        return str; 
    }   

    private Student[] resize()
    {
        Student[] newS = new Student[this.size * 2];
        System.arraycopy(this.s, 0, newS, 0, this.size);

        return newS;
    }       

    //campi di esemplare 
    protected int size;
    protected Student[] s = new Student[10];
}



class Student implements Comparable   //non modificare!!
{   public Student (String c, String n, int m) 
    {   cognome = c;
        nome = n;
        matricola = m;
    }

    public String getCognome()
    {   return cognome; }

    public String getNome()
    {   return nome; }

    public int getMatricola()
    {   return matricola; }


    /*
      I dati dello studente vengono stampati nel formato
      "cognome        nome          : n.matricola"
      Per il campo cognome e per il campo nome vengono allocati maxlength=15
      caratteri
    */
    public String toString()
    {   int maxlength = 15;
        String sep1 = "";
        for (int i = 0; i < maxlength - cognome.length(); i++) sep1 += " ";
        String sep2 = "";
        for (int i = 0; i < maxlength - nome.length(); i++) sep2 += " ";
        return cognome + sep1 + nome + sep2 + ": " + matricola; 
    }

    /*
     Lo studente x e` "maggiore" dello studente y se il cognome di x segue
     quello di y secondo l'ordinamento lessicografico. Se i due cognomi sono
     uguali, allora x e` "maggiore" di y se il nome di x segue quello di y 
     secondo l'ordinamento lessicografico. Se anche i nomi sono uguali
     (due studenti omonimi) allora x e` "maggiore" di y se la sua matricola
     e` piu` grande di quella di y.
     Esempio1:
     (DeMorgan Augustus : 511123) e` maggiore di (Babbage Charles : 599987)
     Esempio2:
     (Bernoulli Nicolaus : 577789) e` maggiore di (Bernoulli Jacob : 500098)
     Esempio3:
     (Bernoulli Nicolaus : 588890) e` maggiore di (Bernoulli Nicolaus : 577789)

    */
    public int compareTo(Object other)
    {   Student aStudent = (Student) other;
        int comp = cognome.compareTo( ((Student) other).cognome);
        if (comp == 0) comp = nome.compareTo(((Student) other).nome);
        if (comp == 0) comp = matricola - ((Student) other).matricola;
        return comp;
    }

    /*
      Due studenti x e y sono "uguali" solo se hanno lo stesso cognome e lo 
      stesso nome e lo stesso numero di matricola. 
      Esempio:
     (Babbage Charles : 599987) e` uguale a (Babbage Charles : 599987)

    */
    public boolean equals(Object other)
    {   return this.compareTo(other) == 0;
    }

    private String cognome;
    private String nome;
    private int matricola;
}


interface SortedSet     //non modificare!!
{   // verifica se l'insieme contiene almeno un elemento
    boolean isEmpty(); 

    // svuota l'insieme
    void makeEmpty();
  
    // restituisce il numero di elementi nell'insieme
    int size();
  
    /*
        Inserisce l'oggetto comparabile obj nell'insieme se non e` gia` 
        presente, altrimenti fallisce silenziosamente.
    */
    void add(Comparable obj);
  
    /*
        Restituisce true se e solo se l'oggetto comparabile obj appartiene  
        all'insieme. Verranno considerate ottime le soluzioni per cui questo 
        metodo ha prestazioni O(log n) 
    */
    boolean contains(Comparable obj);
  
    /*
        Restituisce un array di oggetti comparabili contenente i riferimenti a 
        tutti gli elementi presenti nell'insieme
    */
    Comparable[] toArray();

    /*
        Riceve due riferimenti ad oggetti comparabili e restituisce un
        riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
        dell'insieme di partenza (cioe` il parametro implicito del metodo) 
        compresi tra fromObj (incluso) e toObj (escluso). 
        Se fromObj non appartiene all'insieme di partenza, il primo elemento 
        del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
        nell'insieme di partenza.
        Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
        il nuovo insieme sara` vuoto
    */
    SortedSet subSet(Comparable fromObj, Comparable toObj);

}
