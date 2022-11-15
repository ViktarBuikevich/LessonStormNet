package Lessons.L23_Thread20220920.DMDev_Thread.task;

import java.util.Queue;

public class ProducerThread  implements Runnable{
    private final Queue<Integer> list;

    public ProducerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list){
            while(true){
                if(list.size()<10){
                    int random = RandomUtil.getRandom();
                    list.add(random);
                    System.out.println("producer adds value: "+random+", size: "+list.size());
                } else {
                    System.out.println("producer does nothing");
                }
                list.notifyAll(); // оповещаем наших ConsumerThread потребителей,
                // что мы освободили объект после добавления в него элемента
                // и с ним можно работать из других потоков
                try {
                    int randomWaitValue = RandomUtil.getRandom(5);
                    System.out.println("producer wait: "+randomWaitValue);
                    list.wait(randomWaitValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
