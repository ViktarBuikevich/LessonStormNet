package FromDMDev.Collection07;

import java.util.*;

public class TestComparable {
    public static void main(String[] args) {
//        сортировка по массиву и листу поднятому из массива
//        заодно пример на работу с массивом
        Integer[] arr =new Integer[]{12,23,43,123,2,1,32,32,55,66,77,3,77,77};
        List <Integer> listInteger = new ArrayList<>(List.of(arr));
        System.out.println("Before sorting listInteger:\n"+listInteger);
        Collections.sort(listInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("After sorting listInteger(desc):\n"+listInteger);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.print("arr = {");
        for (Integer i:arr
        ) {
            System.out.print(i.toString()+", ");
        }
        System.out.println("}");

//      сортировка листа произвольных классов
        List<Employe> list = new ArrayList<>();
        Employe e1= new Employe(100, "Boris", "Borisov", 10000);
        Employe e2= new Employe(12, "Yanka", "Maur", 5477);
        Employe e3= new Employe(23, "Alex", "Maur", 65781);
        Employe e4= new Employe(134, "Vadim", "Bagun", 10000);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        System.out.println("Before sorting \n"+list);

//        Естественный порядок сортировки используя
//        интерфейс Comparable метод compareTo()
        Collections.sort(list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting (id) \n"+list);
//        сортируем по зарплате
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting salary \n"+list);
//        сортируем по имени
        Collections.sort(list, new NameComparator());
        System.out.println("After sorting salary \n"+list);
//        сортируем по фамилии и зарплате по убыванию
//        используя анонимные классы
        Collections.sort(list, new Comparator<Employe>() {
                    @Override
                    public int compare(Employe o1, Employe o2) {
                        return (o1.surname.compareTo(o2.surname)==0) ? o2.salary-o1.salary : o1.surname.compareTo(o2.surname);
                    }
                });
        System.out.println("After sorting surname & salary (desc) \n" + list);
    }
}
class Employe implements  Comparable<Employe>{
    int id;
    String name;
    String surname;
    int salary;

    public Employe(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employe o) {
        return (this.id-o.id);
    }
}

class SalaryComparator implements  Comparator<Employe> {
    @Override
    public int compare(Employe o1, Employe o2) {
        return o1.salary - o2.salary;
    }
}
class NameComparator implements  Comparator<Employe> {
    @Override
    public int compare(Employe o1, Employe o2) {
        return (o1.surname.compareTo(o2.surname) == 0) ? o1.name.compareTo(o2.name) : o1.surname.compareTo(o2.surname);
    }
}