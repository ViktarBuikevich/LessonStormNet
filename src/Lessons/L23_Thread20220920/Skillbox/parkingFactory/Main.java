package Lessons.L23_Thread20220920.Skillbox.parkingFactory;

import java.util.Arrays;

public class Main{
    public static int maxProductOf2(Integer[] arr){
        Arrays.sort(arr);
        int max1=arr[0]*arr[1];
        int max=arr[arr.length-1]*arr[arr.length-2];
        return max>=max1?max:max1;
    }
    public static void main(String[] args) {
//        Parking parking = new Parking();
//        Thread customer = new Thread( new Customer(parking));
//        Thread producer = new Thread( new Producer(parking));
//        producer.start();
//        customer.start();
        //Main m = new Main();
        Integer[] array = { -5, -11, 10 };
        System.out.println(maxProductOf2(array));
        for (Integer values : array) {
            System.out.print(values + ", ");
            // 10, 8, 5, 2, 1,
        }
    }
}
