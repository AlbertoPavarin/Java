public class SortedArrayMultiMap implements SortedMultiMap
{
    private int size;
    private Pair[] pairs;

    public SortedArrayMultiMap()
    {
        this.size = 0;
        this.pairs = new Pair[5];
    }

    public void insert(Object key, Object value)
    {
        if (key == null || value == null || !(key instanceof Comparable))
            throw new IllegalArgumentException();

        int pos = binSearch(key);

        if (this.pairs.length == this.size)
            this.pairs = this.resize(this.pairs.length * 2);

        if (pos >= 0)
        {   
            int k = 0;
            while (k != pos)
            {
                this.pairs[k + 1] = this.pairs[k];
                k--;
            }
            this.size++;
            return;
        }

        int i = this.size - 1;
        while (i >= 0 && ((Comparable) key).compareTo(this.pairs[i].getKey()) < 0)
        {
            this.pairs[i + 1] = this.pairs[i];
            i--;
        }

        this.pairs[i + 1] = new Pair((Comparable)key, value);
        this.size++;
    }

	public Object remove(Object key)
    {
        int pos = this.binSearch(key);

        if (pos >= 0)
        {
            Object removedValue = this.pairs[pos].getValue();
            for (int i = pos; i < this.size; i++)
            {
                this.pairs[i] = this.pairs[i+1];
            }

            this.size--;
            return removedValue;
        }

        return null;
    }

	public Object find(Object key)
    {
        int pos = binSearch(key);

        if (pos >= 0)
            return this.pairs[pos].getValue();

        return null;
    }

	public Object[] findAll(Object key)
    {
        if (!(key instanceof Comparable));
        int pos = binSearch(key);

        Object[] foundValues = new Object[this.size];

        if (pos < 0)
            return foundValues;
        
        Comparable initKey = this.pairs[pos].getKey();
        int k = 0;

        for (int i = pos - 1; i >= 0; i--)
        {
            if (initKey.compareTo(this.pairs[i].getKey()) == 0)
                foundValues[k++] = this.pairs[i].getValue();
        }

        for (int i = pos; i < this.size; i++)
        {
            if (initKey.compareTo(this.pairs[i].getKey()) == 0)
                foundValues[k++] = this.pairs[i].getValue();
        }

        return foundValues;
    }

	public Object[] keys()
    {
        return this.sortedKeys();
    }

	public Object[] removeAll(Object key)
    {
        return null;
    }

    public Comparable[] sortedKeys()
    {
        Comparable[] keys = new Comparable[this.size];

        for (int i = 0; i < this.size; i++)
        {
            keys[i] = (Comparable)this.pairs[i];
        }

        return keys;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    private Pair[] resize(int newL)
    {
        Pair[] newPairs = new Pair[newL];

        for (int i = 0; i < this.pairs.length; i++)
            newPairs[i] = this.pairs[i];

        return newPairs;
    }

    private int binSearch(Object key)
    {
        if (!(key instanceof Comparable))
            return -1;

        return this.binarySearch(0, this.size - 1, (Comparable)key);
    }

    private int binarySearch(int from, int to, Comparable key)
    {
        if (from > to)
            return -1;

        int mid = (to + from) / 2;
        Comparable midKey = this.pairs[mid].getKey();

        if (midKey.compareTo(key) == 0)
            return mid;
        else if (midKey.compareTo(key) > 0)
            return binarySearch(0, mid - 1, key);
        else
            return binarySearch(mid + 1, to, key);
    }

    private class Pair
    {
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