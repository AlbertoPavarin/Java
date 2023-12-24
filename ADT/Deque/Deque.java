public interface Deque extends Container{
    void addFirst(Object obj); 
    void addLast(Object obj);

    Object removeFirst();
    Object removeLast();

    Object getFirst();
    Object getLast();
}