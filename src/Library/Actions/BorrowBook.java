package Library.Actions;

import Library.Borrowing;
import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;

import java.awt.print.Book;
import java.util.Scanner;

public class BorrowBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookname = s.next();

        int i = database.getBook(bookname);
        if(i >-1){
            Book book = database.getBook(i);
            if(book.getBrwcopies()>1){
                Borrowing borrowing = new Borrowing( book,user);
                book.setBrwcopies(book.getBrwcopies()-1);
                database.BorrowBook(borrowing,book,i);
                System.out.println("You must return the book before 14 days from now\n"+
                        "Expiry date: "+borrowing.getFinish());
            }else{
                System.out.println("This book isn't availble for borrowing");
            }
            else{
                System.out.println("Book does not exist");
            }
            user.menu(database,user);
        }

    }
}
