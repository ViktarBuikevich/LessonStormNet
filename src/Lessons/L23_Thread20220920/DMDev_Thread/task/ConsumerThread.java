package Lessons.L23_Thread20220920.DMDev_Thread.task;

import java.util.Queue;

public class ConsumerThread implements Runnable {
    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove(); // извлекаем из очереди очередное значение
                    System.out.println("consumer get value: " + removedValue+", size: "+list.size());
                } else {
                    System.out.println("list is empty, there is nothing to extract from the queue");
                }
                try {
                    int random = RandomUtil.getRandom();
                    System.out.println("consumer wait: "+random);
                    list.notifyAll(); // оповещаем что очередь переходит в режим ожидания
                    // и можно добавлять к ней новые елементы ProduserThread-ам
                    list.wait(random); // ожидаем
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
