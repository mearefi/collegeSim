package uni;
import java.util.*;

public class Transcript {
    private int studentID;
    private Map<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse pc = PresentedCourse.findById(presentedCourseID);
        if(pc != null && pc.getStudentIDList().contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        }
    }

    public double getGPA() {
        double totalPoints = 0.0;
        int totalUnits = 0;

        for(Map.Entry<Integer, Double> entry : transcript.entrySet()) {
            int presentedCourseID = entry.getKey();
            double grade = entry.getValue();

            PresentedCourse pc = PresentedCourse.findById(presentedCourseID);

            if(pc != null && pc.getStudentIDList().contains(this.studentID)) {
                Course course = Course.findById(pc.getCourseID());
                if(course != null) {
                    totalPoints += grade * course.getUnits();
                    totalUnits += course.getUnits();
                }
            }
        }

        return totalUnits > 0 ? totalPoints / totalUnits : 0.0;
    }

    public void printTranscript() {
        if (transcript.isEmpty()) {
            System.out.println("Student transcript is empty.");
            return;
        }

        for (Map.Entry<Integer, Double> entry : transcript.entrySet()) {
            int presentedCourseID = entry.getKey();
            double grade = entry.getValue();

            PresentedCourse pc = PresentedCourse.findById(presentedCourseID);
            if (pc != null) {
                Course course = Course.findById(pc.getCourseID());
                if (course != null) {
                    System.out.println(course.getTitle() + ": " + grade);
                } else {
                    System.out.println("Course with ID " + pc.getCourseID() + " not found!");
                }
            } else {
                System.out.println("Presented course with ID " + presentedCourseID + " not found!");
            }
        }
    }
}