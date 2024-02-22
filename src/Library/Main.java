package Library;

import Library.Library;
import Library.Users.Admin;
import Library.Users.NormalUser;
import Library.Users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    static Scanner s;
    public static void main(String[] args) {
        System.out.println("Library system \n1.Login\n2.New User");
        s = new Scanner(System.in);
        int n = s.nextInt();

        switch (n) {
            case 1: login();
            case 2: newUser();
            default:
                System.out.println("404");
        }

    }
    private static void login(){
        System.out.println("enter number: ");
        String number = s.next();
        System.out.println("enter email: ");
        String email = s.next();
    }
    private static void newUser(){
        System.out.println("enter name: ");
        String name = s.next();
        System.out.println("enter number: ");
        String number = s.next();
        System.out.println("enter email: ");
        String email = s.next();
        System.out.println("1.Admin\n2.Normal User");
        int n2 = s.nextInt();
        if(n2 == 1){
            User admin = new Admin(name, email, number);
        }else {
            User user = new User(name, email, number);

        }

    }
}