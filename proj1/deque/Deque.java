package deque;

public interface Deque<T> {
    void addLast(T item);

    void addFirst(T item);

   default boolean isEmpty(){
       return size() == 0;
    }

    int size();

    T removeLast();

    void printDeque();

    T removeFirst();

    T get(int index);
}
