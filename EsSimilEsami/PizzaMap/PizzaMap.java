class PizzaMap extends FixedArrayMap{

    /* Il metodo put verifica i pre-requisiti per una mappa che memorizza 
       associazioni tra il nome della pizza (una parola) e il prezzo associato 
       (di tipo in grado di gestire numeri con la virgola). 
       Il metodo put di FixedArrayMap lancia l’eccezione FullMapException se la mappa è piena. 
       In questo caso l’eccezione deve essere catturata e gestita ridimensionando opportunamente l’array p, prima di inserire la nuova associazione.
       Il valore restituito è il valore precedentemente associato alla data chiave, se già presente, oppure null, se la chiave è nuova nella mappa.
    */
    public Object put(Object key, Object value)
    {
        // validazione della chiave, il nome della pizza
        if (!(key instanceof String) || (key + "").split(" ").length != 1)
            throw new IllegalArgumentException();

        // validazione del valore, il prezzo della pizza
        if (!(value instanceof Double) || (double)value < 0)
            throw new IllegalArgumentException();

        Object old;
        try
        {
            old = super.put(key, value);
        }
        catch(FullMapException e)
        {
            this.p = resize(this.pSize * 2);
            old = super.put(key, value);
        }
        
        return old;
    }

    /* Il metodo printMenu() stampa il contenuto della mappa, 
       ordinando le pizze per prezzo. L’array p, ovvero il contenitore dei 
       dati della mappa, non deve essere modificato. 
       Per l’ordinamento potete utilizzare qualsiasi algoritmo visto durante il corso. 
       La priorità è che funzioni correttamente, in seconda battuta verrà valutata anche 
       la complessità dell’algoritmo utilizzato che dovrete specificare come commento nel codice.
    */
   /*
    Avendo utilizzato l'algoritmo di ordinamento MergeSort la complessità
    è O(nlogn), sia nel caso migliore, che nel caso medio che in quello peggiore
   */
    public String printMenu()
    {
        String menu = "";
        this.mergeSort(this.p, this.pSize);
        for (int i = 0; i < this.pSize; i++)
        {
            menu += this.p[i].getKey() + ": " + this.p[i].getValue() + "\n";
        }

        return menu;
    }

    private void mergeSort(Pair[] pairsArr, int length)
    {
        if (length == 0 || length < 2)
            return;
        
        int mid = (length) / 2;
        Pair[] left = new Pair[mid];
        Pair[] right = new Pair[length - mid];
        System.arraycopy(pairsArr, 0, left, 0, mid);
        System.arraycopy(pairsArr, mid, right, 0, length - mid);

        mergeSort(left, left.length);
        mergeSort(right, right.length);

        merge(pairsArr, left, right);
    }

    private void merge(Pair[] a, Pair[] b, Pair[] c)
    {
        int aI = 0, bI = 0, cI = 0;

        while (bI < b.length && cI < c.length)
        {
            if ((double)b[bI].getValue() < (double)c[cI].getValue())
                a[aI++] = b[bI++];
            else    
                a[aI++] = c[cI++];
        }

        while(bI < b.length)
            a[aI++] = b[bI++];
        
        while(cI < c.length)
            a[aI++] = c[cI++];
    }
    
    private Pair[] resize(int newLength)
    {
        Pair[] newP = new Pair[newLength];
        System.arraycopy(this.p, 0, newP, 0, this.pSize);
        return newP;
    }
}