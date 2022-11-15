package Lessons.L12_ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayListVB<String> list=new ArrayListVB<>();
        list.add("1213");
    list.add("2134");
    list.add("323");
    list.add("1213");
        System.out.println(list.toString());
    list.remove("000");
        System.out.println(list.toString());
    list.remove("323");
        System.out.println(list.toString());
    }

    public int[] bubbleSort(int[] integers) {
        boolean isSort = false;
        int tmp;
        while (!isSort) {
            isSort = true;
            for (int i = 0; i < integers.length - 1; i++) {
                if (integers[i] > integers[i + 1]) {
                    tmp=integers[i];
                    integers[i]=integers[i+1];
                    integers[i]=tmp;
                    isSort = false;
                }
            }
        }
        return integers;
    }
}
