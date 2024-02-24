package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.Admin;
import Library.Users.NormalUser;
import Library.Users.User;

import java.util.Scanner;

public class Exit implements IOOperation {
    Scanner s;
    Database database;
    User user;


    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;
        System.out.println("\nAre you sure that you want to quit?\n"
        + "1. Yes\n2. Main Menu");
        s = new Scanner(System.in);
        int i = s.nextInt();
        if(i==1){
            s.close();
        }else {
            user.menu(database, user);
        }

    }
    private void login() {
        System.out.println("enter number: ");
        String number = s.next();
        System.out.println("enter email: ");
        String email = s.next();
        int n = database.login(number, email);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database, user);
        } else {
            System.out.println("User doesn't exist");
        }
    }
    private void newUser() {
        System.out.println("enter name: ");
        String name = s.next();
        System.out.println("enter number: ");
        String number = s.next();
        System.out.println("enter email: ");
        String email = s.next();
        System.out.println("1.Admin\n2.Normal User");
        int n2 = s.nextInt();
        User user;
        if (n2 == 1) {
            user = new Admin(name, email, number);
        } else {
            user = new NormalUser(name, email, number);
        }
        database.addUser(user);
        user.menu(database, user);

    }
}

