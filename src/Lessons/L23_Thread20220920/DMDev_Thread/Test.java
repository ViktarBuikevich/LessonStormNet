package Lessons.L23_Thread20220920.DMDev_Thread;

public class Test {
    public static void main(String[] args) {

        SimpleThread simpleThread = new SimpleThread();

        //SimpleRunnable simpleRunnable = new SimpleRunnable();
        Thread runnableThread = new Thread(new SimpleRunnable(), "My SimpleRunnable");

        Thread lambdaThread = new Thread(() -> System.out.println("Hello from lambda: " + Thread.currentThread().getName()));
        simpleThread.start();
        runnableThread.start();
        lambdaThread.start();
        try {
            simpleThread.join();
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current Thread from main: "+Thread.currentThread().getName());
    }
}
