import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

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

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter title: ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    System.out.print("Enter genre: ");
                    String genre = scanner.next();
                    Book book = new Book(title, author, isbn, genre);
                    library.addItem(book);
                    break;
                case 2:
                    // Add a magazine
                    System.out.print("Enter title: ");
                    title = scanner.next();
                    System.out.print("Enter author: ");
                    author = scanner.next();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextInt();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.next();
                    System.out.print("Enter issue number: ");
                    int issueNumber = scanner.nextInt();
                    Magazine magazine = new Magazine(title, author, isbn, publisher, issueNumber);
                    library.addItem(magazine);
                    break;
                case 3:
                    // Add a newspaper
                    System.out.print("Enter title: ");
                    title = scanner.next();
                    System.out.print("Enter author: ");
                    author = scanner.next();
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextInt();
                    System.out.print("Enter publisher: ");
                    publisher = scanner.next();
                    System.out.print("Enter date (yyyy-MM-dd): ");
                    String dateString = scanner.next();

                    // Create SimpleDateFormat object with source string date format
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    // Parse the string into Date object
                    java.util.Date date = sdf.parse(dateString);

                    Newspaper newspaper = new Newspaper(title, author, isbn, publisher, date);
                    library.addItem(newspaper);

                case 4:
                    // Issue an item
                    System.out.print("Enter ISBN of the item to issue: ");
                    isbn = scanner.nextInt();
                    library.issueItem(isbn);
                    break;
                case 5:
                    // Return an item
                    System.out.print("Enter ISBN of the item to return: ");
                    isbn = scanner.nextInt();
                    library.returnItem(isbn);
                    break;
                case 6:
                    // View all items
                    for (LibraryItem item : library.getItems()) {
                        System.out.println("Title: " + item.getTitle());
                        System.out.println("Author: " + item.getAuthor());
                        System.out.println("ISBN: " + item.getIsbn());
                        System.out.println("Is Issued: " + item.getIsIssued());
                        if (item instanceof Book) {
                            System.out.println("Genre: " + ((Book) item).getGenre());
                        } else if (item instanceof Magazine) {
                            System.out.println("Publisher: " + ((Magazine) item).getPublisher());
                            System.out.println("Issue Number: " + ((Magazine) item).getIssueNumber());
                        } else if (item instanceof Newspaper) {
                            System.out.println("Publisher: " + ((Newspaper) item).getPublisher());
                            System.out.println("Date: " + ((Newspaper) item).getDate());
                        }
                        System.out.println();
                    }
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);


            }
        }

    }
}