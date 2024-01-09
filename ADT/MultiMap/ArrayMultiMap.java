public class ArrayMultiMap implements MultiMap{

    private int size;
    private Pair[] pairs;

    public ArrayMultiMap()
    {
        this.size = 0;
        this.pairs = new Pair[5];
    }

    public void insert(Object key, Object value)
    {
        if (key == null || value == null)
            throw new IllegalArgumentException();

        if (this.size == this.pairs.length)
            this.pairs = resize(this.pairs.length, this.pairs.length * 2);

        this.pairs[this.size++] = new Pair(key, value);
    }

	public Object remove(Object key)
    {
        if (key == null)
            return null;

        for (int i = 0; i < this.size; i++)
        {
            if (this.pairs[i].getKey().equals(key))
            {
                Object removedObject = this.pairs[i];
                this.pairs[i] = this.pairs[this.size - 1]; 
                this.size--;
                return removedObject;  
            }
        }

        return null;
    }

	public Object find(Object key)
    {
        if (key == null)
            return null;

        for (int i = 0; i < this.size; i++)
        {
            if (this.pairs[i].getKey().equals(key))
              return this.pairs[i].getValue();   
        }
        return null;
    }

	public Object[] findAll(Object key)
    {
        Object[] foundPairs = new Object[this.size];
        int k = 0;
        for (int i = 0; i < this.size; i++)
        {
            if (this.pairs[i].getKey().equals(key))
              foundPairs[k++] = this.pairs[i].getValue();  
        }
        return resizeObj(k, foundPairs);
    }

	public Object[] keys()
    {
        Object[] mapKeys = new Object[this.size];
        for (int i = 0; i < this.size; i++)
            mapKeys[i] = this.pairs[i].getKey();

        return mapKeys;
    }

	public Object[] removeAll(Object key)
    {
        Object[] removedPairs = new Object[this.size];
        int k = 0;
        for (int i = 0; i < this.size; i++)
        {
            if (this.pairs[i].getKey().equals(key))
            {
                Object removedObject = this.pairs[i];
                removedPairs[k++] = 0;
                this.pairs[i] = this.pairs[this.size - 1]; 
                this.size--;
                i--;
            }
        }

        return resizeObj(k, removedPairs);
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    private Pair[] resize(int oldL, int newL)
    {
        Pair[] newPairs = new Pair[newL];

        for (int i = 0; i < oldL; i++)
            newPairs[i] = this.pairs[i];

        return newPairs;
    }

    private Object[] resizeObj(int newL, Object[] a)
    {
        Object[] newA = new Object[newL];

        for (int i = 0; i < newL; i++)
            newA[i] = a[i];

        return newA;
    }

    public int size()
    {
        return this.size;
    }

    private class Pair
    {
        private Object value;
        private Object key; 

        public Pair(Object k, Object v)
        {
            this.setKey(k);
            this.setValue(v);
        }

        public void setValue(Object v)
        {
            this.value = v;
        }

        public void setKey(Object k)
        {
            this.key = k;
        }

        public Object getKey()
        {
            return this.key;
        }

        public Object getValue()
        {
            return this.value;
        }
    }
}