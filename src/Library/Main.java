package Library;

import Library.Database.Database;
import Library.Users.Admin;
import Library.Users.NormalUser;
import Library.Users.User;

import java.util.Scanner;

public class Main {
    static Scanner s;
    static Database database;


    public static void main(String[] args) {
        database = new Database();
        System.out.println("Library system!");
        int num;
        do {
            System.out.println("0.Exit \n1.Login\n2.New User");
            s = new Scanner(System.in);
            num = s.nextInt();

            switch (num) {
                case 1:
                    login();
                case 2:
                    newUser();
            }
        } while (num!=0);

    }

    private static void login() {
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

    private static void newUser() {
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