import java.util.Scanner;

public class Concatenazione{
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        double num1 = input.nextDouble();
        System.out.print("Inserisci il secondo numero: ");
        double num2  = input.nextDouble();
        System.out.print("Inserisci il terzo numero: ");
        double num3  = input.nextDouble();

        System.out.println(num1 + " " + num2 + " " + num3 + " = " + (num1+num2+num3));
    }
}