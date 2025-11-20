package deque;

import org.w3c.dom.Node;

public class LinkedListDeque<Item> {


    private class intnode{
            public Item item;
            public intnode leftnode;
            public intnode rightnode;
            public intnode(Item i, intnode l,intnode r){
                this.item = i;
                this.leftnode = l;
                this.rightnode = r;
            }
        }

        intnode frontsen;
        intnode backsen;
        int size;

        public LinkedListDeque(){
           frontsen = new intnode(null,null,null);
           backsen = new intnode(null,null,null);
           frontsen.rightnode = backsen;
           backsen.leftnode = frontsen;

           size = 0;
        }

        public void addLast(Item item){
            intnode addnode = new intnode(item, backsen.leftnode,backsen);
            backsen.leftnode.rightnode = addnode;
            backsen.leftnode = addnode;
                    size++;
        }

        public void addFirst(Item item){
            intnode addnode = new intnode(item, frontsen,frontsen.rightnode);
            frontsen.rightnode.leftnode = addnode;
            frontsen.rightnode = addnode;
            size++;
        }

        public Item getlast(){
            if (isEmpty()) {
                return null;  // 或者抛出异常
            }
            return backsen.leftnode.item;

        }
        public Item getfirst(){
            if (isEmpty()) {
                return null;  // 或者抛出异常
            }
            return frontsen.rightnode.item;
        }

        public boolean isEmpty(){
            if (frontsen.rightnode == backsen){
                return true;
            }
            return false;
        }

        public int size(){
                return  size;
        }


        public Item removeLast(){
            if (isEmpty()) {
                return null;
            }
            Item result = this.getlast();
            backsen.leftnode.leftnode.rightnode = backsen;
            backsen.leftnode = backsen.leftnode.leftnode;
            size--;
            return  result;
        }



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

    public Item removeFirst(){
        if (isEmpty()) {
            return null;  // 或者抛出异常
        }
        Item result = this.getfirst();
        frontsen.rightnode.rightnode.leftnode = frontsen;
        frontsen.rightnode = frontsen.rightnode.rightnode;
        size--;
        return  result;
    }



}
