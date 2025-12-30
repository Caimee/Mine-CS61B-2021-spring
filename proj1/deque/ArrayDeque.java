package deque;

public class ArrayDeque<T> implements Deque<T>{
    private T [] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    public int update_front(int x){
        return (x - 1 + items.length) % items.length;
    }

    public int update_back(int x){
        return  (x + 1) % items.length;
    }
@Override
    public void addLast(T a){
        if (items.length == size){
            resize(size*2);
        }
        items[nextLast] = a;
        nextLast = update_back(nextLast);
        size++;

    }
@Override
    public void addFirst(T a){
        if (items.length == size){
            resize(items.length*2);
        }
        items[nextFirst] = a;
        nextFirst = update_front(nextFirst);
        size++;
    }
    public void resize(int x){
        T[] a = (T[]) new Object[x];
       int start = update_back(nextFirst);
       for (int i = 0;i < size; i++){
           a[i] = items[(start + i)% items.length];
       }
        items = a;
       nextFirst = x - 1;
       nextLast = size;
    }
    @Override
    public T removeLast(){
        if (isEmpty()) return null;
        int index = update_front(nextLast);
        nextLast = index;
         T result = items[index];
        items[index] = null;
        size--;
        if (items.length >= 16 && size < items.length / 4){
            resize(items.length / 2);
        }
        return result;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }
@Override
    public  T removeFirst(){
        if (isEmpty()) return null;
        int index = update_back(nextFirst);
        nextFirst = index;
        T result = items[index];
        items[index] = null;
        size--;
        if (items.length >= 16 && size < items.length / 4){
            resize(items.length / 2);
        }
        return result;
    }
@Override
    public T get(int i){
        int start = update_back(nextFirst);
        int index = (start + i) % items.length;
        return items[index];
    }
@Override
    public int size(){
        return this.size;
    }




}


