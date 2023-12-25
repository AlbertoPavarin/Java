public class ArraySet implements Set{
    private Object[] v;
    private int size;

    public ArraySet()
    {
        this.v = new Object[5];
        makeEmpty();
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add(Object obj)
    {
        if (contains(obj))
            return;

        if (this.size == this.v.length)
            this.v = resize(this.v, this.size * 2, this.size);

        this.v[size++] = obj;
    }

    public boolean contains(Object x)
    {
        for (int i = 0; i < this.size; i++)
        {
            if (this.v[i].equals(x))
                return true;
        }

        return false;
    }

    public Object[] toArray()
    {
        Object[] x = new Object[this.size];
        System.arraycopy(this.v, 0, x, 0, size);
        return x;
    }

    private Object[] resize(Object[] a, int newSize, int oldSize)
    {
        Object[] newV = new Object[newSize];
        System.arraycopy(a, 0, newV, 0, oldSize); 
        return newV;
    }

    public static Set union(Set s1, Set s2)
    {
        Set x = new ArraySet();
        Object[] a = s1.toArray();

        for (int i = 0; i < a.length; i++)
            x.add(a[i]);

        a = s2.toArray();

        for (int i = 0; i < a.length; i++)
            x.add(a[i]);

        return x;
    }

    public static Set intersection(Set set1, Set set2)
    {
        Object[] a = set2.toArray();
        Set x = new ArraySet(); 

        for (int i = 0; i < a.length; i++)
        {
            if (set1.contains(a[i]))
            {
                x.add(a[i]);
            }
        }

        return x;
    }

    public static Set subtract(Set set1, Set set2)
    {
        Object[] a = set1.toArray();
        Set x = new ArraySet(); 

        for (int i = 0; i < a.length; i++)
        {
            if (!set2.contains(a[i]))
            {
                x.add(a[i]);
            }
        }

        return x;
    }
}