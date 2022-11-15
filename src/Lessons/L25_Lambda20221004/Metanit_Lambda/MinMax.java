package Lessons.L25_Lambda20221004.Metanit_Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// ����� `User`, ������� ��������� ���� `name` � `age`
class User
{
    private String name;
    private Integer age;

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    // ������ ������� � �������

    @Override
    public String toString() {
        return "[" + name + ", " + String.valueOf(age) + "]";
    }
}

// ������� ������������ � ����������� �������� ���� ����� ���������������� ��������
// ������������� ������ � Java 8 � ����
class Main
{
    public static void main(String[] args)
    {
        List<User> users = Arrays.asList(new User("George", 15),
                new User("Tom", 10),
                new User("Mike", 12));

        // �������� ������������ � ����������� ���������
        User user1 = users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .get();

        System.out.println("User with minimum age: " + user1);

        // �������� ������������ � ������������ ���������
        User user2 = users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .get();
        
        System.out.println("User with maximum age: " + user2);
    }
}



public class MinMax {


}
