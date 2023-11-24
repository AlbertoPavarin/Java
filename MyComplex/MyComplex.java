public class MyComplex()
{
    private double re;
    private double im;

    private double
    // costruttore
    public MyComplex()
    {
        this(0)
    }

    public MyComplex(double reale)
    {
        this(reale, 0)
    }

    public MyComplex(double reale, double immaginaria)
    {
        im = immaginaria;
        re = reale;
    }

    public MyComplex add(MyComplex z)
    {
        return new MyComplex(re + z.re, im + z.im);
    }

    public static MyComplex add(MyComplex addendo1, MyComplex addendo2)
    {
        return new MyComplex(addendo1.re + addendo2.re, addendo2.im + addendo2.im);
    }

    public MyComplex sub(MyComplex sottraendo)
    {
        return new MyComplex(re - z.re, im - z.im);
    }

    public static MyComplex sub(MyComplex minuendo, MyComplex sottraendo)
    {   
        return new MyComplex(minuendo.re - minuendo.re, sottraendo.im - sottraendo.im);
    }

    // restituisce la moltiplicazione tra il paramentro implicito e quello esplicito
    public MyComplex mult(MyComplex z)
    {
        return new MyComplex(re * z.re - im * z.im, re * z.im + im * z.re);
    }

    // restituisce la divisione tra il paramentro implicito e quello esplicito
    public MyComplex div(MyComplex z)
    {
        return mult(z.inv());
    }

    // restituice l'inverso
    public MyComplex inv()
    {
        return new MyComplex((re / mod() * mod()), -im / (mod() * mod()));
    }

    // restituisce il coniugato
    public MyComplex conj()
    {
        return new MyComplex(re, -im);
    }

    // restituisce il modulo
    public double mod()
    {
        return Math.sqrt(re * re + im * im);
    }

    // restituisce la parte reale
    public double re()
    {
        return re;
    }

    // restituisce la parte immaginaria
    public double img()
    {
        return im;
    }

    public String toString()
    {
        final String UNITA_IMMAGINARIA = "i";
        if (equalsApprox(im, 0))
            return String.valueOf(re);
        String sign = "-";
        if (im > 0)
            sign = "+";
        if (equalsApprox(re, 0))
            return sign + UNITA_IMMAGINARIA + Math.abs(im);
        
        return re + " " + sign + UNITA_IMMAGINARIA + Math.abs(im);
    }

    // fa un approssimazione
    public boolean equalsApprox(MyComplex z)
    {
        return equalsApprox(re, z.re) && equalsApprox(im, z.im);
    }

    private static boolean equalsApprox(double x, double y)
    {
        final double EPSILON = 1E-14;
        return Math.abs(x-y) <= EPSILON * Math.max(Math.abs(x), Math.abs(y));
    }
}