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
        1/ Задано множество фамилий сотрудников. Разработать программу, которая отображает все фамилии, начинающиеся на букву «L».
         */
        List<String> listFam = Arrays.asList("Asimka","Ljuchta","Litvin","Buikevich","Shit'ko");
        listFam.stream().filter(str -> str.startsWith("L")).forEach(System.out::println);

        System.out.println("\n\n------DZ#2------");
        /*
         2/ Даны несколько списковArrayList: [a1, a2, ..., an], [b1, b2, ..., bm], [c1,c2,...,ck].
            Задается такое условие что если n=m=k то мы в результате должны получить новый список,
            который содержит комбинацию из всех элементов ранее сказанных списков,
            но отсортированные в следующем порядке [a1, b1, с1, a2, b2, с2, ..., an, bm, сk].
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
            System.out.println("не выполняется условие m=n=k!");
        }

        System.out.println("\n\n------DZ#3------");
        /*
        3/ Дан набор строк, посчитать количество разных букв во всех строках с использованием StreamAPI
         */

        //HashSet<String> setString = new HashSet<String>();
        String str = "aaabbc12@++=rR+Яя.";
        System.out.println(str.chars().distinct().filter(ch->(((int)ch>64&&(int)ch<91)||((int)ch>96&&(int)ch<123)||((int)ch>191))).count());
    }
}
