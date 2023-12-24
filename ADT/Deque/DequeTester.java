public class DequeTester {
    public static void main(String[] args)
    {
        FixedArrayDeque q = new FixedArrayDeque();
        q.addLast(5);
        q.addFirst(3);
        q.addFirst(7);
        System.out.println("Richiamo a getFirst(): " + q.getFirst());
        System.out.println("Richiamo a removeLast(): " + q.removeLast());
        System.out.println("Richiamo a removeLast(): " + q.removeLast());
        System.out.println("Richiamo a removeFirst(): " + q.removeFirst());
        q.addFirst(6);
        System.out.println("Richiamo a getLast(): " + q.getLast());
        q.addFirst(8);
        System.out.println("Richiamo a getLast(): " + q.getLast());
    }
}