import java.util.*;

public class Student{
    private String nome;
    private double votoScritto;
    private double votoOrale;

    public Student(String n, double vS,double vO)
    {
        this.nome = n;
        this.votoScritto = vS;
        this.votoOrale = vO;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double media()
    {
        return (this.votoOrale + this.votoScritto) / 2;
    }
}