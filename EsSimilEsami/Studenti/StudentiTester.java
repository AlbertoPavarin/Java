// nome e cognome del candidato, matricola, data,       numero postazione
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class StudentiTester
{   public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: StudentiTester file1 file2");
            System.exit(-1);
        }

        Studenti st = new Studenti();

        try (FileReader r = new FileReader(args[0]); Scanner s = new Scanner(r))
        {
            while (s.hasNextLine())
            {
                String[] splitted = s.nextLine().split(":");
                try
                {
                    st.insert(Long.parseLong(splitted[0].trim()), splitted[1]);
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException e)
                { }
            }
        }
        catch (IOException e)
        {
            System.out.println("Errore in lettura del file");
            System.exit(-1);
        }

        System.out.println(st);

        Scanner console = new Scanner(System.in);
        String mat = "";
        Studenti st2 = new Studenti();

        do
        {   
            System.out.println("Inserisci il numero di matricola dello studente che desideri spostare (Q per uscire): ");
            mat = console.next();
            try
            {
                long matricola = Long.parseLong(mat);
                Object student = st.find(matricola);
                System.out.println("Lo studente " + mat + " :" + student + " è stato spostato");
                st2.insert(matricola, student);
                st.remove(matricola);
            }
            catch (DictionaryItemNotFoundException | NumberFormatException e)
            {
                System.out.println("Lo studente con la seguente matricola: " + mat + " non è stato trovato");
            }
        } while(!mat.equals("Q"));     

        console.close();

        try (PrintWriter w = new PrintWriter(args[1]))
        {
            w.print(st2);
        }
        catch (IOException e)
        {
            System.out.println("Errore in apertura del file");
        }
    }
}


class Studenti implements Dictionary
{

    //costruttori e metodi pubblici
    public Studenti()
    {
        this.p = new Pair[INIT];
        this.makeEmpty();
    }

    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    public boolean isEmpty()
    {
        return this.size == 0;
    }
    
    /*
        svuota il dizionario
    */
    public void makeEmpty()
    {
        this.size = 0;
    }

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    public void insert(Comparable key, Object value)
    {
        if (key == null || value == null || !(key instanceof Long))
            throw new IllegalArgumentException();

        if (this.size == this.p.length)
            this.resize();

        int pos = binarySearch(0, this.size - 1, key);
        if (pos >= 0)
        {
            this.p[pos] = new Pair((long)key, (String)value);
            return;
        }

        int i = this.size - 1;
        while (i >= 0 && this.p[i].getMatr() > (long)key)
        {
            this.p[i + 1] = this.p[i];
            i--;
        }
        this.p[i + 1] = new Pair((long)key, (String)value);
        this.size++;
    }

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    public void remove(Comparable key)
    {
        if (this.isEmpty())
            throw new DictionaryItemNotFoundException();

        if (key == null || !(key instanceof Long))
            throw new IllegalArgumentException();

        int pos = binarySearch(0, this.size - 1, key);
        if (pos < 0)
            throw new DictionaryItemNotFoundException();

        for (int i = pos; i < this.size; i++)
            this.p[i] = this.p[i + 1];

        this.size--;
    }

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    public Object find(Comparable key)
    {
        if (!(key instanceof Long) || key == null)
            throw new IllegalArgumentException();

        int pos = binarySearch(0, this.size - 1, key);
        if (pos < 0)
            throw new DictionaryItemNotFoundException();

        return this.p[pos].getName();
    }

    private void resize()
    {
        Pair[] newP = new Pair[this.size * 2];
        System.arraycopy(this.p, 0, newP, 0, this.size);
        this.p = newP;
    }

    private int binarySearch(int from, int to, Comparable target)
    {
        if (from > to)
            return -1;

        int mid = (from + to) / 2;
        long midMatr = this.p[mid].getMatr();
        if (midMatr == (long)target)
            return mid;
        else if (midMatr < (long)target)
            return binarySearch(mid + 1, to, target);
        else
            return binarySearch(from, mid - 1, target);
    }
   
    public String toString()
    { 
        String str = "";
        for (int i = 0; i < this.size; i++)
            str += this.p[i] + "\n";

        return str;
    }
    
    //campi di esemplare 
    private Pair[] p;
    private int size;
    private final static int INIT = 10;


    //classe privata Pair: non modificare!!
    private class Pair
    {   public Pair(long matr, String name)
        {   this.matr=matr; 
            this.name=name;
        }
        public long getMatr() 
        {   return matr; }
        public String getName() 
        {   return name; }
        /*
            Restituisce una stringa contenente
            - il numero di matricola, (numero long contenuto in "matr")
            - un carattere di separazione ( : )
            - il nome (stringa di una o piu` parole contenuta in "name")
        */
        public String toString() 
        {   return matr + " : " + name; }
        //campi di esemplare
        private long matr;
        private String name;
    }
}


interface Dictionary
{
    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*
        svuota il dizionario
    */
    void makeEmpty();

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {}
