import java.util.Scanner;

public class SumArrayElement{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Quanti elementi?");
        int length;
        length = input.nextInt();

        double[] arr1 = new double[length], arr2 = new double[length];
        double sum = 0;


        System.out.println("Inserisci gli elementi del primo array, uno per riga:");
        for (int i = 0; i < length; i++)
        {
            arr1[i] = input.nextDouble();
        }

        System.out.println("Inserisci gli elementi del secondo array, uno per riga:");
        for (int i = 0; i < length; i++)
        {
            arr2[i] = input.nextDouble();
        }
        
        input.close();

        System.out.println();

        for (int i = 0; i < length; i++)
        {
            System.out.print((arr1[i] + arr2[i]) + " ");
            sum += arr1[i] + arr2[i];
        }    

        System.out.println("\n" + sum);    
    }
}