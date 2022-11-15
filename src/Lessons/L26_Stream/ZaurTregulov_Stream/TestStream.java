package Lessons.L26_Stream.ZaurTregulov_Stream;

import Lessons.L25_Lambda20221004.zaurTregulov_Lambda.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> ls = List.of("Privet","Poka","Ok","Uchim JAVA");
        List<Integer> list1 = ls.stream()
                .map(element->element.length())
                .collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("--------------------");

        int[] arrayI = {1,2,3,4,5,6,7,8};
        arrayI = Arrays.stream(arrayI).map(element ->{
            if (element %3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(arrayI));

        Set<String> set = new TreeSet<>();
        set.addAll(ls);
        System.out.println(set);
        Set<Integer> set2 = set.stream().map(String::length).collect(Collectors.toSet());
        System.out.println(set2);

        ///соединить в одну строку слова из массивиа или
        // Ћиста с заданным разделителему
        String delimiter=" ";
        String[] words = {"Hello", "word", "java", "test"};
        // ћассив words
        String string1 =Arrays.stream(words).collect(Collectors.joining(delimiter));
        System.out.println("из массива worgs: '"+string1+"'");
        // —писок ls
        String string2 = ls.stream().collect(Collectors.joining(delimiter));
        System.out.println("из списка ls: '"+string2+"'");
        //reduce
        int[] array1 = {1,2,3,4,5};
        // произведение всех элементов,
        int result = Arrays.stream(array1).reduce((accumulator, element) ->accumulator*element).getAsInt();
        // максимальный элемент в массиве инитов
        int result0 = Arrays.stream(array1).reduce((el1,el2) -> (int)Math.max(el1,el2)).getAsInt();
        System.out.println("посчитали сумму ч/з reduce: "+result);
        string1=Arrays.stream(words).reduce((a,e)->a+" "+e).get();
        System.out.println("собрать строку reduce из массива worgs: '"+string1+"'");
        /// Optional:
        List<Integer> list3 = new ArrayList<>();

        Optional<Integer> o = list3.stream().reduce((el1,el2) -> (int)Math.max(el1,el2));
        if (o.isPresent()) {
            System.out.println(o.get());
        }else{
            System.out.println("Not present");
        }
        /// sorted: - сортировк студентов по имени

        Student st1 = new Student("Viktor", 'm', 22, 3, 8.3);
        Student st2 = new Student("Viktoria", 'f', 28, 5, 8.2);
        Student st3 = new Student("Petr", 'm', 19, 2, 8.9);
        Student st4 = new Student("Tatsiana", 'f', 21, 4, 9);
        Student st5 = new Student("Adam", 'm', 23, 5, 9.2);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students= students.stream().sorted((x, y)->x.getName().compareTo(y.getName())).collect(Collectors.toList());
        System.out.println(students);

        /// concat: собрать несколько потоков в один
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        Stream<Integer> stream2 = Stream.of(6,7,8,9,0);
        Stream<Integer> stream4 = Stream.of(6,7,8,9,0);
        Stream<Integer> straem3 = Stream.concat(stream1,stream2);
    }
}
