public class FixedLengthStack implements Stack{
    protected int vSize;
    protected Object[] v;

    public FixedLengthStack()
    {
        v = new Object[10];
        makeEmpty();
    }
    
    public void makeEmpty()
    {
        vSize = 0;
    }

    public boolean isEmpty()
    {
        return (vSize == 0);
    }

    public void push(Object obj)
    {
        if (this.v.length == this.vSize)
            throw new FullStackException();
        v[vSize++] = obj;
    }

    public Object pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        Object tmp = v[vSize - 1];
        v[vSize - 1] = null;
        vSize--;
        return tmp;
    }

    public Object top()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return v[vSize - 1];
    }
}