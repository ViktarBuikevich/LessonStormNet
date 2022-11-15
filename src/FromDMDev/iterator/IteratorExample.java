package FromDMDev.iterator;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        // варианты перебора массива с помощью Итератора
        // options for iterating over an array using an Iterator
        System.out.println("Var. 1");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.print(element + ", ");
        }
        System.out.println();
        System.out.println("Var. 2");
        for (Integer i: list ) {
            System.out.print(i+", ");
        }
        System.out.println();
        System.out.println("Var. 3");
        for (Iterator<Integer> iterator1 = list.iterator(); iterator1.hasNext();){
            Integer next = iterator1.next();

            System.out.println(next);
        }
    }
}
