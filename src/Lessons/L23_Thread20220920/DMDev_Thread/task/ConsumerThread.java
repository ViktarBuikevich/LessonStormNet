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
                    Integer removedValue = list.remove(); // ��������� �� ������� ��������� ��������
                    System.out.println("consumer get value: " + removedValue+", size: "+list.size());
                } else {
                    System.out.println("list is empty, there is nothing to extract from the queue");
                }
                try {
                    int random = RandomUtil.getRandom();
                    System.out.println("consumer wait: "+random);
                    list.notifyAll(); // ��������� ��� ������� ��������� � ����� ��������
                    // � ����� ��������� � ��� ����� �������� ProduserThread-��
                    list.wait(random); // �������
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
