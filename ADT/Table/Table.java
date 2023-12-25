interface Container{
    void makeEmpty();
    boolean isEmpty();
}

public interface Table extends Container{
    void insert(Object obj, int key);
    void remove(int key);
    Object find(int key);
}