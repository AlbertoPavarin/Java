public class QueueTester {
    public static void main(String[] args)
    {
        FixedLengthQueue q = new FixedLengthQueue();
        int cnt = 1;
        while(true)
        {
            try
            {
                q.enqueue(cnt++);
            }
            catch (FullQueueException e )
            {
                System.out.println("La coda è ora piena");
                break;
            }
        }

        while(!q.isEmpty())
        {
            System.out.println(q.dequeue());
        }

        System.out.println("La coda è ora vuota\n");

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("d");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}