class Book extends LibraryItem {
    private String genre;

    // Constructor
    public Book(String title, String author, int isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    // Getter and setter for genre
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Book [ " +
                "title: '" + getTitle() + '\'' +
                ", author: '" + getAuthor() + '\'' +
                ", isbn: " + getIsbn() +
                ", isIssued: " + getIsIssued() + ", genre: " + genre + " ]";
    }
}