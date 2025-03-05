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
        Student s2 = new Student(2, 2023, 1);
        Student s3 = new Student(3, 2024, 2);

        for (Student s : Student.studentList) {
            System.out.println(Person.findById(s.getPersonID()).getName() + ": " + s.getStudentCode());
        }

        Professor p1 = new Professor(4, 1);
        Professor p2 = new Professor(5, 2);
        System.out.println("Professors:");
        System.out.println(Person.findById(p1.getPersonID()).getName() + ": " + (Professor.professorList.indexOf(p1) + 1));
        System.out.println(Person.findById(p2.getPersonID()).getName() + ": " + (Professor.professorList.indexOf(p2) + 1));

        Course math = new Course("Calculus", 3);
        Course physics = new Course("Physics", 4);
        Course circuits = new Course("Circuits", 3);

        int professor1Id = Professor.professorList.indexOf(p1) + 1;
        int professor2Id = Professor.professorList.indexOf(p2) + 1;
        PresentedCourse pc1 = new PresentedCourse(1, professor1Id, 30);
        PresentedCourse pc2 = new PresentedCourse(2, professor1Id, 25);
        PresentedCourse pc3 = new PresentedCourse(3, professor2Id, 20);

        pc1.addStudent(1);
        pc1.addStudent(2);

        pc2.addStudent(1);
        pc2.addStudent(2);
        pc2.addStudent(3);

        pc3.addStudent(3);

        Transcript t1 = new Transcript(s1.getStudentID());
        Transcript t2 = new Transcript(s2.getStudentID());
        Transcript t3 = new Transcript(s3.getStudentID());

        t1.setGrade(1, 18.5);
        t1.setGrade(2, 17.0);

        t2.setGrade(1, 16.0);
        t2.setGrade(2, 15.5);

        t3.setGrade(2, 19.0);
        t3.setGrade(3, 20.0);

        System.out.println("Transcripts:");
        t1.printTranscript();
        t2.printTranscript();
        t3.printTranscript();

        System.out.println("GPA for Student 1: " + t1.getGPA());
        System.out.println("GPA for Student 2: " + t2.getGPA());
        System.out.println("GPA for Student 3: " + t3.getGPA());
    }
}
