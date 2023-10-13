// importazioni
import java.util.Scanner;

// intestazione classe
public class ControlloTriangoloRettangolo {

    // intestazione metodo principale
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double a, b, c = 0;
        System.out.print("Inserisci a: ");
        a = input.nextDouble();
        if (a <= 0)
        {  
            System.out.println("a deve essere positivo");
            System.exit(0);
        }
        System.out.print("Inserisci b: ");
        b = input.nextDouble();
        if (b <= 0)
        {  
            System.out.println("b deve essere positivo");
            System.exit(0);
        }
        System.out.print("Inserisci c: ");
        c = input.nextDouble();
        if (c <= 0)
        {  
            System.out.println("c deve essere positivo");
            System.exit(0);
        }

        if ((a*a == b*b + c*c) 
            || (b*b == a*a + c*c) 
            || (c*c == b*b + a*a))
        {
            System.out.println("Il triangolo è rettangolo");
        }
        else
        {
            System.out.println("Il triangolo non è rettangolo");
        }
    }
    
}