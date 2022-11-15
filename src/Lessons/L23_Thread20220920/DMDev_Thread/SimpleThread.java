package Lessons.L23_Thread20220920.DMDev_Thread;

public class SimpleThread  extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Hello "+getName());
    }
}
