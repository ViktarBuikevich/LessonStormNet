package Lessons.L12_ArrayList;

//import jdk.internal.util.ArraysSupport;
import java.util.*;
import java.util.function.UnaryOperator;


//https://habr.com/ru/post/128269/
//Написать свою реализацию ArrayList (на массивах и тд) 6 методов:
// add (addAll)+-
// remove (removeAll)
// contains +
// size +
// isEmpty +
// clear

public class ArrayListVB <E extends Comparable>{

    private Object[] elementData;

    private int size;

    @Override
    public String toString() {
        return "ArrayListVB{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public ArrayListVB(Object[] element) {
        this.elementData = element;
    }
    public ArrayListVB() {
        this.elementData = new Object[10];
    }


    /** Проверка достаточности размера массива
     *
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow();
        }
    }

    /**
     * Увеличиваем список на 10 элементов
     */
    private Object[] grow() {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0) {
            int newCapacity = size+10;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[10];
        }
    }

    /**
     * размер Списка
     */
    public int size() {
        return size;
    }

    /**
     * Проверка на то, что Список пустой
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверка наличия объекта в Списке
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Найти объект в Списке
     */

    public int indexOf(Object o) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Добавляем  элемент в конец Списка
     */
    public boolean add(E e) {

        if (size == elementData.length)
            elementData = grow();
        elementData[size] = e;
        size++;
        return true;
    }

    /**
     * Добавляем элемент по индексу
     */
    public void add(int index, E element) {
        if (index > size || index < 0){
            System.out.println("Значение индекса за пределами массива!");
        }
        if ( size == this.elementData.length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++ ;
    }

    /**
     * удаляем элемент по индексу
     */
    public E remove(int index) {

        final Object[] es = elementData;

        E oldValue = (E) es[index];

        final int newSize=size - 1;
        if (newSize > index)
            System.arraycopy(es, index + 1, es, index, newSize - index);
        size = newSize;
        es[size] = null;


        return oldValue;
    }
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        remove(i);
        return true;
    }

}
