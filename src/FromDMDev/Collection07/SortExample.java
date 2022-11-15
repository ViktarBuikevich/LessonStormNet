package FromDMDev.Collection07;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        //List.of
        List<String> strings =Arrays.asList("723","123","213","124","14");
        Collections.sort(strings);
        System.out.println(strings);
        List<Person> personList = Arrays.asList(
                new Person(1, "Ivan","Ivanov"),
                new Person(32, "Ivan","Vasiljev"),
                new Person(12, "Vasiliy","Pertov"),
                new Person(22, "Nikolay","Shem'yakin"),
                new Person(10, "Anna","Maur"),
                new Person(23, "Nikolay","Petov"),
                new Person(11, "Yanka","Maur"),
                new Person(33, "Nikolay","Azimko"),
                new Person(17, "Yanka","Kupala")
                );
        System.out.println("original: /n"+ personList);
        Collections.sort(personList);
        System.out.println("sort(personList): /n"+ personList);

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (o1.getLastName().compareTo(o2.getLastName())==0) ? o2.getFirstName().compareTo(o1.getFirstName()) : o1.getLastName().compareTo(o2.getLastName());
                //return o2-o1;
            }
        });
        System.out.println("sort lastName, firstName: /n"+ personList);
        Collections.sort(personList, new FullNameComparator());
        System.out.println("sort FullNameComparator: /n"+ personList);
    }
    public static class FirstNameComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
    public static class FullNameComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }
}
