package Lessons.L23_Thread20220920;

public class Test {
    public static void main(String[] args) {
        int[] arr ={1, 45,78, 4, 7};
        SortArrayAsc a = new SortArrayAsc(arr);
        Thread threadA = new Thread(a);

        SortArrayDesc d = new SortArrayDesc(arr);
        Thread threadD =new Thread(d);
        threadA.start();
        threadD.start();

    }
}
