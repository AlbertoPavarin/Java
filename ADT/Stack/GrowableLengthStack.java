public class GrowableLengthStack extends FixedLengthStack{
    
    public void push(Object obj)
    {
        if (this.vSize == this.v.length)
            this.v = resize(v, this.vSize * 2, this.vSize);
        super.push(obj);
    }

    private Object[] resize(Object[] a, int newSize, int oldSize)
    {
        Object[] v = new Object[newSize];
        System.arraycopy(a, 0, v, 0, oldSize);
        return v;
    }
}