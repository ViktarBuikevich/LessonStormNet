package FromDMDev.Collection07;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private int id;
    private String firstName;
    private String lastName;

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName.trim()+" "+lastName.trim();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", FIO:'" + firstName + " " + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person peson = (Person) o;

        if (getId() != peson.getId()) return false;
        if (!getFirstName().equals(peson.getFirstName())) return false;
        return getLastName().equals(peson.getLastName());
    }

    @Override
    public int hashCode() {
//        return getId();
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(id,o.id);
        //        return id-o.id;

//        if(id==o.id){ return 0;}
//        else if (id>o.id){ return 1;}
//        else{return -1;}
    }
}
