package Library;

abstract class LibraryItem {
    private String title;
    private String author;
    private int isbn;
    private boolean isIssued;

    // Constructor
    public LibraryItem(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false;
    }

    // Getters and setters encapsulate the properties of the class
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getIsbn() { return isbn; }
    public boolean getIsIssued() { return isIssued; }

    // Method to issue a library item
    public void issue() {
        if (!isIssued) {
            isIssued = true;
        } else {
            System.out.println("The item is already issued.");
        }
    }

    // Method to return a library item
    public void returnItem() {
        if (isIssued) {
            isIssued = false;
        } else {
            System.out.println("The item is already in the library.");
        }
    }

    @Override
    public String toString() {
        return "Library.LibraryItem [ " +
                "title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", isbn: " + isbn +
                ", isIssued: " + isIssued + " ] ";
    }
}
