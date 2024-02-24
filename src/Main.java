import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Library library = new Library();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add a book");
                System.out.println("2. Add a magazine");
                System.out.println("3. Add a newspaper");
                System.out.println("4. Issue an item");
                System.out.println("5. Return an item");
                System.out.println("6. View all items");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline left-over

                switch (choice) {
                    case 1:
                        // Add a book
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        int isbn = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        Book book = new Book(title, author, isbn, genre);
                        library.addItem(book);
                        break;
                    case 2:
                        // Add a magazine
                        System.out.print("Enter title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        isbn = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        System.out.print("Enter publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Enter issue number: ");
                        int issueNumber = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        Magazine magazine = new Magazine(title, author, isbn, publisher, issueNumber);
                        library.addItem(magazine);
                        break;
                    case 3:
                        // Add a newspaper
                        System.out.print("Enter title: ");
                        title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        isbn = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        System.out.print("Enter publisher: ");
                        publisher = scanner.nextLine();
                        System.out.print("Enter date (yyyy-MM-dd): ");
                        String dateString = scanner.nextLine();

                        // Create SimpleDateFormat object with source string date format
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        // Parse the string into Date object
                        Date date = sdf.parse(dateString);

                        Newspaper newspaper = new Newspaper(title, author, isbn, publisher, date);
                        library.addItem(newspaper);
                        break;
                    case 4:
                        // Issue an item
                        System.out.print("Enter ISBN of the item to issue: ");
                        isbn = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        library.issueItem(isbn);
                        break;
                    case 5:

                        // Return an item
                        System.out.print("Enter ISBN of the item to return: ");
                        isbn = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        library.returnItem(isbn);
                        break;
                    case 6:
                        // View all items
                        for (LibraryItem item : library.getItems()) {
                            System.out.println(item);
                        }
                        break;
                    case 7:
                        // Exit
                        System.exit(0);
                }
            }
        }
    }
}
