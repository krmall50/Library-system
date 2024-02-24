package Library.Users;

import Library.Actions.*;
import Library.Interfaces.IOOperation;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.operations = new IOOperation[]{
                new AddBook(),
                new ViewBooks(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }

    public Admin(String name, String email, String number) {
        super(name, email, number);
        this.operations = new IOOperation[]{
                new AddBook(),
                new ViewBooks(),
                new DeleteBook(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }

    @Override
    public void menu() {
        System.out.println("1. View Books");
        System.out.println("2. Add Books");
        System.out.println("3. Delete Books");
        System.out.println("4. Search");
        System.out.println("5. Delete all data");
        System.out.println("6. View orders");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper();

    }

}
