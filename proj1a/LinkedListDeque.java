public class LinkedListDeque<T> {
    private class ItemNode {
        private T item;
        private ItemNode next;
        private ItemNode previous;

        public ItemNode(T i, ItemNode n, ItemNode p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private int size = 0;
    private ItemNode sentinel;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T x) {
        ItemNode currentFirst = sentinel.next;
        ItemNode newNode = new ItemNode(x, currentFirst, sentinel);
        sentinel.next = newNode;
        currentFirst.previous = newNode;
        size++;
    }

    public void addLast(T x) {
        sentinel.previous = new ItemNode(x, sentinel, sentinel.previous);
        sentinel.previous.previous.next = sentinel.previous;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ItemNode i = sentinel.next;
        while (i != sentinel) {
            System.out.println(i.item);
            i = i.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T result = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T result = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size--;
        return result;
    }

    public T get(int index) {
        ItemNode i = sentinel.next;
        while (index != 0) {
            i = i.next;
            index--;
        }
        return i.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(ItemNode i, int index) {
        if (index == 0) {
            return i.item;
        }
        return getRecursiveHelper(i.next, index - 1);
    }
}