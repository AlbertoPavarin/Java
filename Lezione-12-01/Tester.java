public class Tester{
    public static void main(String[] args)
    {
        List<String> list = new List<>();
        list.addFirst("4");
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        list.addLast("3");
        list.addLast("2");
        list.addLast("1");

        System.out.println(list);

        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }
}