class Magazine extends LibraryItem {
    private String publisher;
    private int issueNumber;

    // Constructor
    public Magazine(String title, String author, int isbn, String publisher, int issueNumber) {
        super(title, author, isbn);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    // Getters and setters for publisher and issueNumber
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public String toString() {
        return "Magazine [ " +
                "title: '" + getTitle() + '\'' +
                ", author: '" + getAuthor() + '\'' +
                ", isbn: " + getIsbn() +
                ", isIssued: " + getIsIssued() + ", Publisher: " + publisher +  ", issueNumber: " + issueNumber + " ]";
    }
}
