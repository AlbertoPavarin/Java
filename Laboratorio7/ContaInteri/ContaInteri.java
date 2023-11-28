import java.util.*;

public class ContaInteri{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        int cnt = 0;

       for (int i = 0; i < 10; i++)
        {
            System.out.print("Inserisci un numero intero: ");
            try
            {
                console.nextInt();
                cnt++;
            }
            catch (InputMismatchException e)
            {
                console.next();
            }
        }

        console.close();

        System.out.println("Interi inseriti: " + cnt);
    }
}