import java.util.Scanner;

public class PrintSelectedMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mesi = "1Gennaio 2Febbraio 3Marzo 4Aprile 5Maggio 6Giugno 7Luglio 8Agosto 9Settembre :Ottobre ;Novembre <Dicembre ";

        System.out.print("Inserisci il numero del mese (1-12): ");
        int mesNum = input.nextInt();

        int index = mesi.indexOf(mesNum + 48);
        String tmp = mesi.substring(index + 1);
        index = tmp.indexOf(" ");

        System.out.println(tmp.substring(0, index));
    }
}