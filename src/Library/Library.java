package Library;

import java.sql.*;
import java.util.ArrayList;
class Library {
    private ArrayList<LibraryItem> items;
    private Connection conn;

    // Constructor
    public Library() {}

    // Method to add an item to the library
    public void addItem(LibraryItem item) {
        items.add(item);
        // Add the item to the database
        try {
            Statement stmt = conn.createStatement();
            if(item instanceof Book)
                stmt.executeUpdate("INSERT INTO Book VALUES ('" + item.getTitle() + "', '" + item.getAuthor() + "', " + item.getIsbn() + ", " + item.getIsIssued() + ", '" + ((Book) item).getGenre() + "')");
            else if(item instanceof Magazine)
                stmt.executeUpdate("INSERT INTO Magazine VALUES ('" + item.getTitle() + "', '" + item.getAuthor() + "', " + item.getIsbn() + ", " + item.getIsIssued() + ", '" + ((Magazine) item).getPublisher() + "', " + ((Magazine) item).getIssueNumber() + ")");
            else if(item instanceof Newspaper)
                stmt.executeUpdate("INSERT INTO Newspaper VALUES ('" + item.getTitle() + "', '" + item.getAuthor() + "', " + item.getIsbn() + ", " + item.getIsIssued() + ", '" + ((Newspaper) item).getPublisher() + "', '" + ((Newspaper) item).getDate() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to issue an item
    public void issueItem(int isbn) {
        for (LibraryItem item : items) {
            if (item.getIsbn() == isbn) {
                item.issue();
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Method to return an item
    public void returnItem(int isbn) {
        for (LibraryItem item : items) {
            if (item.getIsbn() == isbn) {
                item.returnItem();
                System.out.println(item.getTitle());
                return;
            }
        }
        System.out.println("Item not found.");
    }
    public ArrayList<LibraryItem> getItems() {
        return items;
    }

}