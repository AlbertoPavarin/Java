import java.util.*;

public class ScansionaStringa{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        String str = "";

        System.out.print("Inserisci una stringa: ");
        str = console.nextLine();

        console.close();

        Scanner tokenizer = new Scanner(str);

        while(tokenizer.hasNext())
            System.out.println(tokenizer.next());

        tokenizer.close();
    }
}