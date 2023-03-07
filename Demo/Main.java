import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookDatabase book = BookDatabase.getInstance();

        //User input book title
        for(int i=0; i<=3;i++){
            System.out.print("Enter book title: ");
            String input = scan.next();
            book.addBook(input);
        }
        book.viewingBook();

        //User input book number to remove
        System.out.print("Enter book number to remove: ");
        int bookNum = scan.nextInt();
        book.removeBook(bookNum);

        book.viewingBook();
    }
}