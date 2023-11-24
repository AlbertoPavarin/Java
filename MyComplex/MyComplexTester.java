import java.util.*;

public class MyComplexTester
{
    public static void main(String []args)
    {   
        Scanner console = new Scanner(System.in);

        System.out.println("Inserire la parte reale e la parte immaginaria del primo numero");
        double re1 = console.nextDouble();
        double im1 = console.nextDouble();

        System.out.println("Inserire la parte reale e la parte immaginaria del secondo numero");
        double re2 = console.nextDouble();
        double im2 = console.nextDouble();

        MyComplex c1 = new MyComplex(re1,im1);
        MyComplex c2 = new MyComplex(re2,im2);

        System.out.println("Il primo numero complesso e’: "+c1.toString());
        System.out.println("Il secondo numero complesso e’: "+c2.toString());

        MyComplex r1 = c1.add(c2);
        MyComplex r2 = MyComplex.add(c1,c2);

        System.out.println("Somma con metodo d’esemplare: "+r1.toString());
        System.out.println("Somma con metodo statico: "+r2.toString());

        r1 = c1.sub(c2);
        r2 = MyComplex.sub(c1,c2);

        System.out.println("Sottrazione con metodo d’esemplare: "+r1.toString());
        System.out.println("Sottrazione con metodo statico: "+r2.toString());

        r1 = c1.mult(c2);

        System.out.println("Prodotto con metodo d’esemplare: "+r1.toString());
        System.out.println("Ptodotto con metodo statico: "+r2.toString());

        r1 = c1.div(c2);

        System.out.println("Quoziente con metodo d’esemplare: "+r1.toString());
        System.out.println("Quoziente con metodo statico: "+r2.toString());

        System.out.println("L’inverso di "+c1.toString()+" e’ "
        +(c1.inv()).toString());

        System.out.println("Il modulo di "+c2.toString()+" e’ "
        +(c2.inv()).toString());

        System.out.println("Il modulo di "+c1.toString()+" e’ "+c1.mod());
        System.out.println("Il modulo di "+c2.toString()+" e’ "+c2.mod());
        
        System.out.println(c1.toString()+": re="+c1.re()+" img="+c1.im());
        System.out.println(c2.toString()+": re="+c2.re()+" img="+c2.im());
    }
}