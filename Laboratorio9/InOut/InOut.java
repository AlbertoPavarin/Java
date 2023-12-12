import java.util.*;
import java.io.*;

public class InOut
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: InOut inputFile outputFile");
            System.exit(-1);
        }

        int cntLine = 0;

        try (FileReader r = new FileReader(args[0]); Scanner scan = new Scanner(r))
        {
            String out = "";
            while(scan.hasNextLine()){
                try (Scanner lineScan = new Scanner(scan.nextLine()))
                {
                    if (cntLine != 0)
                            out += "\n";
                    while (lineScan.hasNext())
                    {
                        out += inverti(lineScan.next()) + " ";
                    }
                    cntLine++;
                }
                catch(NoSuchElementException e)
                {
                    System.out.println("Errore in lettura delle parole");
                }
            }
            System.out.println(out);
            try(PrintWriter w = new PrintWriter(args[1]))
            {
                w.print(out);
            }
            catch(Exception e)
            {
                System.out.println("Errore nell'apertura di " + args[1]);
            }
        } 
        catch(Exception e)
        {
            System.out.println("Il file " + args[0] + " non esiste");
        }
    }

    public static String inverti(String str)
    {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--)
        {
            reversed += str.charAt(i);
        }

        return reversed;
    }
}