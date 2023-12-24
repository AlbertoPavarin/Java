public class FixedLengthQueue implements Queue{
    int vSize;
    Object[] v;

    public FixedLengthQueue()
    {
        this.v = new Object[5];
        this.makeEmpty();
    }

    public void makeEmpty()
    {
        vSize = 0;
    }

    public boolean isEmpty()
    {
        return vSize == 0;
    }

    public void enqueue(Object obj)
    {
        if (this.vSize == this.v.length)
            throw new FullQueueException();
        this.v[this.vSize++] = obj;
    }

    public Object dequeue()
    {
        if (this.isEmpty())
            throw new EmptyQueueException();

        Object tmp = this.getFront();
        for (int i = 1; i < vSize; i++)
        {
            this.v[i - 1] = this.v[i];
        }
        this.v[vSize] = null;
        this.vSize--;
        return tmp;
    }

    public Object getFront()
    {
        if (this.isEmpty())
            throw new EmptyQueueException();
        return this.v[0];
    }
}