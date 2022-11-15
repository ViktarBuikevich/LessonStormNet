package Lessons.L28_Stream20221011;

import java.util.ArrayList;

/*
1/ Необходимо создать класс клиента со следующими полями: уникальный идентификатор, имя, возраст.
Также у клиента есть список телефонов. Класс телефона содержит само значение и тип (стационарный или мобильный).

Найти самого возрастного клиента, которой пользуется стационарным телефоном
 */
public class Client {
    private static int nextId = 1;
    private int uId;
    private String name;
    private int age;
    private ArrayList<Phone> listPhone;

    public Client(String name, int age, ArrayList<Phone> listPhone) {
        uId=nextId;
        nextId++;
        this.name = name;
        this.age = age;
        this.listPhone = listPhone;
    }

    public int getuId() {
        return uId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Phone> getListPhone() {
        return listPhone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", listPhone=" + listPhone +
                '}';
    }
}
