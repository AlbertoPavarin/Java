public class ContaVocali
{
    public static void main(String[] args)
    {
        String s = "ciao ciao"; 
        System.out.println("Il numero di vocali nella stringa \" " + s + " \" è: " + conta(s));

        s = "Sei matto da legare"; 
        System.out.println("Il numero di vocali nella stringa \" " + s + " \" è: " + conta(s));
    }

    public static int conta(String s)
    {
        s = s.toLowerCase();
        if (s.length() == 0)
            return 0;

        if ((s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u'))
            return 1 + conta(s.substring(1, s.length()));
        
        return conta(s.substring(1, s.length()));
    }
}