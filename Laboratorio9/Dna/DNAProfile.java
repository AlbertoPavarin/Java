import java.io.*;
import java.util.*;

public class DNAProfile{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: DnaProfile profiliFile casoFile");
            System.exit(-1);
        }

        String sequenza = "", str = "";
        int[] strCnt = new int[3]; // 0 -> AGAT, 1 -> AATG, 2 ->  TATC
        PersonProfile[] people = new PersonProfile[3];
        int cnt = 0;

        try(FileReader rProfile = new FileReader(args[0]); Scanner scanProfile = new Scanner(rProfile))
        {
            while (scanProfile.hasNextLine())
            {
                if (cnt != 0)
                {
                    try (Scanner lineScan = new Scanner(scanProfile.nextLine()))
                    {
                        int[] data = new int[3];
                        while(lineScan.hasNext())
                        {
                            String name = lineScan.next();
                            data[0] = Integer.parseInt(lineScan.next());
                            data[1] = Integer.parseInt(lineScan.next());
                            data[2] = Integer.parseInt(lineScan.next());
                            people[cnt-1] = new PersonProfile(name, data);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Errore in lettura riga");
                        System.exit(-1);
                    }
                }
                else
                    scanProfile.nextLine();
                cnt++;
            }
        }
        catch (IOException e)
        {
            System.out.println("Il file " + args[0] + " non esiste");
            System.exit(-1);
        }

        try(FileReader rCaso = new FileReader(args[1]); Scanner scanCaso = new Scanner(rCaso))
        {
            sequenza = scanCaso.next();
        }
        catch (Exception e)
        {
            System.out.println("Il file " + args[1] + " non esiste");
            System.exit(-1);
        }

        // System.out.println(sequenza);
        for (int i = 0; i < sequenza.length() - 3; i++)
        {
            str = sequenza.substring(i, i+4);
            if (str.equals("AGAT"))
            {
                strCnt[0]++;
            }
            else if (str.equals("AATG"))
            {
                strCnt[1]++;
            }
            else if (str.equals("TATC"))
            {
                strCnt[2]++;
            }
        }   

        for (int i = 0; i < cnt-1; i++)
            System.out.println(people[i].getName());

        System.out.println("AGAT: " + strCnt[0]);
        System.out.println("AATG: " + strCnt[1]);
        System.out.println("TATC: " + strCnt[2]);
    }
}