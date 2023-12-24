public class GrowableLengthQueue extends FixedLengthQueue{
    
    public void enqueue(Object obj)
    {
        if (this.vSize == this.v.length)
            this.v = resize(this.v, this.vSize, this.vSize * 2);
        super.enqueue(obj);
    }

    private Object[] resize(Object[] a, int oldSize, int newSize)
    {   
        Object[] v = new Object[newSize];
        System.arraycopy(a, 0, v, 0, oldSize);
        return v;
    }
}