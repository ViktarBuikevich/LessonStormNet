package Lessons.L23_Thread20220920.DMDev_Thread.queue;

public class Cashbox {
    private static int generator=1;
    private int id;

    public Cashbox() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
