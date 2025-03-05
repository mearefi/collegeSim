package uni;
import base.Person;

public class Main {
    public static void main(String[] args) {

        new Person("Ilia", "001");
        new Person("Mobin", "002");
        new Person("Amin", "003");
        new Person("Mina", "004");
        new Person("Fatemeh", "005");

        Major compSci = new Major("Computer Science", 100);
        Major electrical = new Major("Electrical Engineering", 80);

        Student s1 = new Student(1, 2022, 1);
        Student s2 = new Student(2, 2023, 2);
        Student s3 = new Student(3, 2024, 3);

        Student.studentList.forEach(s -> System.out.println(
                Person.findById(s.getPersonID()).getName() + ": " + s.getStudentCode()
        ));

        Professor p1 = new Professor(4, 1);
        Professor p2 = new Professor(5, 2);

        Course math = new Course("Calculus", 3);
        Course physics = new Course("Physics", 4);
        Course circuits = new Course("Circuits", 3);

        PresentedCourse pc1 = new PresentedCourse(1, 1, 30);
        PresentedCourse pc2 = new PresentedCourse(2, 2, 25);
        PresentedCourse pc3 = new PresentedCourse(3, 3, 20);

        pc1.addStudent(1);
        pc1.addStudent(2);

        Transcript t1 = new Transcript(1);
        t1.setGrade(1, 18.5);

        System.out.println("GPA for Student 1: " + t1.getGPA());
    }
}