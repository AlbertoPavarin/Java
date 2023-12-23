public class StackTester{
    public static void main(String[] args)
    {
        FixedLengthStack stack = new FixedLengthStack();
        while(true)
        {
            try
            {
                stack.push("a");
            }
            catch (FullStackException e)
            {
                System.out.println("La coda è ora piena");
                break;
            }
        }

        System.out.println();

        while(true)
        {
            try
            {
                System.out.println(stack.pop());
            }
            catch (EmptyStackException e)
            {
                System.out.println("La coda è ora vuota");
                break;
            }
        }
    }
}