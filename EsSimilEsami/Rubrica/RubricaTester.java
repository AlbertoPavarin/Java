// nome e cognome del candidato, matricola, data, numero della postazione
import java.io.*;
import java.util.*;

public class RubricaTester
{   public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: Rubrica input.txt output.txt");
            System.exit(-1);
        }

        try (FileReader f = new FileReader(args[0]); Scanner s = new Scanner(f))
        {
            s.useDelimiter("\n");
            try
            {
                while(s.hasNextLine())
                    System.out.println(s.next());
            }
            catch(NoSuchElementException e){}
        }
        catch(IOException e)
        {
            System.out.println("Errore in lettura o il file" + args[0] + " non esiste");
        }

        Rubrica r1 = new Rubrica();
        Rubrica r2 = new Rubrica();
    }
}


class Rubrica implements Map
{
    //metodi di Rubrica 
    public boolean isEmpty(){
        return this.size == 0;
    }

    public void makeEmpty(){
        this.size = 0;
    }

    public String toString()
    { 
        String str = "Rubrica:";
        for (int i = 0; i < this.size; i++)
            str += "\n" + this.p[i];

        return str;
    }  

    public void insert(Comparable key, Object value)
    {
        if (key == null)
            throw new IllegalArgumentException();

        if (this.p.length == this.size)
            this.p = resize();

        try
        { // caso numero presente in rubrica;
            int index = binarySearch(key);
            this.p[index].phone = (long)value;
        }
        catch(MapItemNotFoundException e) // caso numero non presente in rubrica
        {
            int i = this.size - 1;
            while (i >= 0 && key.compareTo(this.p[i].getName()) < 0)
            {
                this.p[i+1] = this.p[i];
                i--;
            }

            this.p[i+1] = new Pair(key+"", (long)value);
            this.size++;
        }
    }

    public void remove(Comparable key)
    {
        if (this.isEmpty())
            return;

        try
        { // caso numero presente in rubrica;
            int index = binarySearch(key);
            for (int i = index; i < this.size; i++) 
                this.p[i] = this.p[i+1];

            this.size--;
        }
        catch(MapItemNotFoundException e) // caso numero non presente in rubrica
        {
            throw new MapItemNotFoundException();
        }
    }

    public Object find(Comparable key)
    {
        return this.p[binarySearch(key)].getPhone();
    }

    private int binarySearch(Comparable target)
    {
        return binSearch(0, this.size - 1, target);
    }

    private int binSearch(int from, int to, Comparable target)
    {
        if (from > to || this.isEmpty())
            throw new MapItemNotFoundException();

        int mid = (from + to) / 2;
        Comparable midKey = this.p[mid].getName();

        if (midKey.compareTo(target) == 0) // le chiavi sono uguali
            return mid;
        else if (midKey.compareTo(target) < 0) // la prima chiave è minore della seconda
            return binSearch(from, mid - 1, target);
        else
            return binSearch(mid + 1, to, target);
    }

    private Pair[] resize()
    {
        Pair[] newP =  new Pair[this.size * 2];
        System.arraycopy(this.p, 0, newP, 0, this.size);

        return newP;
    }

    //campi di esemplare di Rubrica 
    final static int MIN_CAPACITY = 10;
    protected int size;
    protected Pair[] p = new Pair[MIN_CAPACITY];


    //classe privata Pair: non modificare!!
    private class Pair
    {   public Pair(String aName, long aPhone)
        {   name= aName; 
            phone = aPhone;
        }
        public String getName() 
        {   return name; }
        public long getPhone() 
        {   return phone; }
        /*
            Restituisce una stringa contenente
            - la nome, "name"
            - un carattere di separazione ( : )
            - il numero telefonico, "phone"
        */
        public String toString() 
        {   return name + " : " + phone; }
        //campi di esemplare
        private String name;
        private long phone;
    }
}


interface Map
{
    /*
        verifica se la mappa contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*Map
        svuota la mappa
    */
    void makeEmpty();

    /*
     Inserisce un elemento nella mappa. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta alla mappa; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dalla mappa l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata MapItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nella mappa l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata MapItemNotFoundException
    */
    Object find(Comparable key);
}

class MapItemNotFoundException extends RuntimeException {}
