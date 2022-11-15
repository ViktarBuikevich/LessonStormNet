package Lessons.L25_Lambda20221004;

public class HeavyBox {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public HeavyBox(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HeavyBox{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
