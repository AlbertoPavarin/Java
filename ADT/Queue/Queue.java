public interface Queue extends Container{
    void enqueue(Object obj); // aggiunge un elemento all coda
    Object dequeue(); // toglie il primo elemento della coda, e lo ritorna
    Object getFront(); // accede al primo elemento della coda
}