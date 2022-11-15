package Lessons.L25_Lambda20221004.DMDev_Lambda;

import java.util.Comparator;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
////  ����������� ����������� � ������� ��������� �������
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//        };
////  ����������� ����������� � ������� ������ ������� 1.
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
////  ����������� ����������� � ������� ������ ������� 2. ���������� � ������������
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator.compare(25, 100));
        System.out.println(comparator1.compare(478, 149));
        List<String> strings = List.of("11", "22", "33", "44", "55");
        for (String string : strings) {
            String value = string + string;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0) {
                System.out.println(intValue);
            }
        }
    }
}

