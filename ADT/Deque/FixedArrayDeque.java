public class FixedArrayDeque implements Deque{
    protected int f;
    protected int l;
    protected int size;
    protected Object[] v;
    final protected static int CAPACITY = 5;

    public FixedArrayDeque()
    {
        this.v = new Object[CAPACITY];
        this.f = 0;
        this.l = CAPACITY - 1;
        this.makeEmpty();
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void addFirst(Object obj)
    {
        if (this.size == this.v.length)
            throw new FullDequeException();
        this.v[this.f++] = obj;
        this.size++;
    }

    public void addLast(Object obj)
    {
        if (this.size == this.v.length)
            throw new FullDequeException();
        this.v[this.l--] = obj;
        this.size++;
    }

    public Object removeFirst()
    {
        if (this.isEmpty())
            throw new EmptyDequeException();

        Object tmp = this.getFirst();
        for (int i = 1; i < this.size; i++)
        {
            this.v[i - 1] = this.v[i];
        }
        this.v[this.f] = null;
        this.size--;
        this.f--;
        return tmp;
    }   

    public Object removeLast()
    {
        if (this.isEmpty())
            throw new EmptyDequeException();

        this.size--;
        Object tmp = this.v[this.l + ((this.CAPACITY-1)%this.l)];
        if (tmp == null)
        {   
            tmp = this.v[0];
            this.f--;
            this.v[0] = null;
            return tmp;
        }
        this.v[this.l + ((this.CAPACITY-1)%this.l)] = null;
        this.l = this.l + ((this.CAPACITY-1)%this.l);
        return tmp;
    }

    public Object getFirst()
    {
        if (this.isEmpty())
            return null;
        return this.v[this.f - ((this.CAPACITY-2)%this.f)];
    }

    public Object getLast()
    {
        if (this.isEmpty())
            return null;

        Object tmp = this.v[this.l + ((this.CAPACITY-1)%this.l)];
        if (tmp == null)
            return this.v[0];
        
        return tmp;
    } 

    public String toString()
    {
        String q = "[";
        for (int i = 0; i < this.CAPACITY; i++)
            q += " " + this.v[i];

        q += " ]";
        return q;
    }
}