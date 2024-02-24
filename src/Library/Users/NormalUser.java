package Library.Users;

import Library.Actions.PlaceOrder;
import Library.Actions.Search;
import Library.Actions.ViewBooks;
import Library.Interfaces.IOOperation;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),

        };
    }
    public NormalUser(String name, String email, String number){
        super(name, email, number);
    }
    @Override
    public void menu() {
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return book");
        System.out.println("7. Exit");
    }
}
