public class QueueTester {
    public static void main(String[] args)
    {
        // FixedLengthQueue q = new FixedLengthQueue();
        // int cnt = 1;
        // while(true)
        // {
        //     try
        //     {
        //         q.enqueue(cnt++);
        //     }
        //     catch (FullQueueException e )
        //     {
        //         System.out.println("La coda è ora piena");
        //         break;
        //     }
        // }

        // while(!q.isEmpty())
        // {
        //     System.out.println(q.dequeue());
        // }

        // System.out.println("La coda è ora vuota\n");

        // q.enqueue("a");
        // q.enqueue("b");
        // q.enqueue("c");
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
        // q.enqueue("d");
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());

        // GrowableLengthQueue q = new GrowableLengthQueue();

        // for (int i = 0; i < 8; i++)
        // {
        //     q.enqueue(i+1);
        // }

        // System.out.println("Elementi aggiunti alla coda\nRisultati della dequeue:");

        // while(!q.isEmpty())
        //     System.out.println(q.dequeue());

        CircularArrayQueue q = new CircularArrayQueue();

        for (int i = 0; i < 5; i++)
        {
            q.enqueue(i+1);
        }

        System.out.println("Elementi aggiunti alla coda\nRisultati della dequeue:");

        while(!q.isEmpty())
            System.out.println(q.dequeue());
    }
}