package Lessons.L23_Thread20220920.DMDev_Thread;

public class SimpleRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from runnable class SimpleRunnable: "+Thread.currentThread().getName());
    }
}
