package uni;
import java.util.*;

public class Major {

    private int majorID;
    private String name;
    private final int maxCapacity;
    public int numberOfStudents = 0;
    public static List<Major> majorList = new ArrayList<>();

    public Major(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        majorList.add(this);
        this.majorID = majorList.size();
    }

    public void addStudent() {
        if(numberOfStudents < maxCapacity) {
            numberOfStudents++;
        } else {
            System.out.println("Major capacity full!");
        }
    }

    public static Major findById(int id) {
        for(Major major : majorList) {
            if(major.majorID == id)
                return major;
        }
        return null;
    }

    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }
}