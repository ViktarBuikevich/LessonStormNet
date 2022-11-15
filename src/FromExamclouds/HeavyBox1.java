package FromExamclouds;

public class HeavyBox1 extends Box6{
    private int weight;

    public HeavyBox1(Integer id, String name, int weight) {
        super(id, name);
        this.weight=weight;
    }

    @Override
    public String toString() {
        return "HeavyBox1{" +
                "weight=" + weight +
                '}';
    }
}
