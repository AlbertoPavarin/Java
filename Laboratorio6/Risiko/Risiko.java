import java.util.Scanner;

public class Risiko{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String name = "";

        System.out.print("Inserisci il nome del primo giocatore: ");
        name = input.nextLine();
        Player p1 = new Player(name);

        System.out.print("Inserisci il nome del secondo giocatore: ");
        name = input.nextLine();
        Player p2 = new Player(name);
    
        input.close();

        p1.turno();
        p2.turno();

        System.out.println("\nLanci: ");
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        int[] punteggio1 = p1.sortDice();
        int[] punteggio2 = p2.sortDice();

        System.out.println("\nLanci ordinati: ");
        System.out.print(p1.getName() + ": ");
        for (int i = 0; i < Player.DICES_NUMBER; i++)
            System.out.print(punteggio1[i] + " ");

        System.out.print("\n" + p2.getName() + ": ");
        for (int i = 0; i < Player.DICES_NUMBER; i++)
            System.out.print(punteggio2[i] + " ");
        System.out.println();

        for (int i = 0; i < Player.DICES_NUMBER; i++)
            if (punteggio1[i] > punteggio2[i])
                p1.addPoint();
            else if (punteggio1[i] < punteggio2[i])
                p2.addPoint();

        System.out.println();

        if (p1.getScore() > p2.getScore())
            System.out.println("Vince " + p1.getName() + " " + p1.getScore() + " a " + p2.getScore());
        else
            System.out.println("Vince " + p2.getName() + " " + p2.getScore() + " a " + p1.getScore());
    }
}