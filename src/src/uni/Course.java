package uni;
import java.util.*;

public class Course {
    private int courseID;
    private String title;
    private int units;
    public static List<Course> courseList = new ArrayList<>();

    public Course(String title, int units) {
        this.title = title;
        this.units = units;
        courseList.add(this);
        this.courseID = courseList.size();
    }
    public static Course findById(int id) {
        for (Course course : courseList) {
            if (course.courseID == id) {
                return course;
            }
        }
        return null;
    }

    public int getUnits() {
        return this.units;
    }
    public String getTitle() {
        return this.title;
    }
}



class PresentedCourse {
    private int presentedCourseID;
    private int courseID;
    private int professorID;
    private int maxCapacity;
    private List<Integer> studentIDList;
    public static List<PresentedCourse> presentedCourseList = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.maxCapacity = maxCapacity;
        this.studentIDList = new ArrayList<>(maxCapacity);
        presentedCourseList.add(this);
        this.presentedCourseID = presentedCourseList.size();
    }

    public static PresentedCourse findById(int id) {
        for (PresentedCourse pc : presentedCourseList) {
            if (pc.presentedCourseID == id) {
                return pc;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if(studentIDList.size() < maxCapacity) {
            studentIDList.add(studentID);
        } else {
            System.out.println("Course full!");
        }
    }

    public List<Integer> getStudentIDList() {
        return this.studentIDList;
    }
    public int getCourseID() {
        return this.courseID;
    }
}