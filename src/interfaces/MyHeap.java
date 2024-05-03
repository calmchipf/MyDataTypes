package interfaces;

public interface MyHeap<T> {

    boolean empty();
    int size();
    T getRoot();
    T extractRoot();
    void insert(T item);
}
