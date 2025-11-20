package deque;

public class ArrayDeque<Item> {
    private Item [] items;
    private int size;

    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
    }

    public void add(Item a){
        if (items.length == size){
            resize(size*2);
        }
        size++;
        items[size] = a;


    }

    public void resize(int x){
        Item[] a = (Item[]) new Object[x];
        System.arraycopy(items, 0, a, 0, size);
        items = a;

    }
    public Item remove(){
        size--;
        return get(size - 1);
    }
    public Item get(int x){
        return items[x];
    }





}


