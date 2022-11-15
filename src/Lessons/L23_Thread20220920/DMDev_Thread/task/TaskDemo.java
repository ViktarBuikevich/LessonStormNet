package Lessons.L23_Thread20220920.DMDev_Thread.task;

import java.util.LinkedList;
import java.util.Queue;

public class TaskDemo {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        // чтобы иметь возможность работать с ProducerThread & ConsumerThread
        // создам объекты не как:
        // ProducerThread producerThread = new ProducerThread(queue);
        //  ConsumerThread consumerThread = new ConsumerThread(queue);
        // оборачиваем их в клас Thread
        Thread producerThread = new Thread(new ProducerThread(queue));
        Thread consumerThread = new Thread(new ConsumerThread(queue));
        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }
}
