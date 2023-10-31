import java.util.Scanner;

public class StandardInput{
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci la stringa: ");
        String string = input.nextLine();
        String[] tokens = string.split(" ");
        System.out.println(tokens[0] + "\n" + tokens[1] + "\n" + tokens[2]);
    }
}