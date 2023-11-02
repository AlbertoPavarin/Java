import java.util.Scanner;

public class StandardInput2{
    public static void main(String[] args)
    {   
        String string, str1, str2, str3;
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci la stringa: ");
        string = input.nextLine();
        Scanner tokenizer = new Scanner(string);
        str1 = tokenizer.next();
        str2 = tokenizer.next();
        str3 = tokenizer.next();
        System.out.println(str3 + "\n" + str2 + "\n" + str1);
    }
}