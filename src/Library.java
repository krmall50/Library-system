import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

class Library {
    private ArrayList<LibraryItem> items;
    private Connection conn;
    public Library() {
        items = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        String sql = "";
        if(item instanceof Book)
            sql = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";
        else if(item instanceof Magazine)
            sql = "INSERT INTO Magazine VALUES (?, ?, ?, ?, ?, ?)";
        else if(item instanceof Newspaper)
            sql = "INSERT INTO Newspaper VALUES (?, ?, ?, ?, ?, ?)";
        executeUpdate(sql, item);
    }

    private void executeUpdate(String sql, LibraryItem item) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getTitle());
            pstmt.setString(2, item.getAuthor());
            pstmt.setInt(3, item.getIsbn());
            pstmt.setBoolean(4, item.getIsIssued());
            if(item instanceof Book) {
                pstmt.setString(5, ((Book) item).getGenre());
            } else {
                pstmt.setString(5, ((Magazine) item).getPublisher());
                if(item instanceof Magazine) {
                    pstmt.setInt(6, ((Magazine) item).getIssueNumber());
                } else {
                    // Convert java.util.Date to java.sql.Date
                    java.sql.Date sqlDate = new java.sql.Date(((Newspaper) item).getDate().getTime());
                    pstmt.setDate(6, sqlDate);
                }
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void issueItem(int isbn) {
        findItem(isbn).ifPresentOrElse(LibraryItem::issue, () -> System.out.println("Item not found."));
    }

    public void returnItem(int isbn) {
        findItem(isbn).ifPresentOrElse(item -> {
            item.returnItem();
            System.out.println(item.getTitle());
        }, () -> System.out.println("Item not found."));
    }

    private Optional<LibraryItem> findItem(int isbn) {
        return items.stream().filter(item -> item.getIsbn() == isbn).findFirst();
    }

    public ArrayList<LibraryItem> getItems() {
        return items;
    }
}
