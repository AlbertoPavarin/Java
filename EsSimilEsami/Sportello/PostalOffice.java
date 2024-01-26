import java.util.Random;

public class PostalOffice{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Uso: PostalOffice <minuti>");
            System.exit(-1);
        }

        int mins = 0;

        try
        {
            mins = Integer.parseInt(args[0]);
            if (mins <= 0)
            {
                System.out.println("Uso: PostalOffice <minuti>");
                System.exit(-1);
            }    
        }
        catch(NumberFormatException e)
        {
            System.out.println("Uso: PostalOffice <minuti>");
            System.exit(-1);
        } 

        Sportello[] sportelli = {new Sportello(), new Sportello(), new Sportello(), new Sportello(), new Sportello()};
        Random rnd = new Random(123);

        for (int i = 0; i < mins; i++)
        {
            int index = Sportello.minSizeQueue(sportelli);
            int customer = rnd.nextInt(15) + 1;
            sportelli[index].enqueue(customer);
            System.out.println("Nuovo cliente con pratica " + customer + " minuti inserito in coda allo sportello " + (index + 1));
            System.out.println("Situazione code dopo " + (i+1) + " minuti");
            for (int j = 0; j < sportelli.length; j++)
            {
                sportelli[j].dequeue();
                System.out.println("Sportello " + (j+1) + ": " + sportelli[j]);
            }
        }
    }
}