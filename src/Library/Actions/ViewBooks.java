package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;

import java.awt.print.Book;
import java.util.ArrayList;

public class ViewBooks implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        ArrayList<Book> books = database.getAllbooks();
        System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\tQty\tPrice"
        +"\tBrw cps");
        for (Book b : books){
         System.out.println(b.getName()+"\t\t"+b.getAuthor()+"\t\t"+b.getPublisher()+"\t\t"+
                 b.getAdress()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+b.getBrwcopies());
        }
        System.out.println();
        user.menu(database, user);
    }
}
