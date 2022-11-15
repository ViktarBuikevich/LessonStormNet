package Lessons.L25_Lambda20221004.zaurTregulov_Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class RemoveIf {
    public static void main(String[] args) {
        /// 1
        ArrayList<String> al0 = new ArrayList(asList("Privet","Poka","Ok","Uchim JAVA")); //new ArrayList<>();
        al0.add("Cansel");
        System.out.println(al0);
        /// 2
        ArrayList<String> al1 = new ArrayList<>(List.of("Privet","Poka","Ok","Uchim JAVA"));
        al1.add("Cansel");
        System.out.println(al1);
        /// 3
        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        cities.add("Minsk");
        System.out.println(cities);
        /// 4
        List<String> strings = new ArrayList<>(asList("foo", "bar"));
        strings.add("baz"); // изменняемый список
        System.out.println(strings);
        /// 5
        List<String> strings1 = new ArrayList<>(asList("foo", "bar"));
        strings1.add("baz"); // изменняемый список
        System.out.println(strings1);

        al0.removeIf(el->el.length()<5);
        System.out.println(al0);
        al1.forEach(str->System.out.println(str));
        al1.forEach(System.out::println);
        System.out.println(al1);

    }
}
