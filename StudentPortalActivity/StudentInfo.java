import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
//import java.util.lang;
public class StudentInfo{
    Scanner scan = new Scanner(System.in);
    String fName;
    String lName;
    String bDay;
    String course;


    public void studentName(){
            boolean result1, result2;
            // FIRST NAME VALIDATION
            do {
                // FIRST NAME VALIDATION
                System.out.print("Enter your first name: ");
                fName = scan.next();
                result1 = fName.matches("[a-zA-Z]+");

                if (result1) {

                        if (fName.length() <= 10) {
                            result1 = true;
                            break;
                        }
                        else{
                            System.out.println("Input must not be more than 50 characters.");
                            result1 = false;
                    }

                } else {
                    System.out.println("Invalid Input! Please Try Again.");
                    result1 = false;
                }

            } while (!result1);

        // LAST NAME VALIDATION
        do {
            System.out.print("Enter your last name: ");
            lName = scan.next();
            result2 = lName.matches("[a-zA-Z]+");

            if (result2) {

                if (lName.length() <= 10) {
                    result2 = true;
                    break;
                }
                else{
                    System.out.println("Input must not be more than 50 characters.");
                    result2 = false;
                }

            } else {
                System.out.println("Invalid Input! Please Try Again.");
                result2 = false;
            }

        } while (!result2);
    }


    public void studentBday(){
        boolean validBday;
        do {
            System.out.print("Enter Birthday(yyyy/mm/dd): ");
            bDay = scan.next();
            if (bDay == null || bDay.trim().isEmpty()) {
                System.out.println("Birthday cannot be empty.");
                validBday = false;
            }
            else {
                String birthday_format = "^\\d{4}/(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])$";
                boolean bDayFormat = bDay.matches(birthday_format);

                if (bDayFormat) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate dob = LocalDate.parse(bDay, formatter);
                    LocalDate curDate = LocalDate.now();

                    int age = Period.between(dob, curDate).getYears();
                    if (age >= 16) {
                        validBday = true;
                    } else {
                        System.out.println("Birthdate must be at least 18 years from current date.");
                        validBday = false;
                    }

                } else {
                    System.out.println("Invalid Format Input.");
                    validBday = false;
                }
            }
        } while (!validBday);

    }

    public void studentCourse(){
        boolean courseResult;

        do {
            System.out.print("Enter course: ");
            course = scan.next();
            courseResult = course.matches("[a-zA-Z]+");

            if (courseResult) {
                if (course.length() <= 10) {
                    System.out.println("Your course: " + course);
                    courseResult = true;
                    break;
                }
                else{
                    System.out.println("Input must not be more than 50 characters.");
                    courseResult = false;
                }

            } else {
                System.out.println("Invalid Input! Please Try Again.");
                courseResult = false;
            }

        } while (!courseResult);
    }

    public void studentNumber(){
        char lastnameInitial = lName.charAt(0);
        String studentNum;

        int year = LocalDate. now(). getYear();
        String day = bDay.substring(7).replaceAll("/", "");

        studentNum = year + "-" + day + "01-" + lastnameInitial;
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Student successfully registered!");
        System.out.println("Here's your Student Number: "+studentNum);
        System.out.println("-------------------------------------------------------------------------------");
    }

}

