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
        String[] strName = new String[3];
        int[] strCnt = new int[3]; // 0 -> AGAT, 1 -> AATG, 2 ->  TATC
        PersonProfile[] people = new PersonProfile[3];
        int cnt = 0;
        boolean found = false;

        try(FileReader rProfile = new FileReader(args[0]); Scanner scanProfile = new Scanner(rProfile))
        {
            while (scanProfile.hasNextLine())
            {
                try (Scanner lineScan = new Scanner(scanProfile.nextLine()))
                {
                    if (cnt != 0)
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
                    else
                    {
                        int pos = 0;
                        lineScan.next();
                        while(lineScan.hasNext())
                        {
                            strName[pos++] = lineScan.next(); 
                        }
                    }
                    cnt++;
                }
                catch (Exception e)
                {
                    System.out.println("Errore in lettura riga");
                    System.exit(-1);
                }
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

        for (int i = 0; i < 3; i++)
        {
            int currCnt = 0;
            boolean ended = false, started = false;
            for (int j = 0; j < sequenza.length() - 3; j++)
            {
                str = sequenza.substring(j, j+4);
                if (str.equals(strName[i]))
                {
                    if (ended)
                    {
                        ended = false;
                        currCnt = 0;
                    }
                    started = true;
                    currCnt++;
                    j+=3;
                }
                else if (started)
                {
                    ended = true;
                }
                
                if (currCnt >= strCnt[i])
                {
                    strCnt[i] = currCnt;
                }
            }
        }

        System.out.println("AGAT: " + strCnt[0]);
        System.out.println("AATG: " + strCnt[1]);
        System.out.println("TATC: " + strCnt[2]);

        for (int i = 0; i < cnt-1 && !found; i++)
        {
            if (people[i].equals(strCnt))
            {
                found = true;
                System.out.println("Il/La colpevole è: " + people[i].getName());
            }
        }

        if (!found)
        {
            System.out.println("Nessun match");
        }
    }
}