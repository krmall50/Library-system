import java.util.Date;

public class HoldRequest {

    private Borrower borrower;
    private LibraryItem item;
    private Date requestDate;
    private Date fulfilledDate;

    public HoldRequest(Borrower borrower, LibraryItem item) {
        this.borrower = borrower;
        this.item = item;
        this.requestDate = new Date();
        this.fulfilledDate = null;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LibraryItem getItem() {
        return item;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getFulfilledDate() {
        return fulfilledDate;
    }

    public void fulfillRequest() {
        fulfilledDate = new Date();
    }

    @Override
    public String toString() {
        return "HoldRequest [borrower=" + borrower + ", item=" + item
                + ", requestDate=" + requestDate + ", fulfilledDate="
                + fulfilledDate + "]";
    }
}

