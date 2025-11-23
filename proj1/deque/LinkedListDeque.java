package deque;

public class LinkedListDeque<T> implements Deque<T> {


    private class intnode {
        public T item;
        public intnode leftnode;
        public intnode rightnode;

        public intnode(T i, intnode l, intnode r) {
            this.item = i;
            this.leftnode = l;
            this.rightnode = r;
        }
    }

    intnode frontsen;
    intnode backsen;
    int size;

    public LinkedListDeque() {
        frontsen = new intnode(null, null, null);
        backsen = new intnode(null, null, null);
        frontsen.rightnode = backsen;
        backsen.leftnode = frontsen;

        size = 0;
    }

    @Override
    public void addLast(T item) {
        intnode addnode = new intnode(item, backsen.leftnode, backsen);
        backsen.leftnode.rightnode = addnode;
        backsen.leftnode = addnode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        intnode addnode = new intnode(item, frontsen, frontsen.rightnode);
        frontsen.rightnode.leftnode = addnode;
        frontsen.rightnode = addnode;
        size++;
    }

    public T getlast() {
        if (isEmpty()) {
            return null;  // 或者抛出异常
        }
        return backsen.leftnode.item;

    }

    public T getfirst() {
        if (isEmpty()) {
            return null;  // 或者抛出异常
        }
        return frontsen.rightnode.item;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        intnode toRemove = backsen.leftnode;
        T result = toRemove.item;
        backsen.leftnode = toRemove.leftnode;
        backsen.leftnode.rightnode = backsen;
        toRemove.leftnode = null;
        toRemove.rightnode = null;
        toRemove.item = null;
        size--;
        return result;
    }


    @Override
    public void printDeque() {
        intnode current = frontsen.rightnode;
        while (current != backsen) {
            System.out.print(current.item);
            if (current.rightnode != backsen) {
                System.out.print(" ");
            }
            current = current.rightnode;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;  // 或者抛出异常
        }
        intnode toRemove = frontsen.rightnode;
        T result = toRemove.item;
        frontsen.rightnode = toRemove.rightnode;
        frontsen.rightnode.leftnode = frontsen;
        toRemove.leftnode = null;
        toRemove.rightnode = null;
        toRemove.item = null;
        size--;
        return result;
    }

    @Override
    public T get(int index) {
        intnode movingindex = frontsen.rightnode;
        for (int count = 0; count < index; count++) {
            movingindex = movingindex.rightnode;
        }
        return movingindex.item;

    }


}
