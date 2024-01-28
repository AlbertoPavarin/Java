// nome e cognome del candidato, matricola, data, numero della postazione
import java.util.*;


public class AgendaTester
{   public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        console.useDelimiter("[\n \\s]+");
        Agenda a = new Agenda();
        String comando = "";
       
        do
        {
            System.out.println("\n-----------Menù-----------");
            System.out.println("Digita \"I\" per inserire un impegno");
            System.out.println("Digita \"R\" per rimuovere l'impegno com priorità più alta");
            System.out.println("Digita \"L\" per leggere l'impegno com priorità più alta");
            System.out.println("Digita \"Q\" per uscire\n");
            comando = console.nextLine().toUpperCase();

            switch (comando)
            {
                case "Q":
                    break;
                case "I":
                    System.out.println("Inserisci la priorità e l'impegno");
                    String ins = console.nextLine();
                    Scanner tokenizer = new Scanner(ins);
                    try
                    {
                        a.insert(Integer.parseInt(tokenizer.next()), tokenizer.nextLine());
                    }
                    catch(NumberFormatException e) { }

                    break;
                case "R":
                    try{
                        System.out.println("Impegno eliminato: " + a.removeMin());
                    }
                    catch(EmptyQueueException e)
                    {}
                    break;
                case "L":
                    try{
                        System.out.println("Impegno con priorità più alta: " + a.getMin());
                    }
                    catch(EmptyQueueException e)
                    {}
                    break;
                default:
                    System.out.println("Comando invalido");
                    break;
            }
            System.out.println("\nAgenda: ");
            System.out.println(a);
        }
        while (!comando.equals("Q"));

        // console.close();
    }

}

class Agenda implements PriorityQueue
{
    //costruttori e metodi pubblici 

    public Agenda()
    {
        this.i = new Impegno[MIN_CAPACITY];
        makeEmpty();
    }

    /*
        svuota la coda di priorita`
    */
    public void makeEmpty()
    {
        this.size = 0;
    }
  
    /*
        restituisce true se la coda e' vuota, false altrimenti
    */
    public boolean isEmpty()
    {
        return this.size == 0;
    }

    /*
        Metodo di inserimento
        Inserisce la coppia "chiave valore" nella coda di priorita`. Notare che 
        la coda di priorita` puo` contenere piu` coppie con la stessa chiave.
        Questo perche` il campo chiave non serve ad identificare univocamente
        un elemento (come nel caso di un dizionario), ma serve invece a definire
        la priorita` di un elemento. E` ovvio che piu` elementi possono avere 
        la stessa priorita`. 
    */
    public void insert (int key, Object value)
    {
        if (this.size == this.i.length)
            this.resize();

        try{
            this.i[this.size++] = new Impegno(key, (String)value);
        }
        catch (IllegalArgumentException e)
        {
            this.size--;
            return;
        }

    }

    /*
        Metodo di rimozione
        Rimuove dalla coda la coppia con chiave minima, e restituisce un 
        riferimento al suo campo value. Se sono presenti piu` coppie con chiave
        minima, effettua la rimozione di una qualsiasi delle coppie con chiave 
        minima (ad es. la prima coppia con chiave minima che e` stata trovata)
        Lancia EmptyQueueException se la coda di priorita` e` vuota
    */
    public Object removeMin() throws EmptyQueueException
    {
        if (this.isEmpty())
            throw new EmptyQueueException();

        int minPos = this.i[0].getPriority();

        for (int j = 1; j < this.size; j++)
        {
            if (this.i[j].getPriority() < minPos)
                minPos = j;
        }

        Impegno tmp = this.i[minPos];
        this.i[minPos] = this.i[this.size-1];
        this.size--;
        return tmp.getMemo();
    }

    /*
        Metodo di ispezione
        Restituisce un riferimento al campo value della coppia con chiave minima
        (ma *non* rimuove la coppia dalla coda).  Se sono presenti piu` coppie 
        con chiave minima, restituisce il campo value di una qualsiasi delle   
        coppie con chiave minima (ad esempio la prima coppia con chiave minima 
        che e` stata trovata). Lancia EmptyQueueException se la coda e` vuota
    */
    public Object getMin() throws EmptyQueueException
    {
        if (this.isEmpty())
            throw new EmptyQueueException();

        int minPos = this.i[0].getPriority();

        for (int j = 1; j < this.size; j++)
        {
            if (this.i[j].getPriority() < minPos)
                minPos = j;
        }

        return this.i[minPos].getMemo();
    }

