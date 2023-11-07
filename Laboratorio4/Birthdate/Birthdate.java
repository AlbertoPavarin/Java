import java.util.Scanner;

public class Birthdate{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String data = "";
        int giorno, mese = 0;

        System.out.print("Inserisci la data di nascita: ");
        data = input.nextLine();

        giorno = Integer.parseInt(data.substring(0,data.indexOf(" ")));
        mese = Integer.parseInt(data.substring(data.indexOf(" ") + 1));

        if (giorno > 31 || giorno < 0 || mese < 0 || mese > 12)
        {
            System.out.println("L'input inserito non è una data");
            System.exit(0);
        }

        // caso ariete
        if (mese == 3 && giorno >= 20)
        {
            System.out.println("Ariete");
            System.exit(0);
        }
        if (mese == 4 && giorno <= 20)
        {
            System.out.println("Ariete");
            System.exit(0);
        }

        // caso toro
        if (mese == 4 && giorno >= 20)
        {
            System.out.println("Toro");
            System.exit(0);
        }
        if (mese == 5 && giorno <= 21)
        {
            System.out.println("Toro");
            System.exit(0);
        }

        // caso gemelli
        if (mese == 5 && giorno >= 22)
        {
            System.out.println("Gemelli");
            System.exit(0);
        }
        if (mese == 6 && giorno <= 20)
        {
            System.out.println("Gemelli");
            System.exit(0);
        }

        // caso cancro
        if (mese == 6 && giorno >= 21)
        {
            System.out.println("Cancro");
            System.exit(0);
        }
        if (mese == 7 && giorno <= 22)
        {
            System.out.println("Cancro");
            System.exit(0);
        }

        // caso Leone
        if (mese == 7 && giorno >= 23)
        {
            System.out.println("Leone");
            System.exit(0);
        }
        if (mese == 8 && giorno <= 22)
        {
            System.out.println("Leone");
            System.exit(0);
        }

        // caso Vergine
        if (mese == 8 && giorno >= 23)
        {
            System.out.println("Vergine");
            System.exit(0);
        }
        if (mese == 9 && giorno <= 22)
        {
            System.out.println("Vergine");
            System.exit(0);
        }

        // caso Bilancia
        if (mese == 9 && giorno >= 23)
        {
            System.out.println("Bilancia");
            System.exit(0);
        }
        if (mese == 10 && giorno <= 22)
        {
            System.out.println("Bilancia");
            System.exit(0);
        }

        // caso Scorpione
        if (mese == 10 && giorno >= 23)
        {
            System.out.println("Scorpione");
            System.exit(0);
        }
        if (mese == 11 && giorno <= 22)
        {
            System.out.println("Scorpione");
            System.exit(0);
        }

        // caso Saggitario
        if (mese == 11 && giorno >= 23)
        {
            System.out.println("Saggitario");
            System.exit(0);
        }
        if (mese == 12 && giorno <= 21)
        {
            System.out.println("Saggitario");
            System.exit(0);
        }

        // caso Capricorno
        if (mese == 12 && giorno >= 22)
        {
            System.out.println("Capricorno");
            System.exit(0);
        }
        if (mese == 1 && giorno <= 20)
        {
            System.out.println("Capricorno");
            System.exit(0);
        }

        // caso Acquario
        if (mese == 1 && giorno >= 22)
        {
            System.out.println("Acquario");
            System.exit(0);
        }
        if (mese == 2 && giorno <= 18)
        {
            System.out.println("Acquario");
            System.exit(0);
        }

        // caso Pesci
        if (mese == 2 && giorno >= 19)
        {
            System.out.println("Pesci");
            System.exit(0);
        }
        if (mese == 3 && giorno <= 20)
        {
            System.out.println("Pesci");
            System.exit(0);
        }

        input.close();
    }
}