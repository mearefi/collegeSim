package uni;
import java.util.*;

public class Professor {

    private int professorID;
    private int personID;
    private int majorID;
    public static List<Professor> professorList = new ArrayList<>();

    public Professor(int personID, int majorID) {
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
        this.professorID = professorList.size();
    }

    public static Professor findById(int id) {
        for (Professor professor : professorList) {
            if (professor.professorID == id) {
                return professor;
            }
        }
        return null;
    }
}