public class ComLine{
    public static void main(String args[])
    {
        if (args.length == 0)
        {
            System.out.println("Non sono stati inseriti parametri");
            System.exit(-1);
        }

        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }
}