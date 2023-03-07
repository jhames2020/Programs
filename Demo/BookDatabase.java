import java.util.HashMap;
import java.util.Map;


public class BookDatabase {
    private static BookDatabase instance;

    Map<Integer, String> bookMap;
    private int bookID;
    public BookDatabase() {
        bookMap = new HashMap<>();
        bookID = 1;
    }
    //
    public static BookDatabase getInstance() {
        if (instance == null) {
            instance = new BookDatabase();
        }
        return instance;
    }

    public void addBook(String book){
        this.bookMap.put(bookID, book);
        bookID++;
    }

    public void viewingBook(){
        System.out.println("BOOKS AVAILABLE:");
        for (Map.Entry<Integer, String> entry : bookMap.entrySet()) {
            System.out.println("("+ entry.getKey() + ") " + entry.getValue());
        }
    }

    public void removeBook(int bookID){
        System.out.println("The Book '" + bookMap.remove(bookID) + "' is remove.");


    }
}