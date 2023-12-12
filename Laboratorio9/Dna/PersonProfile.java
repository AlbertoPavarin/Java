public class PersonProfile{
    private String name;
    private int[] str;

    public PersonProfile(String nome, int[] dati)
    {
        this.name = nome;
        this.str = dati;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean equals(int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != this.str[i])
                return false;
        }

        return true;
    }
}