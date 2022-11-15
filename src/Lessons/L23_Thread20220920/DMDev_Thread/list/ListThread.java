package Lessons.L23_Thread20220920.DMDev_Thread.list;

import java.util.List;

public class ListThread extends Thread {
    private final List<Integer> list;

    public ListThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }
}
