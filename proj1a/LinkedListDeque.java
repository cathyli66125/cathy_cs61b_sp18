public class LinkedListDeque <T>{
    public class ItemNode <T> {
        public T item;
        public ItemNode next;
        public ItemNode previous;
        public ItemNode(T i, ItemNode n, ItemNode p) {
            item = i;
            next = n;
            previous = p;
        }
    }


    public int size = 0;
    public ItemNode sentinel;

    public LinkedListDeque(){
        sentinel = new ItemNode(0, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(T x) {
        sentinel.previous = new ItemNode(x, sentinel, null);
        sentinel.next = sentinel.previous;
    }

    public void addFirst(T x){
        ItemNode currentFirst = sentinel.next;
        ItemNode newNode = new ItemNode(x, currentFirst, sentinel);
        sentinel.next = newNode;
        currentFirst.previous = newNode;
        size ++;
    }

    public void addLast(T x){
        sentinel.previous = new ItemNode(x, sentinel, sentinel.previous);
        sentinel.previous.previous.next = sentinel.previous;
        size ++;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }


    public int size(){
        return size;
    }

    public void printDeque(){
        ItemNode i = sentinel.next;
        while (i != sentinel) {
            System.out.println(i.item);
            i = i.next;
        }
    }

    public void removeFirst(){
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size --;
    }
    public void removeLast(){
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size --;
    }
}
