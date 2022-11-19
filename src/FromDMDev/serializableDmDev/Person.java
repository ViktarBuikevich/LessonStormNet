package FromDMDev.serializableDmDev;

import java.io.Serializable;

public class Person implements Serializable {
    private  int age;
    private String firstName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        return getFirstName() != null ? getFirstName().equals(person.getFirstName()) : person.getFirstName() == null;
    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        return result;
    }

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }
}
