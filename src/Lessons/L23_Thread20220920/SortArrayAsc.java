package Lessons.L23_Thread20220920;

import java.util.Arrays;

public class SortArrayAsc implements Runnable {
    private int[] array;

    public SortArrayAsc(int[] arr) {
        this.array = arr;
        }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Arrays.sort(array);
        //¬ыводим отсортированный массив на консоль.
        System.out.println("po ASC");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");

        }
        System.out.println();
    }

}
