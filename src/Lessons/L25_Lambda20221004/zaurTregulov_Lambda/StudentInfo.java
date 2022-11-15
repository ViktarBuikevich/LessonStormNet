package Lessons.L25_Lambda20221004.zaurTregulov_Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentInfo {
    /// Predicate
      void testStudents(ArrayList<Student> al, Predicate<Student> pr){
            for (Student s:al) {
                if (pr.test(s)){
                    System.out.println(s);
                }
            }
        }
    /// Function
    public double avgOfSmth(List<Student> list, Function<Student, Double> f){
        double resalt=0;
        for(Student st: list){
            resalt+=f.apply(st);
        }
        resalt = resalt / list.size();
        return resalt;
    }
}
class Test{
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Masha", 'f', 28, 5, 8.2);
        Student st3 = new Student("Petr", 'm', 19, 2, 8.9);
        Student st4 = new Student("Tatsiana", 'f', 21, 4, 9);
        Student st5 = new Student("Viktar", 'm', 23, 5, 9.2);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        StudentInfo info = new StudentInfo();
//        System.out.println("--- v1.Выполняем проверку (check), используя отдельносозданный класс реализующий интерфейс StudentsChecks---");
        //info.testStudents(students,new CheckOverGrade());
        System.out.println("--------------------------");
//        System.out.println("--- v1.Выполняем проверку (check), используя анонимный класс реализующий интерфейс StudentsChecks---");
//        info.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age>20;
//            }
//        });

        System.out.println("--- v1.Выполняем проверку (check), используя лямбда выражение---");
        System.out.println("--s->s.age<30-----------------------");
        info.testStudents(students, s->s.age<30);
        System.out.println("--s->s.avgGrade>8---------------");
        info.testStudents(students, s->s.avgGrade>8);
        System.out.println("--s->s.avgGrade>8&&s.age<30&&s.sex=='f'---------------");
        info.testStudents(students, s->s.avgGrade>8&&s.age<30&&s.sex=='f');
        double res = info.avgOfSmth(students, stud-> Double.valueOf(stud.age));
        System.out.println("Средний курс всех: "+ info.avgOfSmth(students, stud-> (double)(stud.course)));
        System.out.println("Средний балл всех: "+ info.avgOfSmth(students, st->st.avgGrade));
        System.out.println("Средний возраст всех: "+ info.avgOfSmth(students, st-> Double.valueOf(st.age)));
    }
}
//@FunctionalInterface
//interface StudentChecks {
//    boolean check(Student s);
//}
//class CheckOverGrade implements StudentChecks{
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade>8;
//    }
//
