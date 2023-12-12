import java.util.*;

public class QuadraticEquation
{
  //... campi di esemplare... da completare
    private double a;
    private double b;
    private double c;
    private double delta;
    
    /*
        Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
        e inizializza i campi di esemplare secondo i valori ricevuti
    */
    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff)
    {
    	this.a = acoeff;
        this.b = bcoeff;
        this.c = ccoeff;
        int chk = checkCoeff();
        if (chk == 0)
        {
            throw new IllegalArgumentException("0");
        }
        else if (chk == 2)
        {
            throw new IllegalArgumentException("2");
        }
    }

    /*
        Restituisce la prima delle due soluzioni dell'equazione quadratica,
        usando la ben nota formula...
    */
    public double getSolution1()
    {
    	return (-b + Math.sqrt(this.delta))/(2*a);
    }

    /*
        Restituisce la seconda delle due soluzioni dell'equazione quadratica,
        usando la ben nota formula...
    */
    public double getSolution2()
    {
    	return (-b - Math.sqrt(this.delta))/(2*a);
    }

    /*
        Restituisce il valore false se l'equazione non ha soluzioni
        (ovvero se il discriminante e` negativo)
    */
    public boolean hasSolutions()
    {
    	this.delta = b*b - 4*a*c;
        if (delta >= 0)
            return true;
        else
            return false;
    }

    /*
        Restituisce 0 se l'equazione non ha soluzioni
        Restituisce 1 se l'equazione ha 1 soluzione
        Restituisce 2 se l'equazione ha infinite soluzione
        Restituisce 3 altrimenti
    */
    private int checkCoeff() 
    {
        if (this.a == 0 && this.b == 0 && this.c != 0)
            return 0;
        if (this.a == 0 && this.b != 0)
            return 1;
        if (this.a == 0 && this.b == 0 && this.c == 0)
            return 2;

        return 3;
    }
}