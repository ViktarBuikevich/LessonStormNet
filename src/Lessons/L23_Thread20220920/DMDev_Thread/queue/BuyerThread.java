package Lessons.L23_Thread20220920.DMDev_Thread.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {
    private final Queue<Cashbox> cashboxes;

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override

    public void run() {
        synchronized (cashboxes) {
            while (true) {
                try {
                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
                        //Thread.sleep(5L); // выполняются операци по обслуживанию покупателя в кассе
                        cashboxes.wait(5L);
                        System.out.println(Thread.currentThread().getName() + " особождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashboxes.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу ");
                        //Thread.sleep(5L);
                        cashboxes.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //throw new RuntimeException(e);
                }
            }
        }
    }
}
