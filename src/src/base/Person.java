package base;
import java.util.*;

public class Person {

    private int personID;
    private String name;
    private final String nationalID;
    public static List<Person> personList = new ArrayList<>();

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
        this.personID = personList.size();
    }

    public int getPersonID() {
        return personID;
    }
    public String getName() {
        return name;
    }

    public static Person findById(int ID) {
        for (Person person : personList) {
            if (person.getPersonID() == ID) {
                return person;
            }
        }
        return null;
    }
}