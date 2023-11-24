public class FactorGenerator
{
    private int numero;
    // costruttore
    public FactorGenerator(int valore)
    {
        if (valore <= 1)
         throw new IllegalArgumentException();

        this.numero = valore;
    }

    // metodo nextFactor
    public int nextFactor()
    {
        for (int i = 2; i <= this.numero; i++)
        {
            if (this.numero % i == 0)
            {
                numero /= i;
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    // metodo hasMoreFactors
    public boolean hasMoreFactors()
    {
        return (this.numero != 1);
    }
}