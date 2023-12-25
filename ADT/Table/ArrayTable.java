public class ArrayTable implements Table{
    private Object[] v;
    private int size;

    public ArrayTable()
    {
        this.v = new Object[10];
    }

    public void makeEmpty()
    {
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void insert(Object obj, int key)
    {
        if (key >= this.v.length || key < 0)
            throw new InvalidPositionTableException();

        if (this.v[key] == null)
            this.size++;

        this.v[key] = obj;
    }

    public void remove(int key)
    {
        if (key >= this.v.length || key < 0 || this.isEmpty())
            throw new InvalidPositionTableException();

        if (this.v[key] != null)
        {
            this.v[key] = null;
            this.size--;
        }
    }   

    public Object find(int key)
    {
        if (key >= this.v.length || key < 0 || this.isEmpty())
            throw new InvalidPositionTableException();

        return this.v[key];
    }

    class InvalidPositionTableException extends RuntimeException{}
}