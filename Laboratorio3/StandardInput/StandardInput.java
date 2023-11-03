import java.util.Scanner;

public class StandardInput{
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci la stringa: ");
        String string = input.nextLine();
        Scanner tokenizer = new Scanner(string);
        System.out.println(tokenizer.next() + "\n" + tokenizer.next() + "\n" + tokenizer.next());
    }
}