// nome e cognome del candidato, matricola, data, numero della postazione
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class TraduttoreTester
{   public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: TraduttoreTester file1 file2");
            System.exit(-1);
        }

        Traduttore t = new Traduttore();

        try (FileReader r = new FileReader(args[0]); Scanner s = new Scanner(r))
        {
            try{
                while(s.hasNextLine())
                {
                    inserimento(t, s.nextLine());
                }
            }
            catch (NoSuchElementException e)
            {}
        }
        catch (IOException e)
        {   
            System.out.println("Errore in lettura file");
            System.exit(-1);
        }

        System.out.println("Traduttore: \n" + t);

        String record = "";
        Scanner console = new Scanner(System.in);
        boolean done = false;
        Traduttore t2 = new Traduttore();

        while (!done)
        {
            try
            {
                System.out.print("Inseirsci un nuovo record: ");
                record = console.nextLine();
                inserimento(t2, record);
            }
            catch (NoSuchElementException e)
            {
                done = true;
            }
        }

        try (PrintWriter w = new PrintWriter(args[1]))
        {
            t.update(t2);
            w.println(t);
        }
        catch (IOException e)
        {
            System.out.println("Errore in apertura o scrittura file");
        }
    }

    private static void inserimento(Traduttore t, String s)
    {
        String[] splitted = s.split(":");
        String[] tradSplit = null;
        try
        {
            tradSplit = splitted[1].trim().split(" ");
        }
        catch (ArrayIndexOutOfBoundsException e)
        { 
        }

        try
        {
            t.insert(splitted[0], tradSplit);
        }
        catch(IllegalArgumentException e)
        {}
    }
}


class Traduttore implements DictionaryUD
{
    //costruttori e metodi pubblici

    public Traduttore()
    {
        this.words = new WordPair[INIT_CAPACITY];
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

    public int size()
    {
        return this.size;
    }

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    public void insert(Comparable key, Object value)
    {
        if (key == null || value == null)
            throw new IllegalArgumentException();

        int pos = binarySearch(0, this.size - 1, key);

        if (this.size == this.words.length)
            this.resize();

        if (pos >= 0)
        {
            this.words[pos] = new WordPair((String)key, (String[])value);
            return;
        }

        int i = this.size - 1;
        while (i >= 0 && this.words[i].getWord().compareTo((String)key) > 0)
        {
            this.words[i+1] = this.words[i];
            i--;
        }

        this.words[i + 1] = new WordPair((String)key, (String[])value);
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

        int pos = binarySearch(0, this.size - 1, key);

        if (pos < 0)
            throw new DictionaryItemNotFoundException();

        for (int i = pos; i < this.size - 1; i++)
            this.words[i] = this.words[i + 1];

        this.size--;
    }

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    public Object find(Comparable key)
    {
        if (this.isEmpty())
            throw new DictionaryItemNotFoundException();

        int pos = binarySearch(0, this.size - 1, key);
        if (pos < 0)
            throw new DictionaryItemNotFoundException();
            
        return this.words[pos].getTranslations();
    }

    /* 
     Aggiorna il contenuto del dizionario (parametro implicito del metodo) con 
     il contenuto del dizionario newdict (parametro esplicito del metodo). 
     Piu' precisamente:
     a) se newdict contiene una chiave key non presente nel dizionario, la 
        coppia corrispondente (key value) viene scritta nel dizionario
     b) se newdict contiene una chiave key gia' presente nel dizionario, la 
        coppia (key value) presente nel dizionario viene sovrascritta da quella 
        di newdict 
    */
    public void update(DictionaryUD newdict)
    {
        for (int i = 0; i < ((Traduttore)newdict).size(); i++)
        {
            this.insert(((Traduttore)newdict).words[i].getWord(), ((Traduttore)newdict).words[i].getTranslations());
        }
    }

    public String toString()
    { 
        String str = "";
        for (int i = 0; i < this.size; i++)
            str += this.words[i] + "\n";
        return str;
    }  

    private void resize()
    {
        WordPair[] newWords = new WordPair[this.size * 2];
        System.arraycopy(this.words, 0, newWords, 0, this.size);
        this.words = newWords;
    }

    private int binarySearch(int from, int to, Object target)
    {
        if (from > to)
            return -1;

        int mid = (from + to)/2;
        Comparable midKey = this.words[mid].getWord();

        if (midKey.compareTo(target) == 0)
            return mid;
        else if (midKey.compareTo(target) < 0)
            return binarySearch(mid + 1, to, target);
        else
            return binarySearch(from, mid - 1, target);
    }
    
    //campi di esemplare  
    protected int size;
    protected WordPair[] words;
    private final int INIT_CAPACITY = 10;

    //classe privata WordPair: non modificare!!
    private class WordPair
    {   public WordPair(String word, String[] translations)
        {   this.word = word; 
            this.translations = translations;
        }
      
        public String getWord() 
        { return word; }
        public String[] getTranslations() 
        { return translations; }
        /*
            Restituisce una stringa contenente
            - la parola word
            - un carattere di separazione ( : )
            - gli elementi dell'array translations, separati da uno spazio
        */
        public String toString() 
        {   String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
	        retString += " " + translations[i];
            return retString;
        }
        //campi di esemplare
        private String word;
        private String[] translations;
    }
}


interface DictionaryUD   //non modificare!!
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
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
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

    /* 
     Aggiorna il contenuto del dizionario (parametro implicito del metodo) con 
     il contenuto del dizionario newdict (parametro esplicito del metodo). 
     Piu' precisamente:
     a) se newdict contiene una chiave key non presente nel dizionario, la 
        coppia corrispondente (key value) viene scritta nel dizionario
     b) se newdict contiene una chiave key gia' presente nel dizionario, la 
        coppia (key value) presente nel dizionario viene sovrascritta da quella 
        di newdict 
    */
    void update(DictionaryUD newdict);
}

class DictionaryItemNotFoundException extends RuntimeException  {}
