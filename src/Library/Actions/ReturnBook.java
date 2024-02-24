package Library.Actions;

import Library.Database.Database;
import Library.Interfaces.IOOperation;
import Library.Users.User;

import java.awt.print.Book;
import java.util.Scanner;

public class ReturnBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name:");
        Scanner s  = new Scanner(System.in);
        String bookname = s.next();
        if (!database.getBrws().isEmtpy()){
            for(Borrowing b : database.getBrws()){
                if (b.getBook().getName().matches(bookname)&&
                b.getUser().getName().matches(user.getName())){
                    Book book = b.getBook();
                    if(b.getDaysleft()<0){
                        System.out.println("You are late!\n"
                                +"You have to pay " + Math.abs(b.getDaysleft()*50)+" as fine\n");
                    }
                    book.setBrwcopies(book.getBrwcopies()+1);
                    database.returnBook(b, book , i);
                    System.out.println("Book returned\n Thank you!\n");
                    break;
                }else {
                    System.out.println("You didn't borrow this book!\n");
                }
            }
        }else {
            System.out.println("You didn't borrow this book!\n");
        }
        user.menu(database, user);
    }
}
