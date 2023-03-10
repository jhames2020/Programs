import java.util.Scanner;

public class SchoolPortal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentInfo studInfo = new StudentInfo();
        String fName, lName;

        System.out.println("WELCOME TO STUDENT PORTAL!");

        studInfo.studentName();
        studInfo.studentBday();
        studInfo.studentCourse();
        studInfo.studentNumber();
    }
}