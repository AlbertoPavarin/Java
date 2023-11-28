import java.util.Scanner;

public class InterruttoreTester{
    public static void main(String[] args)
    {
        Interruttore int1 = new Interruttore();
        Interruttore int2 = new Interruttore();

        int scelta = Integer.MAX_VALUE;

        Scanner console = new Scanner(System.in);

        do 
        {
            System.out.println("interrrutore 1: " + int1.printStatus());
            System.out.println("interrrutore 2: " + int2.printStatus());
            System.out.println("Lampadina " + Interruttore.printBulbStatus());

            System.out.print("Scegli l'interruttore 1 o 2 (0 per uscire): ");
            scelta = console.nextInt();

            if (scelta == 1)
                int1.changeStatus();
            else if (scelta == 2)
                int2.changeStatus();

        } while (scelta != 0);

        console.close();
    }
}