public class ArrayDeque<T> {
    public T[] items;
    public int firstIndex;
    public int lastIndex;
    public int size;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        firstIndex = 1;
        lastIndex = 0;
        size = 0;
    }
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size*2);
        }
        firstIndex = (firstIndex - 1 + items.length) % items.length;
        items[firstIndex] = x;

        size ++;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size*2);
        }
        lastIndex = (lastIndex + 1 + items.length) % items.length;
        items[lastIndex] = x;
        size ++;
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
        }
        else{
            for(int printNums = 0; printNums != size; printNums++){
                System.out.println(items[(firstIndex + printNums) % items.length]);
            }
        }
    }



    public T removeFirst() {
        if (size == 0){
            return null;
        }
        else{
            firstIndex = (firstIndex + 1 + items.length) % items.length;
            size --;
            return items[(firstIndex - 1 + items.length) % items.length];
        }
    }

    public T removeLast() {
        if (size == 0){
            return null;
        }
        else{
            lastIndex = (lastIndex - 1 + items.length) % items.length;
            size --;
            return items[(lastIndex + 1 + items.length) % items.length];
        }
    }

    public void resize(int cap){
        T[] a = (T[]) new Object[cap];
        if (firstIndex < lastIndex){
            System.arraycopy(items, 0, a, 0, size);
        }
        else {
            System.arraycopy(items, 0, a, 0, lastIndex + 1);
            System.arraycopy(items, firstIndex, a, firstIndex + cap - size, size - firstIndex);
            firstIndex = firstIndex + cap - size;
        }
        items = a;
    }

    public T get(int index) {
        return items[(firstIndex + index) % items.length];
    }
}

