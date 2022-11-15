package Lessons.L28_Stream20221011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
1/ Необходимо создать класс клиента со следующими полями: уникальный идентификатор, имя, возраст.
Также у клиента есть список телефонов. Класс телефона содержит само значение и тип (стационарный или мобильный).

Найти самого возрастного клиента, которой пользуется стационарным телефоном
 */
public class L28PractStream_1 {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        clients.add(new Client("Ivanov",21,
                new ArrayList<Phone>(Arrays.asList(new Phone("+3752988888", TypePhone.MOBILE), new Phone("8(0162)28888", TypePhone.LANDLINE)))));

        clients.add(new Client("Petrov",60,
                new ArrayList<Phone>(Arrays.asList(new Phone("+375233458", TypePhone.LANDLINE)))));

        clients.add(new Client("Semenov",35,
                new ArrayList<Phone>(Arrays.asList(new Phone("+3752928888", TypePhone.MOBILE), new Phone("8(0172)222222", TypePhone.LANDLINE)))));

        clients.add(new Client("Marivanna",25,
                new ArrayList<Phone>(Arrays.asList(new Phone("+3752988888", TypePhone.MOBILE), new Phone("8(0162)28888", TypePhone.LANDLINE)))));

        Client maxAgeClient = clients.stream()
                .filter(client -> client.getListPhone().stream().anyMatch(phone -> phone.getTypePhone().equals(TypePhone.LANDLINE)))
                .max(Comparator.comparingInt(Client::getAge))
                .get();

        System.out.println("Client with maximum age: " + maxAgeClient);

//
    }
}
