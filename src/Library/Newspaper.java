package Library;

import Library.LibraryItem;

import java.util.Date;

class Newspaper extends LibraryItem {
    private String publisher;
    private Date date;

    // Constructor
    public Newspaper(String title, String author, int isbn, String publisher, Date date) {
        super(title, author, isbn);
        this.publisher = publisher;
        this.date = date;
    }

    // Getters and setters for publisher and date
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Library.Newspaper [ " +
                "title: '" + getTitle() + '\'' +
                ", author: '" + getAuthor() + '\'' +
                ", isbn: " + getIsbn() +
                ", isIssued: " + getIsIssued() + ", Publisher: " + publisher +  ", date: " + date + " ]";
    }
}