package FromDMDev.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class List<T> implements  Iterable<T>{
    private T[] objects;
    private  int size;

    public List(int initialSize){
        this.objects =(T[]) new Object[initialSize];
    }
    public void add(T elem){
        objects[size++] = elem;
    }
    public T get(int index){
        return objects[index];
    }
    public int getSize(){return size;}


    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T>{
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex<size;
        }

        @Override
        public T next() {
            return objects[currentIndex++];
        }
    }
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
