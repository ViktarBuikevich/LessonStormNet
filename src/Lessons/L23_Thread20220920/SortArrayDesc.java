package Lessons.L23_Thread20220920;

import java.util.Arrays;
import java.util.Collections;

public class SortArrayDesc implements Runnable {
    private Integer[] array;

    public SortArrayDesc(int[] arr) {
        //this.array = array;
        array = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Arrays.sort(array, Collections.reverseOrder());
        //¬ыводим отсортированный массив на консоль.
        System.out.println("po DESC");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");

        }
        System.out.println();
    }
}
