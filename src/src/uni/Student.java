package uni;

import base.Person;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private int studentID;
    private int personID;
    private final int entranceYear;
    private int majorID;
    private String studentCode;
    public static List<Student> studentList = new ArrayList<>();

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;

        Major major = Major.findById(majorID);
        if (major != null) {
            major.addStudent();
        }

        setStudentCode();
        studentList.add(this);
        this.studentID = studentList.size();
    }

    private void setStudentCode() {
        Major major = Major.findById(majorID);
        if(major != null) {
            int currentStudents = major.getNumberOfStudents() + 1;
            this.studentCode = entranceYear + "/" +
                    String.format("%02d", majorID) +
                    String.format("%03d", currentStudents);
        } else {
            this.studentCode = "not correct";
        }
    }

    public static Student findById(int ID) {
        for (Student student : studentList) {
            if (student.getStudentID() == ID) {
                return student;
            }
        }
        return null;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getPersonID() {
        return personID;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public int getMajorID() {
        return majorID;
    }

    public String getStudentCode() {
        return studentCode;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", personID=" + personID + ", entranceYear=" + entranceYear + ", majorID=" + majorID + ", studentCode='" + studentCode + '\'' + '}';
    }
}