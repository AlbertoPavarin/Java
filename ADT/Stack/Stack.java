public interface Stack extends Container{
    void push(Object obj); // Inserisce un elemento all'inizio dello stack
    Object pop(); // Rimuove il primo elemento all'inizio dello stack, e lo ritorna
    Object top(); // Accese alla prima posizione dello stack
}