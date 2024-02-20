import java.util.ArrayList;

public class Borrower extends Person {

    private final ArrayList<HoldRequest> holdRequests;

    public Borrower(int id, String name, String address, int phoneNo) {
        super(id, name, address, phoneNo);
        this.holdRequests = new ArrayList<>();
    }

    public void addHoldRequest(HoldRequest request) {
        holdRequests.add(request);
    }

    public void removeHoldRequest(HoldRequest request) {
        holdRequests.remove(request);
    }

    public ArrayList<HoldRequest> getHoldRequests() {
        return holdRequests;
    }

    @Override
    public String toString() {
        return "Borrower [id=" + id + ", name=" + name + ", address=" + address
                + ", phoneNo=" + phoneNo + ", holdRequests=" + holdRequests + "]";
    }
}
