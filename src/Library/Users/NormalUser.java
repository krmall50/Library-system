package Library.Users;

import Library.Actions.*;
import Library.Database.Database;
import Library.Interfaces.IOOperation;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }
    public NormalUser(String name, String email, String number){
        super(name, email, number);
        this.operations = new IOOperation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }
    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View Books");
        System.out.println("2. Search");
        System.out.println("3. Place order");
        System.out.println("4. Borrow Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return book");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }
}
