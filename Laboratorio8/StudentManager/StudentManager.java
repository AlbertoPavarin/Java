import java.util.*;
import java.io.*;

public class StudentManager{
    public static void main(String[] args)
    {
        Student[] students = new Student[10];
        int pos = 0;
        boolean done = false;
        Scanner console = new Scanner(System.in); 

        if (args.length != 1)
        {
            System.out.println("Inserisci un nome del file");
            System.exit(-1);
        }

        try(FileReader r = new FileReader(args[0]); Scanner scan = new Scanner(r)){
            while (scan.hasNext())
            {
                try
                {
                    String[] splitted = scan.nextLine().split(" ");
                    double votoScritto = Double.parseDouble(splitted[1]);
                    if (votoScritto > 30 || votoScritto < 0)
                        throw new IllegalArgumentException();
                    double votoOrale = Double.parseDouble(splitted[2]);
                    if (votoOrale > 30 || votoOrale < 0)
                        throw new IllegalArgumentException();
                    Student student = new Student(splitted[0], votoScritto, votoOrale);
                    if (pos == students.length)
                        students = ArrayUtil.resize(students, students.length*2);
                    students[pos] = student;
                    pos++;
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Uno dei voti non è valido");
                }

            }
        }
        catch(IOException e){
            System.out.println("Il file non esiste");
        //    gestisco le eccezioni
        }

        while(!done)
        {
            System.out.println("Comando (Q, S)");
            switch (console.next().toUpperCase())
            {
                case "Q":
                    System.out.println("Arrivederci");
                    done = true;
                    break;
                case "S":
                    System.out.print("Inserisci il nome di uno studente: ");
                    String nome = console.next();
                    boolean found = false;
                    for (int i = 0; i < pos && !found; i++)
                    {
                        if (nome.equalsIgnoreCase(students[i].getNome()))
                        {
                            System.out.println("Il voto finale di " + nome + " è: " + students[i].media());
                            found = true;
                        }
                    }
                    
                    if (!found)
                        System.out.println(nome + " non è tra la lista");
                    break;
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }

    }
}