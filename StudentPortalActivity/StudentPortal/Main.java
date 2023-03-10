import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentInfo studInfo = new StudentInfo();
        //String fName, lName;

        System.out.println("WELCOME TO STUDENT PORTAL!");
        System.out.println("Enter your first name: ");
        String fName = scan.next();
        studInfo.studentName(fName);


    }
}