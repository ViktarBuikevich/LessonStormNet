package Lessons.L25_Lambda20221004.Metanit_Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//  ласс `User`, имеющий приватные пол€ `name` и `age`
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

    // другие геттеры и сеттеры

    @Override
    public String toString() {
        return "[" + name + ", " + String.valueOf(age) + "]";
    }
}

// Ќаходим максимальное и минимальное значение пол€ среди пользовательских объектов
// использование потока в Java 8 и выше
class Main
{
    public static void main(String[] args)
    {
        List<User> users = Arrays.asList(new User("George", 15),
                new User("Tom", 10),
                new User("Mike", 12));

        // получаем пользовател€ с минимальным возрастом
        User user1 = users.stream()
                .min(Comparator.comparingInt(User::getAge))
                .get();

        System.out.println("User with minimum age: " + user1);

        // получаем пользовател€ с максимальным возрастом
        User user2 = users.stream()
                .max(Comparator.comparingInt(User::getAge))
                .get();
        
        System.out.println("User with maximum age: " + user2);
    }
}



public class MinMax {


}
