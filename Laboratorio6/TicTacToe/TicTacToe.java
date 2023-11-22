import java.util.Scanner;

public class TicTacToe{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int TABLE_DIM = 3;
        String[][] table = new String[TABLE_DIM][TABLE_DIM];
        int coorR = 0, nTurn = 0, coorC = 0;
        String winner = "";
        boolean turno = true, filled = false;

        System.out.println(printTable(table, TABLE_DIM));

        while(winner.equals(""))
        {
            do 
            {
                do 
                {
                    System.out.print("Inserisci la riga in cui vuoi inserire il contrassegno (0, 1, 2): ");
                    coorR = input.nextInt();
                } while(coorR < 0 || coorR > 2);

                do 
                {
                    System.out.print("Inserisci la colonna in cui vuoi inserire il contrassegno (0, 1, 2): ");
                    coorC = input.nextInt();
                } while(coorC < 0 || coorC > 2);

                if (table[coorR][coorC] != null)
                {
                    System.out.println("Casella già occupata, reinserisci le coordinate");
                    filled = true;
                }
                else
                    filled = false;

            } while(filled);

            if (turno)
            {
                table[coorR][coorC] = "X";
                turno = false;
            }
            else
            {
                table[coorR][coorC] = "O";
                turno = true;
            }
            
            nTurn++;
            if (nTurn >= 5)
                winner = checkWinner(table, TABLE_DIM);

            System.out.println(printTable(table, TABLE_DIM));
        }

        System.out.println("Il vincitore è: " + winner);
    }

    private static String printTable(String[][] table, int length)
    {
        String tableStr = "";
        for (int i = 0; i < length; i++)
        {
            tableStr += "| ";
            for (int j = 0; j < length; j++)
            {
                if (table[i][j] == null)
                    tableStr += ".";
                else
                    tableStr += (table[i][j]);
            }
            tableStr += " |\n";
        }

        return tableStr;
    }

    private static String checkWinner(String[][] table, int length)
    {
        int col = 0;

        if ((table[0][0] != null && table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[0][2] != null && table[0][2] == table[1][1] && table[1][1] == table[2][0]))
        {
            return table[1][1];
        }
        

        for (int i = 0; i < length; i++)
        {
            if (table[i][0] != null && table[i][0] == table[i][1] && table[i][1] == table[i][2])
                return table[i][0];


            if (table[col][i] != null && table[col][i] == table[col+1][i] && table[col+1][i] == table[col+2][i])
                return table[i][0];
        }
        return "";
    }
}