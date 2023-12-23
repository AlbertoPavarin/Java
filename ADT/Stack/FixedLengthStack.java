public class FixedLengthStack implements Stack{
    private int vSize;
    private Object[] v;

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
        if (v.length == vSize)
            throw new FullStackException();
        v[vSize++] = obj;
    }

    public Object pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        Object tmp = v[vSize - 1];
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