// nome e cognome del candidato, matricola, data, numero della postazione


public class MultiQueueTester
{   public static void main(String[] args)
    {
        ArrayQueue q = new ArrayQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println("\n" + q);
    }
}


//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia Queue usando un array (array riempito
// solo in parte, oppure array riempito solo nella parte centrale, oppure
// array circolare), con o senza ridimensionamento. La classe sovrascrive 
// il metodo toString
// ....... da completare ............

class ArrayQueue implements Queue
{
    public ArrayQueue()
    {
        this.q = new Object[INIT];
        makeEmpty();
    }
    //metodi pubblici dell'interfaccia Queue
    // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    public boolean isEmpty()
    {
        return this.front == this.back;
    }

    // Svuota la coda
    public void makeEmpty()
    {
        this.front = this.back = 0;
    }
  
    // Restituisce il numero di elementi presenti nella coda
    public int size()
    {
        return (this.back - this.front);
    }

    // Inserisce l'oggetto obj nella coda
    public void enqueue(Object obj)
    {
        if (obj == null)
            throw new IllegalArgumentException();

        if (increment(this.back) == this.front)
        {
            this.resize();
            if (this.front > this.back)
            {
                System.arraycopy(this.q, 0, this.q, this.q.length, back);
                back += this.q.length / 2;
            }
        }

        this.q[this.back] = obj;
        this.back = increment(this.back);
    }

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    public Object dequeue() throws EmptyQueueException
    {
        if (this.isEmpty())
            throw new EmptyQueueException();

        Object tmp = getFront();
        this.front = increment(this.front);
        return tmp;
    }

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    public Object getFront() throws EmptyQueueException
    {
        if (this.isEmpty())
            throw new EmptyQueueException();

        return this.q[front];
    }

    private int increment(int i)
    {
        return (i + 1) % this.q.length; 
    }

    private void resize()
    {
        Object[] newO = new Object[this.q.length*2];
        System.arraycopy(this.q, 0, newO, 0, this.q.length);
        this.q = newO;
    }

    //metodo toString ..... da completare .........
    public String toString()
    {
        String str = "";
        for (int i = this.front; i < this.back; i++)
            str += this.q[i] + "\n";

        return str;
    }          

    //campi di esemplare ..... da completare ......
    private final static int INIT = 5;
    private Object[] q; 
    private int front, back;
}


//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia MultiQueue usando un array di N code. 
// La classe sovrascrive il metodo toString
// ....... da completare ............

class ArrayMultiQueue implements MultiQueue
{
    //costruttore ......da completare ......
    // crea una multicoda vuota, costituita da una sequenza di N code vuote,
    // con N > 0
    public ArrayMultiQueue(int N)
    {
        this.q = new Queue[N];
    }          
    
    //metodi pubblici dell'interfaccia MultiQueue
    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    public boolean isEmpty()
    {
        for (int i = 0; i < this.q.length; i++)
        {
            if (!this.q[i].isEmpty())
                return false;
        }

        return true;
    }

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    public void makeEmpty()
    {
        for (int i = 0; i < this.q.length; i++)
            this.q[i].makeEmpty();
    }
  
    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    public void add(Object obj)
    {

    }

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il 
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    public Object remove(int i) throws EmptyQueueException
    {
        if (i < 0 || i > this.q.length)
            throw new IllegalArgumentException();

        if (this.q[i].isEmpty())
            throw new EmptyQueueException();

        return this.q[i].dequeue();
    }

    //metodo toString ..... da completare .........
    public String toString()
    {   
        String str = "";
        for (int i = 0; i < this.q.length; i++)
            str += this.q[i] + "\n";

        return str;
    }          

    //campi di esemplare 
    private Queue[] q; 
}


//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto coda

interface Queue
{   // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    boolean isEmpty(); 

    // Svuota la coda
    void makeEmpty();
  
    // Restituisce il numero di elementi presenti nella coda
    int size();

    // Inserisce l'oggetto obj nella coda
    void enqueue(Object obj);

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    Object dequeue() throws EmptyQueueException;

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    Object getFront() throws EmptyQueueException;
}

//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Eccezione lanciata da dequeue e getFront quando la coda e` vuota

class EmptyQueueException extends RuntimeException { }


//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto "multicoda".
// Una multicoda e` una sequenza di N code. Ciascuna delle N code e` 
// identificata da un indice intero i, dove 0 <= i < N.

interface MultiQueue     
{
    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    boolean isEmpty(); 

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    void makeEmpty();
  
    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    void add(Object obj);

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il 
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    Object remove(int i) throws EmptyQueueException;
}

