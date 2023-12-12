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
}