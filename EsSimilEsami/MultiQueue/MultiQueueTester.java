// nome e cognome del candidato, matricola, data, numero della postazione
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MultiQueueTester
{   public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Uso: MultiQueueTester N");
            System.exit(-1);
        }

        int n = 0;

        try
        {
            n = Integer.parseInt(args[0]);
            if (n <= 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Inserisci un numero intero maggiore di 0");
            System.exit(-1);
        }

        ArrayMultiQueue mu = new ArrayMultiQueue(n);
        Scanner console = new Scanner(System.in);
        boolean done = false;
        String comando = "", nome = "";

        while(!done)
        {
            System.out.println("\n------------Menù------------");
            System.out.println("Digita \"A\" per aggiungere una persona alla multicoda");
            System.out.println("Digita \"R\" per aggiungere una persona alla multicoda");
            System.out.println("Digita \"P\" per aggiungere una persona alla multicoda");
            System.out.println("Digita \"Q\" per aggiungere una persona alla multicoda");

            try
            {
                comando = console.nextLine().toUpperCase();
                switch(comando)
                {
                    case "A":
                        System.out.print("\nInserisci il nome della persona che desideri inserire: ");
                        nome = console.nextLine();
                        mu.add(nome);
                        System.out.println();
                        break;
                    case "R":
                        System.out.println("Da quale coda vuoi eliminare una persona ( da 0 a " + (n - 1) + " )");
                        try
                        {
                            mu.remove(Integer.parseInt(console.nextLine()));
                        }
                        catch (NumberFormatException | EmptyQueueException e)
                        {
                            System.out.println("Indice coda non valido o coda vuota");
                        }
                        break;
                    case "P":
                        System.out.println("\nContenuto della multicoda: ");
                        System.out.println(mu);
                        break;
                    case "Q":
                        done = true;
                        break;
                    default:
                        System.out.println("Comando non riconosciuto");
                        break;

                }
            }
            catch(NoSuchElementException e)
            {
                done = true;
            }
        }
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
        for (int i = 0; i < N; i++)
            this.q[i] = new ArrayQueue();
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
        Queue minQueue = this.q[0];

        for (int i = 1; i < this.q.length; i++)
        {
            if (this.q[i].size() < minQueue.size())
            {
                minQueue = this.q[i];
            }
        }

        minQueue.enqueue(obj);
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
            str += "Coda " + i + ":\n" + this.q[i] + "\n";

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

