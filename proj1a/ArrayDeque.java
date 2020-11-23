public class ArrayDeque<T> {
    public T[] items;
    private int firstIndex;
    private int lastIndex;
    private int size;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        firstIndex = 1;
        lastIndex = 0;
        size = 0;
    }
    public void addFirst(T x) {
        if (size == items.length) {
            resizeUp(size * 2);
        }
        firstIndex = (firstIndex - 1 + items.length) % items.length;
        items[firstIndex] = x;

        size++;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resizeUp(size * 2);
        }
        lastIndex = (lastIndex + 1 + items.length) % items.length;
        items[lastIndex] = x;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        } else {
            for (int printNums = 0; printNums != size; printNums++) {
                System.out.println(items[(firstIndex + printNums) % items.length]);
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T result = items[firstIndex];
            firstIndex = (firstIndex + 1) % items.length;
            size--;
            if (size == 0.25 * items.length) {
                resizeDn(items.length/4);
            }
            return result;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T result = items[lastIndex];
            lastIndex = (lastIndex - 1 + items.length) % items.length;
            size--;
            if (size == 0.25 * items.length) {
                resizeDn(items.length/4);
            }
            return result;
        }
    }

    private void resizeUp(int cap) {
        T[] a = (T[]) new Object[cap];
        for (int i = firstIndex, j = 0; j != size; i++, j++) {
            a[j] = items[i % items.length];
        }
        items = a;
        firstIndex = 0;
        lastIndex = size - 1;
    }

    private void resizeDn(int cap) {
        T[] a = (T[]) new Object[cap];
        for (int i = firstIndex, j = 0; j != size; i++, j++) {
            a[j] = items[i % items.length];
        }
        items = a;
        firstIndex = 0;
        lastIndex = size - 1;
    }

    public T get(int index) {
        return items[(firstIndex + index) % items.length];
    }
}

