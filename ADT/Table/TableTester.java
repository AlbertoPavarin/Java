public class TableTester{
    public static void main(String[] args)
    {
        ArrayTable t = new ArrayTable();

        t.insert("ciao", 0);
        t.insert("a", 1);
        t.insert("tutti!", 2);

        for (int i = 0; i < 3; i++)
        {
            System.out.print("" + t.find(i) + " ");
        }
        System.out.println();
    }
}