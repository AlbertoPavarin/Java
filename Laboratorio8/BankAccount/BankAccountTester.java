import java.util.*;

public class BankAccountTester{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount();
        Scanner console = new Scanner(System.in);
        boolean done = false;
        String str = "";

        while(!done)
        {
            System.out.println("Comando? (Q, B, D, W, A)");
            str = console.nextLine();
            Scanner tokenizer = new Scanner(str);
            switch (tokenizer.next().toUpperCase())
            {
                case "Q":
                    System.out.println("Arrivederci"); 
                    done = true;
                    break;
                case "B":
                   System.out.println("Saldo attuale: " + account.getBalance()); 
                   break;
                case "D":
                    try{
                        if (account.deposit(Double.parseDouble(tokenizer.next())))
                            System.out.println("Versamento effettuato: " + account.getBalance());
                        else
                            System.out.println("Versamento non effettuato");
                    }
                    catch (NoSuchElementException | NumberFormatException e)
                    {
                        System.out.println("Inserisci del denaro");
                    }

                    break;
                case "W":
                    try{
                        if (account.withdraw(Double.parseDouble(tokenizer.next())))
                            System.out.println("Prelievo effettuato: " + account.getBalance());
                        else
                            System.out.println("Prelievo non effettuato");
                    }
                    catch (NoSuchElementException | NumberFormatException e)
                    {
                        System.out.println("Inserisci del denaro");
                    }

                    break;
                case "A":
                    break; // non ho la funzione per gli interessi, forse lo farò in futuro
                default:
                    System.out.println("Comando invalido");
            }
        }
    }
}