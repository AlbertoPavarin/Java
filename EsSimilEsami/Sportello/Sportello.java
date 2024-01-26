import java.math.*;

public class Sportello extends FixedCircularArrayQueue{
    /* Metodo che restituisce il numero di elementi presenti nella coda.
    NB: potete elaborare questa informazione dalle variabili d’istanza della coda, 
    oppure potete aggiungere una variabile d’istanza nella classe Sportello che tenga 
    conto della numerosità (in questo caso ricordarsi di sovrascrivere, ove necessario, costruttori e/o metodi in modo che il suo valore sia sempre aggiornato). Entrambe le scelte progettuali vanno bene e verranno valutate allo stesso modo.*/
    public int getSize()
    {
        return this.size;
    }

    /* Il metodo dequeue decrementa il valore in testa alla coda di una unità. Se il valore ottenuto è 0, allora lo elimina effettivamente dalla coda. Altrimenti lo lascia nella sua posizione, decrementato. Ad esempio, se nella coda ci sono gli elementi 3 1 6, dopo l’invocazione di dequeue il contenuto sarà 2 1 6. Se nella coda ci sono gli elementi 1 3 6, dopo l’invocazione di dequeue il contenuto sarà 3 6.*/
    public Object dequeue()
    {
        if (this.getSize() == 0)
            return null;

        int result = (int)this.v[this.front] - 1;
        this.v[this.front] = result;
        if (result == 0)
            return super.dequeue();

        return result;
    }

    /* Restituisce una stringa che riporta il numero di elementi nella coda, seguiti dalla dicitura “ clienti: ” seguita dal contenuto della coda (si veda il metodo toString della superclasse). Ad esempio, se la coda contiene gli elementi 3 1 6 la stringa restituita sarà: “3 clienti: 3 1 6”*/
    public String toString()
    {
        return this.getSize() + " clienti: " + super.toString();
    }


    public static int minSizeQueue(Sportello[] p)
    {
        int minSizeIndex = 0;
        for (int i = 1; i < p.length; i++)
        {
            if (p[i].getSize() < p[minSizeIndex].getSize())
                minSizeIndex = i;
        }

        return minSizeIndex;
    }
}