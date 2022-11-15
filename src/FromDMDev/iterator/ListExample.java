package FromDMDev.iterator;

public class ListExample {
    public static void main(String[] args) {
        List<String> list =new List<>(10);
        list.add("s0");
        list.add("s1");
        list.add("s2");
        list.add("s3");
        for (String el: list) {
            System.out.println(el);
        }
    }
}
