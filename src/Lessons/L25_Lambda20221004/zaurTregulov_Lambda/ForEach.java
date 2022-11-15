package Lessons.L25_Lambda20221004.zaurTregulov_Lambda;

import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> ls = List.of("Privet","Poka","Ok","Uchim JAVA");
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);
        ls.forEach(System.out::println);
        list.forEach(el->{
            System.out.print(el);
            el*=2;
            System.out.println(" x 2 = "+el);
        });
    }
}