    public String toString()
    { 
        String str = "";
        for (int j = 0; j < this.size; j++)
            str += this.i[j] + "\n";
        return str;
    }  

    private void resize()
    {
        Impegno[] newI = new Impegno[this.size * 2];
        System.arraycopy(this.i, 0, newI, 0, this.size);
        this.i = newI;
    }
    
    //campi di esemplare  
    private int size;
    private Impegno[] i;
    final int MIN_CAPACITY = 10;

    /*
        classe privata Impegno: rappresenta gli elementi della classe Agenda ed
        e` costituita da coppie "chiave valore" in cui il campo chiave e` di
        tipo int e rappresenta la priorita` dell'impegno, e il campo valore e`
        una stringa contenente un promemoria dell'impegno. Si considerano 4 
        livelli di priorita`, numerati da 0 a 3. Conseguentemente il campo 
        chiave puo` assumere valori solo in questo intervallo, dove il valore 0  
        significa "massima priorita`" e il valore 3 significa "minima priorita`" 
    */
    private class Impegno //non modificare!!
    {   public Impegno(int priority, String memo)
        {   if (priority>3 || priority<0) throw new IllegalArgumentException();
            this.priority = priority;
            this.memo = memo;
        }
        // metodi (pubblici) di accesso
        public int getPriority()
        {   return priority; }
        public Object getMemo()
        {   return memo; }
        //metodo toString sovrascritto
        public String toString()
        {   return priority + " " + memo; }
        //campi di esemplare (privati) della classe Impegno
        private int priority; //priorita` dell'impegno (da 0 a 3)
        private String memo; //promemoria dell'impegno
    }    
}


/*  
    Interfaccia PriorityQueue (non modificare!!). 
    - Questo tipo di dato astratto definisce un contenitore di coppie 
      "chiave valore", dove il campo chiave e` un numero in formato int che 
      specifica il livello di priorita` della coppia mentre il campo valore 
      rappresenta il dato della coppia. 
    - Si assume che date due chiavi k1 e k2 tali che k1 < k2, allora k1 ha 
      priorita` piu` alta di k2.
    - Naturalmente possono essere presenti nel contenitore coppie diverse con 
      chiavi uguali, cioe` con uguale priorita`
*/
interface PriorityQueue //non modificare!!
{   /*
        svuota la coda di priorita`
    */
    void makeEmpty();
  
    /*
        restituisce true se la coda e' vuota, false altrimenti
    */
    boolean isEmpty();

    /*
        Metodo di inserimento
        Inserisce la coppia "chiave valore" nella coda di priorita`. Notare che 
        la coda di priorita` puo` contenere piu` coppie con la stessa chiave.
        Questo perche` il campo chiave non serve ad identificare univocamente
        un elemento (come nel caso di un dizionario), ma serve invece a definire
        la priorita` di un elemento. E` ovvio che piu` elementi possono avere 
        la stessa priorita`. 
    */
    void insert (int key, Object value);

    /*
        Metodo di rimozione
        Rimuove dalla coda la coppia con chiave minima, e restituisce un 
        riferimento al suo campo value. Se sono presenti piu` coppie con chiave
        minima, effettua la rimozione di una qualsiasi delle coppie con chiave 
        minima (ad es. la prima coppia con chiave minima che e` stata trovata)
        Lancia EmptyQueueException se la coda di priorita` e` vuota
    */
    Object removeMin() throws EmptyQueueException;

    /*
        Metodo di ispezione
        Restituisce un riferimento al campo value della coppia con chiave minima
        (ma *non* rimuove la coppia dalla coda).  Se sono presenti piu` coppie 
        con chiave minima, restituisce il campo value di una qualsiasi delle   
        coppie con chiave minima (ad esempio la prima coppia con chiave minima 
        che e` stata trovata). Lancia EmptyQueueException se la coda e` vuota
    */
    Object getMin() throws EmptyQueueException;
}

/*
    Eccezione lanciata dai metodi removeMin e getMin di PriorityQueue quando
    la coda di priorita` e` vuota 
*/
class EmptyQueueException extends RuntimeException {}
