public class ArraySortedMap implements SortedMap {
    private int size;
    private Pair[] pairs;

    public ArraySortedMap()
    {
        this.pairs = new Pair[5];
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    public int size()
    {
        return this.size;
    }

    public Comparable[] sortedKeys()
    {
        Comparable[] keys = new Comparable[this.size];
        for (int i = 0; i < this.size; i++)
            keys[i] = (Comparable) this.pairs[i].getKey();

        return keys;
    }

    public Object put(Object key, Object value){
        if (key == null || value == null || !(key instanceof Comparable))
            throw new IllegalArgumentException();

        int pos = this.binSearch(key);

        if (pos >= 0)
        {
            Pair oldPair = this.pairs[pos];
            this.pairs[pos] = new Pair((Comparable)key, value); 
            return oldPair.getValue();
        }   

        if (this.size == this.pairs.length)
            this.pairs = this.resize(this.pairs.length, this.pairs.length * 2);
        
        int i = this.size - 1;
        while (i >= 0 && ((Comparable) key).compareTo(this.pairs[i].getKey()) < 0)
        {
            this.pairs[i + 1] = this.pairs[i];
            i--;
        }

        this.pairs[i + 1] = new Pair((Comparable)key, value);
        this.size++;
        return null;
    }

    public Object get(Object key){
        int pos = binSearch(key);

        if (pos >= 0)
            return this.pairs[pos].getValue();

        return null;
    }

    public Object remove(Object key){
        int pos = binSearch(key);

        if (pos < 0)
            return null;

        Object removedPair = this.pairs[pos].getValue();

        for (int i = pos; i < this.size; i++)
            this.pairs[i] = this.pairs[i+1];

        this.size--;

        return removedPair;
    }

    public Object[] keys(){
        return this.sortedKeys();
    }

    private int binSearch(Object key)
    {
        if (!(key instanceof Comparable))
            return -1;
        
        return binarySearch(0, this.size - 1, key);
    }

    private int binarySearch(int from, int to, Object key)
    {
        if (from > to)
            return -1; // l'elemento non è stato trovato

        int mid = (from + to) / 2;
        Pair midValue = this.pairs[mid];

        if (midValue.getKey().compareTo(key) == 0) // se sono uguali
            return mid;
        else if (midValue.getKey().compareTo(key) >= 1)
            return binarySearch(from, mid - 1, key);
        else
            return binarySearch(mid + 1, to, key);
    }

    private Pair[] resize(int oldL, int newL)
    {
        Pair[] newPairs = new Pair[newL];
        for (int i = 0; i < oldL; i++)
            newPairs[i] = this.pairs[i];

        return newPairs;
    }

    private class Pair{
        private Comparable key;
        private Object value;

        public Pair(Comparable k, Object v)
        {   
            this.setKey(k);
            this.setValue(v);
        }

        public void setKey(Comparable k)
        {
            this.key = k;
        }

        public void setValue(Object v)
        {
            this.value = v;
        }

        public Comparable getKey()
        {
            return this.key;
        }

        public Object getValue()
        {
            return this.value;
        }
    }
}