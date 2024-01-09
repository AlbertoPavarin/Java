public class SecureStack extends GrowableLengthStack
{
    public void push(Object obj)
    {
        if (!(obj instanceof String))
            throw new IllegalArgumentException();

        super.push(obj);
    }
}