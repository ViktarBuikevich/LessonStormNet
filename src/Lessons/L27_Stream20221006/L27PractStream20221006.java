package Lessons.L27_Stream20221006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class L27PractStream20221006 {
    public static void main(String[] args) {
        System.out.println("\n\n------DZ#1------");
        /*
        1/ ������ ��������� ������� �����������. ����������� ���������, ������� ���������� ��� �������, ������������ �� ����� �L�.
         */
        List<String> listFam = Arrays.asList("Asimka","Ljuchta","Litvin","Buikevich","Shit'ko");
        listFam.stream().filter(str -> str.startsWith("L")).forEach(System.out::println);

        System.out.println("\n\n------DZ#2------");
        /*
         2/ ���� ��������� �������ArrayList: [a1, a2, ..., an], [b1, b2, ..., bm], [c1,c2,...,ck].
            �������� ����� ������� ��� ���� n=m=k �� �� � ���������� ������ �������� ����� ������,
            ������� �������� ���������� �� ���� ��������� ����� ��������� �������,
            �� ��������������� � ��������� ������� [a1, b1, �1, a2, b2, �2, ..., an, bm, �k].
        */
        List<String> la = Arrays.asList("a1","a2","a3");
        List<String> lb = Arrays.asList("b1","b2","b3");
        List<String> lc = Arrays.asList("c1","c2","c3");
        if (la.size() == lb.size()&&lb.size()==lc.size()) {
            List<List<String>> list = Arrays.asList(la, lb, lc);
            //System.out.println(list);
            List<String> lResalt = list.stream().flatMap(Collection::stream).collect(Collectors.toList()); //.forEach(System.out::println);
            System.out.println(lResalt);
        }else{
            System.out.println("�� ����������� ������� m=n=k!");
        }

        System.out.println("\n\n------DZ#3------");
        /*
        3/ ��� ����� �����, ��������� ���������� ������ ���� �� ���� ������� � �������������� StreamAPI
         */

        //HashSet<String> setString = new HashSet<String>();
        String str = "aaabbc12@++=rR+��.";
        System.out.println(str.chars().distinct().filter(ch->(((int)ch>64&&(int)ch<91)||((int)ch>96&&(int)ch<123)||((int)ch>191))).count());
    }
}
