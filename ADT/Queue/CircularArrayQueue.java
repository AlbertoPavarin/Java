public class CircularArrayQueue implements Queue{
    protected int start;
    protected int size;
    protected Object[] v;

    public CircularArrayQueue()
    {
        this.v = new Object[5];
        this.start = 0;
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

    public void enqueue(Object obj)
    {
        if (this.size == this.v.length)
            throw new FullQueueException();
        this.v[(this.start + this.size) % this.v.length] = obj;
        size++;
    }

    public Object dequeue()
    {
        Object tmp = this.getFront();
        this.v[this.start] = null;
        this.start = (this.start + 1) % this.v.length;
        this.size--;
        return tmp;
    }

    public Object getFront()
    {
        if (isEmpty())
            throw new EmptyQueueException();
        return this.v[this.start];
    }
}