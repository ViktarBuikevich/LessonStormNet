package Lessons.L23_Thread20220920.DMDev_Thread.counter;

public class Counter {
    private static  String desctiption;
    private int count;
    public static void init(){
        //Class<Counter> counterClass = Counter.class;
        //synchronized (counterClass) {
        synchronized (Counter.class) {
            if (desctiption == null) {
                desctiption = "Test description";
            }
        }
    }
    public synchronized void increment(){count++;}
    public synchronized void decrement(){count--;}

    public int getCount() {
        return count;
    }
}
