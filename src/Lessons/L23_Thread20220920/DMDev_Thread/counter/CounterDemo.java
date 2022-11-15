package Lessons.L23_Thread20220920.DMDev_Thread.counter;

public class CounterDemo {
    public static void main(String[] args) {


        Counter counter = new Counter();
        CounterThread counterThread0 = new CounterThread(counter);
        CounterThread counterThread1 = new CounterThread(counter);
        CounterThread counterThread2 = new CounterThread(counter);
        CounterThread counterThread3 = new CounterThread(counter);
        CounterThread counterThread4 = new CounterThread(counter);
        CounterThread counterThread5 = new CounterThread(counter);
        CounterThread counterThread6 = new CounterThread(counter);
        CounterThread counterThread7 = new CounterThread(counter);
        CounterThread counterThread8 = new CounterThread(counter);
        CounterThread counterThread9 = new CounterThread(counter);
        CounterThread counterThread10 = new CounterThread(counter);
        CounterThread counterThread11 = new CounterThread(counter);
        CounterThread counterThread12 = new CounterThread(counter);
        CounterThread counterThread13 = new CounterThread(counter);
        CounterThread counterThread14 = new CounterThread(counter);
        counterThread0.start();
        counterThread1.start();
        counterThread2.start();
        counterThread3.start();
        counterThread4.start();
        counterThread5.start();
        counterThread6.start();
        counterThread7.start();
        counterThread8.start();
        counterThread9.start();
        counterThread10.start();
        counterThread11.start();
        counterThread12.start();
        counterThread13.start();
        counterThread14.start();

        try {
            counterThread0.join();
            counterThread1.join();
            counterThread2.join();
            counterThread3.join();
            counterThread4.join();
            counterThread5.join();
            counterThread6.join();
            counterThread7.join();
            counterThread8.join();
            counterThread9.join();
            counterThread10.join();
            counterThread11.join();
            counterThread12.join();
            counterThread13.join();
            counterThread14.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getCount());
    }
}
