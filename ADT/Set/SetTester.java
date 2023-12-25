public class SetTester{
    public static void main(String[] args)
    {
        Set set = new ArraySet();

        for (int i = 0; i < 10; i++)
        {
            set.add(i+1);
        }

        Set set2 = new ArraySet();

        for (int i = 1; i <= 10; i += 2)
        {
            set2.add(i);
        }

        Set unionSet = ArraySet.subtract(set, set2);

        Object[] v = unionSet.toArray();
        for (int i = 0; i < v.length; i++)
        {
            System.out.println(v[i]);
        }
    }
}